package org.labs.cli;

import org.labs.rpn.RPNCalculator;

import java.util.Scanner;

public class Cli {
    private final String HELP = "help";
    private final String EXIT = "exit";
    RPNCalculator rpnCalculator = new RPNCalculator();

    public static void main(String[] args) {
        System.out.println("\n================RPN CALCULATOR=================\n");

        Cli cli = new Cli();
        cli.helper();
        System.out.println(" Good bye :) !");
    }

    private void helper() {
        boolean done = false;
        while (!done) {
            System.out.println("Enter your input or type '"+HELP+"' to see some examples, type '"+EXIT+"' to finish the calculator\n");
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            done = executeCommand(value);
        }
    }

    private boolean executeCommand(String value) {
        if (value.equals("exit")){
            return true;
        }

        if (value.equals("help")) {
            System.out.println("========== Some examples how to use it ==============");
            System.out.println("4 5 + ==> 9");
            System.out.println("2 2 - ==> 0");
            System.out.println("4 sqrt ==> 2");
            System.out.println("1 2 3 4 5 * * * * ==> 120");
            System.out.println("=================================");
        } else {
            String[] values = value.split(" ");
            rpnCalculator.executeCommand(values);
        }
        return false;
    }
}
