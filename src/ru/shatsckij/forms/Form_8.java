package ru.shatsckij.forms;

import ru.shatsckij.mainFrame.ITask;
import ru.shatsckij.mainFrame.IVariant;

public class Form_8 implements ITask {
    static IVariant[] variants = {
            new Form_8_15(),
            new Form_8_23()
    };

    @Override
    public String toString() {
        return "Задание 8";
    }

    @Override
    public IVariant[] GetVariants() {
        return variants;
    }
}
