package lotto.model;
import lotto.Lotto.LottoConstants;

public class validator {

    private static final int LOTTO_PRICE = LottoConstants.LOTTO_PRICE.getPrice();
    private static boolean isValidFormat(String input){
        return input.matches("\\d+");
    }

    private static boolean isValidLottoPurchaseAmount(int amount){
        return amount >= LOTTO_PRICE && amount % LOTTO_PRICE ==0;
    }

    public static boolean isValidPurchaseInput(String input){
        if (!isValidFormat(input)) {
            System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            return false;
        }

        int purchaseAmount = Integer.parseInt(input);
        if (!isValidLottoPurchaseAmount(purchaseAmount)){
            System.out.println("[ERROR] 로또 구매 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
            return false;
        }
        return true;
    }
}
