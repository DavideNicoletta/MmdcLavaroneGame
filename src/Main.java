import UI.Launch;

import java.net.MalformedURLException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            new Launch();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    }
