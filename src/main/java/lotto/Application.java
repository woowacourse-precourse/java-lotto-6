package lotto;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        printResult();
    }

    public static void printResult() {
        for (WinningResult result : WinningResult.values()) {
            System.out.println(result.getPhrase() + " - " + result.getCount() + "개");
        }
    }

}
