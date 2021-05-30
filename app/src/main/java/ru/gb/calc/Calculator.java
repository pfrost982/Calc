package ru.gb.calc;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator {
    private final StringBuilder calcString;

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
        if(getCalcString() == "") {
            return;
        }
        String result = calcString.toString();
        result = result.replaceAll("x", "*");
        result = result.replaceAll("%", "/100");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);
        String finalResult;

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, result, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "Error!";
        }
        Context.exit();
        calcString.setLength(0);
        calcString.append(finalResult);
    }
}
