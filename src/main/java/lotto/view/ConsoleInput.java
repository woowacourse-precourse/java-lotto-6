package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.model.WinningNumbers;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount() {
        while (true) {
            System.out.print("구입금액을 입력해 주세요.\n");
            try {
                int purchaseAmount = Integer.parseInt(scanner.nextLine());
                if (purchaseAmount % 1000 != 0) {
                    System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.\n");
                } else {
                    return purchaseAmount;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 입력입니다.");
            }
        }
    }

    public WinningNumbers getWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.\n");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(",");

        if (numberStrings.length != 6) {
            System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
            return getWinningNumbers();
        }

        List<Integer> winningNumbers = new ArrayList<>();
        boolean invalidInput = false;

        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString);
                if (number < 1 || number > 45) {
                    System.out.println("[ERROR] 숫자 범위는 1~45 사이여야 합니다.");
                    invalidInput = true;
                    break;
                }
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 입력입니다.");
                invalidInput = true;
                break;
            }
        }

        if (!invalidInput) {
            int bonusNumber = getBonusNumber();
            return new WinningNumbers(winningNumbers, bonusNumber);
        }

        return getWinningNumbers();
    }

    public int getBonusNumber() {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요.\n");
                int bonusNumber = Integer.parseInt(scanner.nextLine());

                if (bonusNumber < 1 || bonusNumber > 45) {
                    System.out.println("[ERROR] 숫자 범위는 1~45 사이여야 합니다.");
                } else {
                    return bonusNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 입력입니다.");
            }
        }
    }
}
