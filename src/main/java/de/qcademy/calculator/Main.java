package de.qcademy.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern plusOpattern = Pattern.compile("\\s*(\\d+)\\s*\\+\\s*(\\d+)|\\s*\\+\\s*(\\d+)|\\s*(\\d+)");
        Pattern minusOpattern = Pattern.compile("\\s*(\\d+)\\s*-\\s*(\\d+)|\\s*-\\s*(\\d+)|\\s*(\\d+)");
        Pattern quitPattern = Pattern.compile("^\\s*:q\\s*$");

        boolean calculatorStopped = false;
        while (!calculatorStopped) {
            System.out.print("Ausdruck eingeben: ");
            String input = scanner.nextLine();
            Matcher plusOpMatcher = plusOpattern.matcher(input);
            Matcher minusOpMatcher = minusOpattern.matcher(input);
            Matcher quitMatcher = quitPattern.matcher(input);

            if (plusOpMatcher.matches()) {
                performAddition(plusOpMatcher, input);
            } else if (minusOpMatcher.matches()) {
                performSubtraction(minusOpMatcher, input);
            } else if (quitMatcher.matches()) {
                System.out.println("Taschenrechner wird gestoppt...");
                calculatorStopped = true;
            } else {
                System.err.println("Operation: " + input + " nicht erkannt!");
            }
        }
    }

    private static void performAddition(Matcher matcher, String input) {
        if (matcher.group(4) != null) {
            double result = Double.parseDouble(matcher.group(4));
            System.out.println(input + " = " + result);
        } else if (matcher.group(3) != null) {
            double result = Double.parseDouble(matcher.group(3));
            System.out.println(input + " = " + result);
        } else {
            double firstOperand = Double.parseDouble(matcher.group(1));
            double secondOperand = Double.parseDouble(matcher.group(2));
            double result = firstOperand + secondOperand;
            System.out.println(input + " = " + result);
        }
    }

    private static void performSubtraction(Matcher matcher, String input) {
        if (matcher.group(4) != null) {
            double result = Double.parseDouble(matcher.group(4));
            System.out.println(input + " = " + result);
        } else if (matcher.group(3) != null) {
            double result = Double.parseDouble(matcher.group(3)) * -1;
            System.out.println(input + " = " + result);
        } else {
            double firstOperand = Double.parseDouble(matcher.group(1));
            double secondOperand = Double.parseDouble(matcher.group(2));
            double result = firstOperand - secondOperand;
            System.out.println(input + " = " + result);
        }
    }
}
