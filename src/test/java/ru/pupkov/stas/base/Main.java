package ru.pupkov.stas.base;

import org.junit.internal.RealSystem;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();

        RunListener listener = new CustomTextListener(new RealSystem());
        jUnitCore.addListener(listener);

        String[] classes = getClassesInPackage("ru.pupkov.stas");

        Class[] classes1 = Stream.of(classes).map(clazz -> {
            try {
                return Class.forName(clazz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new Object().getClass();
        }).collect(Collectors.toList()).toArray(new Class[0]);

        Request request = Request.classes(classes1);
        jUnitCore.run(request);
        
    }

    public static String[] getClassesInPackage(String packageName) {
        List<String> classes = new ArrayList<>();
        String[] classPathEntries = System.getProperty("java.class.path").split(
                System.getProperty("path.separator")
        );

        String name;
        try {
            for (String classpathEntry : classPathEntries) {
                if (classpathEntry.endsWith(".jar")) {
                    File jar = new File(classpathEntry);
                    JarInputStream is = new JarInputStream(new FileInputStream(jar));
                    JarEntry entry;
                    while ((entry = is.getNextJarEntry()) != null) {
                        name = entry.getName().replaceAll("[\\|/]", ".");
                        if (name.contains(packageName) && name.endsWith("Test.class")) {
                            String classPath = name.substring(0, entry.getName().length() - 6);
                            classes.add(classPath);
                        }
                    }
                } else {
                    File base = new File(classpathEntry + File.separatorChar + packageName.replaceAll("\\.", "/"));
                    List<Path> allFiles;
                    try (Stream<Path> paths = Files.walk(Paths.get(base.getPath()))) {
                        allFiles = paths.filter(Files::isRegularFile).collect(Collectors.toList());
                    }
                    for (Path file : allFiles) {
                        name = file.toFile().getAbsolutePath().replaceAll("[\\|/]", ".");
                        int startIndex = name.indexOf(packageName);
                        if (name.endsWith("Test.class") && startIndex > -1) {
                            name = name.substring(startIndex, name.length() - 6);
                            classes.add(name);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes.toArray(new String[0]);
    }
}
