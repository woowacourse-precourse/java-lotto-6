package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class SystemInput {

    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    private static final String BLANK_ERROR = "입력된 값이 없습니다. 다시 입력해주세요.";
    private static final String DIVISION_ERROR = "금액은 1000으로 나눠 떨어져야 합니다.";
    private static final String DO_IT_AGAIN = "입력 값이 잘 못 되었습니다. 다시 입력해주세요!";
    private static final String LOTTO_NUMBER_INPUT_REQUIRED = "로또 번호는 숫자 형식입니다. 다시 입력해주세요!";
    private static final String BONUS_NUMBER_INPUT_REQUIRED = "보너스 번호는 숫자 형식입니다. 다시 입력해주세요!";

    private static final String COMMA_SEPERATOR = ",";
    private static final String WRONG_SEPERATOR = ",,";

    private static final String REGULAR_EXPRESSION = ".*\\d.*";

    private static final Integer THOUSANDS = 1000;


    public static int readMoney() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
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
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public static void validateDivision(String purchase) {
        int money = Integer.parseInt(purchase);
        if (money % THOUSANDS != 0) {
            throw new IllegalArgumentException(DIVISION_ERROR);
        }
    }

    public static String readPickLotto() {
        System.out.println(LOTTO_INPUT);
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

        if(lastChar == COMMA_SEPERATOR.charAt(0)){
            throw new IllegalArgumentException(DO_IT_AGAIN);
        }
        if (pickLotto.contains(WRONG_SEPERATOR) || firstChar == COMMA_SEPERATOR.charAt(0)){
            throw new IllegalArgumentException(DO_IT_AGAIN);
        }

    }

    public static void validateString(String pickLotto) {
        String PATTERN = REGULAR_EXPRESSION;
        if (!pickLotto.matches(PATTERN)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_INPUT_REQUIRED);
        }

    }

    public static int readBonusNumber() {
        System.out.println(BONUS_INPUT);
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
        String PATTERN = REGULAR_EXPRESSION;
        if (!pickBonus.matches(PATTERN)) {
            throw new IllegalArgumentException(BONUS_NUMBER_INPUT_REQUIRED);
        }
    }

}
