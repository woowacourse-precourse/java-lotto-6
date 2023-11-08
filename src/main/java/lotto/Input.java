package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    public static List<Integer> inputWinNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return validateWinNumsInput(Console.readLine());
    }

    public static int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return validateBonusNumInput(Console.readLine());
    }

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePriceInput(Console.readLine());
    }

    public static List<Integer> validateWinNumsInput(String winNumsInput) {
        return null;
    }

    public static int validateBonusNumInput(String bonusNumInput) {
        return 0;
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
