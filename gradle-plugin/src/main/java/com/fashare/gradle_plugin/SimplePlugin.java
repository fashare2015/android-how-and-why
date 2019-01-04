package com.fashare.gradle_plugin;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * https://www.jianshu.com/p/804d79415258
 */
class SimplePlugin implements Plugin<Project>{
    @Override
    public void apply(Project project) {
        //AppExtension对应build.gradle中android{...}
        AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);

        appExtension.registerTransform(new HelloTransform(project));
    }
}
