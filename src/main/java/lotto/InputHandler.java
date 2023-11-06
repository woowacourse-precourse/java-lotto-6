package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(Console.readLine().trim());
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 가능합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("로또 구입금액은 하나의 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] parts = Console.readLine().trim().split(",");
                if (parts.length != 6) {
                    throw new IllegalArgumentException("정확히 쉼표(,)를 기준으로 6개의 번호를 입력해 주세요.");
                }
                List<Integer> numbers = new ArrayList<>();
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    numbers.add(number);
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }


    public static int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}