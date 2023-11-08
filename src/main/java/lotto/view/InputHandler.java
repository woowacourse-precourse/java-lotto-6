package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int amount = Integer.parseInt(readLine());
                validateThousand(amount);
                validatePositive(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 금액을 입력하세요. (구입금액은 1000원 단위이며, 양수이어야 합니다.)");
            }
        }
    }

    public static List<Integer> inputWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNum = readLine();
                List<Integer> lottoNums = parseWinningNums(winningNum);
                validateUnique(lottoNums);
                return lottoNums;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (로또 번호는 쉼표로 구분되며, 1부터 45까지의 숫자여야 합니다.)");
            }
        }
    }

    public static int inputBonusNum(List<Integer> winningNums) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNum = Integer.parseInt(readLine());
                validateRange(bonusNum);
                winningNums.add(bonusNum);
                validateUnique(winningNums);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (보너스 번호는 1부터 45까지의 숫자이어야 합니다.)");
            }
        }
    }

    public static void validateThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseWinningNums(String input) {
        String[] nums = input.split(",");
        List<Integer> winningNums = new ArrayList<>();

        for (String num : nums) {
            validateEmpty(num);
            validateNumeric(num);
            winningNums.add(Integer.parseInt(num.trim()));
        }
        return winningNums;
    }

    public static void validateEmpty(String num) {
        String trimmedNum = num.trim();

        if (trimmedNum.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    public static void validateUnique(List<Integer> nums) {
        Set<Integer> uniqueNums = new HashSet<>(nums);

        if (uniqueNums.size() != nums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validatePositive(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 올바른 범위의 숫자를 입력하세요.");
        }
    }
}
