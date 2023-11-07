package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class SystemInput {
    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        try {
            validateMoney(purchaseAmount);
        }
        catch (IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
            readMoney();
        }

        return Integer.parseInt(purchaseAmount);
    }

    public static void validateMoney(String purchase) {
        validateNone(purchase);
        validateDivision(purchase);
    }

    public static void validateNone(String purchase) {
        if (purchase.length() == 0) {
            throw new IllegalArgumentException("입력된 값이 없습니다. 다시 입력해주세요.");
        }
    }

    public static void validateDivision(String purchase) {
        int money = Integer.parseInt(purchase);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000으로 나눠 떨어져야 합니다.");
        }
    }

    public static String readPickLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String pickLotto = Console.readLine();
        try {
        validatePickLotto(pickLotto);}
        catch (IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
            readPickLotto();
        }
        return pickLotto;
    }

    public static void validatePickLotto(String pickLotto) {
        validateNone(pickLotto);
        validateCorrectInput(pickLotto);
        validateString(pickLotto);


    }

    public static void validateCorrectInput(String pickLotto) {
        char lastChar = pickLotto.charAt(pickLotto.length()-1);
        char firstChar = pickLotto.charAt(0);

        if(lastChar == ",".charAt(0)){
            throw new IllegalArgumentException("입력 값이 잘 못 되었습니다. 다시 입력해주세요!");
        }
        if (pickLotto.contains(",,") || firstChar == ",".charAt(0)){
            throw new IllegalArgumentException("입력 값이 잘 못 되었습니다. 다시 입력해주세요!");
        }

    }

    public static void validateString(String pickLotto) {
        String PATTERN = ".*\\d.*";
        if (!pickLotto.matches(PATTERN)) {
            throw new IllegalArgumentException("로또 번호는 숫자 형식입니다. 다시 입력해주세요!");
        }

    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String pickBonus = Console.readLine();
        try {
            validateBonus(pickBonus);
        } catch (IllegalArgumentException e) {
            Validator.printErrorMessage(e.getMessage());
            readBonusNumber();
        }
        return Integer.parseInt(pickBonus);
    }

    public static void validateBonus(String pickBonus) {
        validateNone(pickBonus);
        validateBonusNum(pickBonus);


    }

    public static void validateBonusNum(String pickBonus) {
        String PATTERN = ".*\\d.*";
        if (!pickBonus.matches(PATTERN)) {
            throw new IllegalArgumentException("보너스 번호는 숫자 형식입니다. 다시 입력해주세요!");
        }
    }

}
