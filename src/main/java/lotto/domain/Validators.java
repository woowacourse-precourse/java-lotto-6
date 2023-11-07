package lotto.domain;


public class Validators {
    private static final int TICKET_UNIT = 1000;

    public static boolean validate(String inputMoney) {
        try {
           validateStringIsIntegerConvertable(inputMoney);
           validateMoneyIsLottoAffordable(Integer.parseInt(inputMoney));
        }
        catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 1,000원 이상의 1,000원 단위 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    private static void validateStringIsIntegerConvertable(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateMoneyIsLottoAffordable(int money) {
        if (money % TICKET_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException();
        }
    }
}
