package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static List<Integer> inputWinNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return validateWinNumsInput(Console.readLine());
    }

    public static int inputBonusNum(List<Integer> winNums) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return validateBonusNumInput(Console.readLine(), winNums);
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePriceInput(Console.readLine());
    }

    public static List<Integer> validateWinNumsInput(String winNumsInput) {
        return null;
    }

    public static int validateBonusNumInput(String bonusNumInput, List<Integer> winNums) {
        try {
            Integer bonusNum = Integer.valueOf(bonusNumInput);
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winNums.contains(bonusNum)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
            }
            return bonusNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 타입의 입력입니다.");
        }
    }

    public static int validatePriceInput(String priceInput) {
        try {
            Integer price = Integer.valueOf(priceInput);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 타입의 입력입니다.");
        }
    }
}
