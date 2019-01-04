package com.fashare.gradle_plugin;

import com.android.build.api.transform.Format;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.gradle.internal.pipeline.TransformManager;
import com.android.utils.FileUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;
import java.util.Set;

class HelloTransform extends Transform {
    private Project mProject;

    public HelloTransform(Project project) {
        mProject = project;
    }

    @Override
    public String getName() {
        return "HelloTransform";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return false;
    }

    /**
     * https://www.jianshu.com/p/804d79415258
     */
    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);

        transformInvocation.getInputs().forEach(input -> {
            //遍历文件夹
            input.getDirectoryInputs().forEach(directoryInput -> {
                //注入代码
                try {
                    InjectClass.inject(directoryInput.getFile().getAbsolutePath(), mProject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 获取output目录
                File destFile = transformInvocation.getOutputProvider()
                        .getContentLocation(directoryInput.getName(), directoryInput.getContentTypes(), directoryInput.getScopes(), Format.DIRECTORY);
                // 将input的目录复制到output指定目录
                println("outputPath = " + destFile);
                try {
                    FileUtils.copyDirectory(directoryInput.getFile(), destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            //遍历jar文件 对jar不操作，但是要输出到out路径
            input.getJarInputs().forEach(jarInput -> {
                // 重命名输出文件（同名文件copyFile会冲突）
                String jarName = jarInput.getName();
                println("jarInputPath = " + jarInput.getFile().getAbsolutePath());
                String md5Name = DigestUtils.md5Hex(jarInput.getFile().getAbsolutePath());
                if (jarName.endsWith(".jar")) {
                    jarName = jarName.substring(0, jarName.length() - 4);
                }
                File dest = transformInvocation.getOutputProvider()
                        .getContentLocation(jarName + md5Name, jarInput.getContentTypes(), jarInput.getScopes(), Format.JAR);
                println("jarOutputPath = " + dest);
                try {
                    FileUtils.copyFile(jarInput.getFile(), dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private static void println(String msg) {
        System.out.println(msg);
    }
}
