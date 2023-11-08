package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        while (true) {
            System.out.println("구매 금액을 입력해주세요.");
            String input = Console.readLine();
            try {
                int amount = Integer.parseInt(input);
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형태의 금액을 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해주세요.");
            String line = Console.readLine();
            String[] parts = line.split(",");
            try {
                List<Integer> winningNumbers = new ArrayList<>();
                for (String part : parts) {
                    int number = Integer.parseInt(part.trim());
                    winningNumbers.add(number);
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 번호는 정수여야 합니다.");
            }
        }
    }

    public static int getBonusNumber() {
        while(true){
            System.out.println("\n보너스 번호를 입력해주세요.");
            try {
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 정수여야 합니다.");
            }
        }
    }
}

