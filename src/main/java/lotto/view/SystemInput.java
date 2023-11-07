package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class SystemInput {
    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateMoney(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static void validateMoney(String purchase) {
        validateNone(purchase);
        validateDivision(purchase);
    }

    public static void validateNone(String purchase) {
        if (purchase.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해주세요.");
        }
    }

    public static void validateDivision(String purchase) {
        int money = Integer.parseInt(purchase);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나눠 떨어져야 합니다.");
        }
    }

    public static String readPickLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String pickLotto = Console.readLine();
        validatePickLotto(pickLotto);
        return pickLotto;
    }

    public static void validatePickLotto(String pickLotto) {
        validateCorrectInput(pickLotto);
        validateString(pickLotto);
        validateNone(pickLotto);
    }

    public static void validateCorrectInput(String pickLotto) {
        char lastChar = pickLotto.charAt(pickLotto.length()-1);
        char firstChar = pickLotto.charAt(0);

        if(lastChar == ",".charAt(0)){
            throw new IllegalArgumentException("[ERROR] 입력 값이 잘 못 되었습니다. 다시 입력해주세요!");
        }
        if (pickLotto.contains(",,") || firstChar == ",".charAt(0)){
            throw new IllegalArgumentException("[ERROR] 입력 값이 잘 못 되었습니다. 다시 입력해주세요!");
        }

    }

    public static void validateString(String pickLotto) {
        String PATTERN = "^[0-9,]+$";
        if (pickLotto.matches(PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자 형식입니다. 다시 입력해주세요!");
        }

    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String pickBonus = Console.readLine();
        validateBonus(pickBonus);
        return Integer.parseInt(pickBonus);
    }

    public static void validateBonus(String pickBonus) {
        validateBonusNum(pickBonus);
        validateNone(pickBonus);

    }

    public static void validateBonusNum(String pickBonus) {
        String PATTERN = "^[0-9,]+$";
        if (pickBonus.matches(PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 형식입니다. 다시 입력해주세요!");
        }
    }

}
