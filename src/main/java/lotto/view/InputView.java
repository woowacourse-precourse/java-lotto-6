package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.print("구입 금액을 입력하세요 (1,000원 단위): ");
                int purchaseAmount = Integer.parseInt(Console.readLine());

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
                }

                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자 형식이 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.print("당첨 번호를 입력하세요 (1부터 45까지의 숫자 중복없이 콤마(,)로 구분): ");
                String input = Console.readLine();
                List<Integer> numbers = parseInputNumbers(input);

                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("6개의 당첨 번호를 입력해야 합니다.");
                }

                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.print("보너스 볼을 입력하세요 (1부터 45까지의 숫자): ");
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자 형식이 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<Integer> parseInputNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] inputArray = input.split(",");
            for (String num : inputArray) {
                int number = Integer.parseInt(num.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("당첨 번호는 1부터 45까지의 숫자여야 합니다.");
                }
                numbers.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
        return numbers;
    }
}
