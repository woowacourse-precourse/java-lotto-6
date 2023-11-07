package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(readLine());
            validatePurchaseAmount(purchaseAmount);
        } catch (NumberFormatException e) {
            validateNumber();
        }
        return purchaseAmount;
    }

    public static List<Integer> inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNum = readLine().split(",");

        List<Integer> nums = new ArrayList<>();
        try {
            for (String num : winningNum) {
                int number = Integer.parseInt(num);
                validateLottoNum(number);
                validateDuplicateNum(number, nums);
                nums.add(number);
            }
        } catch (NumberFormatException e) {
            validateNumber();
        }
        return nums;
    }

    public static void validateDuplicateNum(int number, List<Integer> nums) {
        if (nums.contains(number)) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    public static void validateLottoNum(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("각 번호는 1~45사이 값이여야 합니다.");
        }
    }

    public static void validateNumber() {
        throw new IllegalArgumentException("입력 값은 정수여야 합니다.");
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다");
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1000원 보다 커야합니다.");
        }
    }
}

