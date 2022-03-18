package ru.shatsckij.forms;

import ru.shatsckij.mainFrame.ITask;
import ru.shatsckij.mainFrame.IVariant;

public class Form_7 implements ITask {
    static IVariant[] variants = {
            new Form_7_25(),
        new Form_7_30()
    };
    @Override
    public String toString() {
        return "Задание 7";
    }
    @Override
    public IVariant[] GetVariants() {
        return variants;
    }
}
