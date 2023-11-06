package lotto.View;

import java.util.List;
import java.util.Scanner;
public class LottoView {
    private Scanner scanner = new Scanner(System.in);

    public int getUserInput(String message) {
        int userInput = 0;
        while (true) {
            try {
                System.out.print(message);
                userInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                displayError("올바른 숫자를 입력하세요.");
            }
        }
        return userInput;
    }

    public void displayResults(List<String> results) {
        System.out.println("당첨 결과 및 수익률:");
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void displayError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}


