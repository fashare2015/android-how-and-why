package com.fashare.gradle_plugin;

import org.gradle.api.Project;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

class InjectClass {
    private final static ClassPool pool = ClassPool.getDefault();

    static void inject(String path, Project project) throws Exception {

        println("inputPath = " + path);
        //将当前路径加入类池,不然找不到这个类
        pool.appendClassPath(path);
//        project.android.bootClasspath 加入android.jar，不然找不到android相关的所有类
//        pool.appendClassPath(project.android.bootClasspath[0].toString())

        File dir = new File(path);
        //遍历文件夹
        dfs(dir, file -> {
            if (file.getName().equals("App.class")) {
                try {
                    //获取 App.class
                    CtClass ctClass = pool.getCtClass("com.fashare.android_how_and_why.App");
                    println("ctClass = " + ctClass);
                    //解冻
                    if (ctClass.isFrozen()) ctClass.defrost();
                    //获取到OnCreate方法
                    CtMethod ctMethod = ctClass.getDeclaredMethod("onCreate");
//                    String injectCode = "android.widget.Toast.makeText(this,\"Hello, 插件注入Toast!!\",android.widget.Toast.LENGTH_SHORT).show();";
                    String injectCode = "java.lang.System.out.println(\"Hello, 插件注入Log!!\");";
                    println("方法名 = " + ctMethod);
                    println("injectCode = " + injectCode);
                    //在方法开始注入代码
                    ctMethod.insertBefore(injectCode);
                    ctClass.writeFile(path);
                    ctClass.detach();   //释放
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void dfs(File rootFile, Consumer<? super File> consumer) {
        if (rootFile.isDirectory()) {
            Arrays.stream(rootFile.listFiles()).forEach(file -> {
                dfs(file, consumer);
            });
        } else {
            consumer.accept(rootFile);
        }
    }

    private static void println(String msg) {
        System.out.println(msg);
    }
}
