package org.days;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        Input input = new Input();
        Scanner scanner = input.getScanner();
        int counter = 0;
        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            counter = counter + processStringPart2(in);
            System.out.println(counter);
        }

    }


    public static int processStringPart1(String input) {
        int output = 0;

        String[] firstsplit = input.split(":");
        String[] secondsplit = firstsplit[0].split(" ");
        String id = secondsplit[1];

        String[] games = firstsplit[1].split(";");

        for (String g : games) {
            if (impossibleGame(g)) {
                output = Integer.parseInt("0");
                break;
            } else {
                output = Integer.parseInt(id);
            }
        }
        return output;
    }

    public static boolean impossibleGame(String input) {
        int red = 12;
        int green = 13;
        int blue = 14;
        boolean impossible = false;
        String[] drawings = input.split(",");
        for (String s : drawings) {
            s = s.stripLeading();
            String[] lastsplit = s.split(" ");
            for (int i = 0; i < lastsplit.length - 1; i++) {
                if (lastsplit[i + 1].equals("blue") && Integer.parseInt(lastsplit[i]) > blue) {
                    impossible = true;
                }
                if (lastsplit[i + 1].equals("red") && Integer.parseInt(lastsplit[i]) > red) {
                    impossible = true;
                }
                if (lastsplit[i + 1].equals("green") && Integer.parseInt(lastsplit[i]) > green) {
                    impossible = true;
                }
            }
        }
        return impossible;
    }
    //part 2

    public static int processStringPart2(String input) {
        int minimumBlue = 0;
        int minimumRed = 0;
        int minimumGreen = 0;
        int power = 0;
        String[] firstsplit = input.split(":");
        String[] secondsplit = firstsplit[0].split(" ");


        String[] games = firstsplit[1].split(";");

        for (String g : games) {
            String[] drawings = g.split(",");
            for (String s : drawings) {
                s = s.stripLeading();
                String[] lastsplit = s.split(" ");
                for (int i = 0; i < lastsplit.length - 1; i++) {
                    if (lastsplit[i + 1].equals("blue") && minimumBlue <= Integer.parseInt(lastsplit[i])) {
                        minimumBlue = Integer.parseInt(lastsplit[i]);
                    }
                    if (lastsplit[i + 1].equals("red") && minimumRed <= Integer.parseInt(lastsplit[i])) {
                        minimumRed = Integer.parseInt(lastsplit[i]);
                    }
                    if (lastsplit[i + 1].equals("green") && minimumGreen <= Integer.parseInt(lastsplit[i])) {
                        minimumGreen = Integer.parseInt(lastsplit[i]);

                    }
                }
            }
        }
        power = minimumBlue * minimumGreen * minimumRed;
        return power;
    }

}