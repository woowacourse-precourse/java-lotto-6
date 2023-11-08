package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {
    public static int inputPurchaseAmount() {
        int amount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                amount = Integer.parseInt(readLine());
                validateThousand(amount);
                validatePositive(amount);
                break;  // 정상적인 입력이면 루프를 빠져나감
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 금액을 입력하세요. (구입금액은 1000원 단위이며, 양수이어야 합니다.)");
            }
        }
        System.out.println();
        return amount;
    }

    public static List<Integer> inputWinningNumber() {
        List<Integer> lottoNums;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNum = readLine();
                lottoNums = parseWinningNums(winningNum);
                validateUnique(lottoNums);
                break;  // 정상적인 입력이면 루프를 빠져나감
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (로또 번호는 쉼표로 구분되며, 1부터 45까지의 숫자여야 합니다.)");
            }
        }
        System.out.println();
        return lottoNums;
    }

    public static int inputBonusNum(List<Integer> winningNums) {
        int bonusNum;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNum = Integer.parseInt(readLine());
                validateRange(bonusNum);
                winningNums.add(bonusNum);
                validateUnique(winningNums);
                break;  // 정상적인 입력이면 루프를 빠져나감
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 번호를 입력하세요. (보너스 번호는 1부터 45까지의 숫자이어야 합니다.)");
            }
        }
        return bonusNum;
    }


    private static void validateThousand(int amount) {
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

    private static void validateEmpty(String num) {
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


    private static void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validatePositive(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }
    private static void validateNumeric(String input) {
        boolean isNumeric = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                isNumeric = false;
                break;
            }
        }

        if (!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 올바른 범위의 숫자를 입력하세요.");
        }
    }
}
