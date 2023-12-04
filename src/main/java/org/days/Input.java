package org.days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

    File file = new File("C:\\Users\\hecht\\OneDrive\\Desktop\\AdventOfCode2023\\src\\main\\resources\\input");
    Scanner scanner = new Scanner(file);


    public Input() throws FileNotFoundException {
    }
    public Scanner getScanner() {
        return scanner;
    }
}
