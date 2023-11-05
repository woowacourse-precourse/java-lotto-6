package lotto.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    public static int getPurchaseAmount(Scanner scanner) {
        int amount;
        while (true) {
            try {
                System.out.print("구입 금액을 입력해 주세요.\n");
                amount = Integer.parseInt(scanner.nextLine());

                if (amount % 1000 == 0) {
                    break;
                } else {
                    System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
        return amount;
    }


    public static List<Integer> getWinningNumbers(Scanner scanner) {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() != 6) {
            try {
                System.out.print("당첨 번호를 입력해 주세요.\n");
                String input = scanner.nextLine();
                String[] numbers = input.split(",");

                if (numbers.length != 6) {
                    System.out.println("[ERROR] 6개의 번호를 입력해야 합니다.");
                    continue;
                }

                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num < 1 || num > 45) {
                        System.out.println("[ERROR] 1~45 사이의 번호를 입력해야 합니다.");
                        winningNumbers.clear();
                        break;
                    } else {
                        winningNumbers.add(num);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                winningNumbers.clear();
            }
        }
        return winningNumbers;
    }

    public static int getBonusNumber(Scanner scanner) {
        int bonusNumber;
        while (true) {
            try {
                System.out.print("보너스 번호를 입력해 주세요.\n");
                bonusNumber = Integer.parseInt(scanner.nextLine());

                if (bonusNumber >= 1 && bonusNumber <= 45) {
                    break;
                } else {
                    System.out.println("[ERROR] 1~45 사이의 번호를 입력해야 합니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
        return bonusNumber;
    }
}
