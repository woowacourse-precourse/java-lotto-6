package lotto;

public class InputValidator extends Validator {

    public static int purchaseMoney(String userMoney){
        int userPay = parseValidInt(userMoney);
        purchaseValidMoney(userPay);
        return userPay;
    }

    private static int parseValidInt(String inputPay) {
        int inputedNumber = 0;
        try {
            inputedNumber = Integer.parseInt(inputPay);
        } catch (NumberFormatException e) {
            throwException("구입금액은 숫자로 입력하셔야 합니다.", e);
        }
        return inputedNumber;
    }

    private static void purchaseValidMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throwException("구입금액은 1,000원으로 나누어 떨어져야 합니다.", null);
        }
    }


}
