package lotto.Exception;

public class PlayerBuyingPayException {
    private final static int LOTTO_PRICE = 1000;
    private final static String ERROR = "[ERROR] ";

    public void checkPlayerBuyingPay(String buyingPay) {
        if (notThousandWonUnitCase(buyingPay)) { //[E1] 구입 금액이 1,000원 단위가 아닌 경우
            throw new IllegalArgumentException(ERROR + "구매 금액은 1,000원 단위로 입력해주세요.");
        }
        if (notNumberCase(buyingPay)) {  //[E2] 구입 금액이 숫자가 아닌 경우
            throw new NumberFormatException(ERROR + "구입 금액은 1,000원 단위의 숫자로 입력해야 합니다.");
        }
        if (BlankCase(buyingPay)) { //[E3] 공백을 입력한 경우
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
        }


    }

    private boolean notThousandWonUnitCase(String buyingPay) {
        int buyingPrice = Integer.parseInt(buyingPay);
        return buyingPrice % LOTTO_PRICE != 0;
    }

    private boolean notNumberCase(String buyingPay) {
        for (int i = 0; i < buyingPay.length(); i++) {
            if (!Character.isDigit(buyingPay.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean BlankCase(String buyingPay) {
        return buyingPay.trim().isEmpty();
    }
}
