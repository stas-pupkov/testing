package ru.pupkov.stas.base;

import org.junit.internal.JUnitSystem;
import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.PrintStream;

public class CustomTextListener extends TextListener {

    public CustomTextListener(JUnitSystem system) {
        super(system);
    }

    public CustomTextListener(PrintStream writer) {
        super(writer);
    }

    @Override
    public void testStarted(Description description) {
        System.out.println("Starting: " + description.getTestClass().getSimpleName());
    }

    @Override
    public void testFailure(Failure failure) {
        Result result = new Result();
        result.getFailures().add(failure);

        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    @Override
    public void testIgnored(Description description) {
        System.out.println("Ignored: " + description.getTestClass().getSimpleName());
    }
}
