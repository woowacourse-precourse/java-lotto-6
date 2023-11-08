package lotto.validator;

public class InputValidator extends Validator {

    public static int purchaseMoney(String userMoney){
        int userPay = parseValidInt(userMoney);
        purchaseValidMoney(userPay);
        return userPay;
    }

        public static int parseValidInt(String input) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구입금액은 숫자로 입력하셔야 합니다.");
            }
        }


    private static void purchaseValidMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throwException("구입금액은 1,000원으로 나누어 떨어져야 합니다.", null);
        }
    }

}
