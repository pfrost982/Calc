package ru.gb.calc;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator {
    private StringBuilder calcString;

    public Calculator(String str) {
        this.calcString = new StringBuilder(str);
    }

    public String getCalcString() {
        return calcString.toString();
    }

    public void appendString(String str) {
        calcString.append(str);
    }

    public void clear() {
        calcString.setLength(0);
    }

    public void calculateResult() {
        calcString.setLength(0);
        calcString.append("Result!!!");
    }

}
