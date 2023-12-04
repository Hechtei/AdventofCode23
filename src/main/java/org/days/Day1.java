package org.days;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day1 {



    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input();
        Scanner scanner = input.getScanner();
        int output= 0;

        while (scanner.hasNextLine()){
            String inputLine = scanner.nextLine();
             System.out.println(processStringTwo(inputLine));
             output = output + processStringTwo(inputLine);
        }
        System.out.println(output);
    }


    public static String  processStringOne(String inputLine) {
        String output = "";
        String firstItem = "";
        String lastItem = "";
        for (int i = 0; i < inputLine.length(); i++) {
            Character c = inputLine.charAt(i);
            if (Character.isDigit(c)) {
                if(firstItem.isEmpty()){
                    firstItem = c.toString();
                }
                lastItem = c.toString();
            }
        }
        output = firstItem + lastItem;
        return output;
    }

    public static int processStringTwo(String inputLine){
        String output = "";
        String firstItem = "";
        String lastItem ="";
        int firstposition = -1;
        int lastposition = -1;
        int current = 0;

        String[] strings = {"one", "two", "three", "four", "five", "six", "seven", "eight","nine"};
        String[] numbers = {"1","2","3","4","5","6","7","8","9"};
        List<String> strings1 = Arrays.stream(strings).toList();
        StringBuilder stringBuilder = new StringBuilder(inputLine);

            for(String n : strings1){
                int amount= 0;
                if(inputLine.contains(n)){
                    int i= containsMoreThanOne(inputLine,n);
                    if(i==1){
                        current = stringBuilder.indexOf(n);
                        if(firstposition == -1 || current < firstposition){
                            firstposition = current;
                            firstItem = numbers[strings1.indexOf(n)];
                        }
                        if (lastposition == -1|| current > lastposition) {
                            lastposition = current;
                            lastItem = numbers[strings1.indexOf(n)];;
                        }

                    }

                    if(i>1){

                        while(i>0){
                            i--; // HIER PLUS IRGENDWAS BEI AMOUNTT

                            current = stringBuilder.indexOf(n,amount);
                            if(firstposition == -1 || current < firstposition){
                                firstposition = current;
                                firstItem = numbers[strings1.indexOf(n)];
                            }
                            if (lastposition == -1|| current > lastposition) {
                                lastposition = current;
                                lastItem = numbers[strings1.indexOf(n)];;
                            }

                            amount = current +1 ;

                        }
                    }
                        }
                    }


        for (int j = 0; j < inputLine.length(); j++) {
            Character c = inputLine.charAt(j);
            if (Character.isDigit(c)) {
                if (firstItem.isEmpty() || j < firstposition) {
                    firstItem = c.toString();
                    firstposition = j;
                }
                if (lastItem.isEmpty() || j > lastposition) {
                    lastItem = c.toString();
                    lastposition = j;
                }
            }
        }

        output = firstItem+lastItem;
        return Integer.parseInt(output);
    }

    public static int containsMoreThanOne(String input, String n){
        int tmp =0;
        StringBuilder stringBuilder = new StringBuilder(input);
        int index = stringBuilder.indexOf(n);
        while (index != -1) {
            tmp++;

            stringBuilder.delete(0, index + n.length());
            index = stringBuilder.indexOf(n);
        }

        return tmp;
    }

}

