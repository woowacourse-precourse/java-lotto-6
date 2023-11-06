package lotto.domain;

public class LottoManager {

    public int isValidPurchaseAmount(int lottoPurchaseAmount) {
        while(true) {
            try {
                if (lottoPurchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("로또 구입 수량에 맞게 적절한 돈을 지불해주세요.");
                }
                return lottoPurchaseAmount / 1000;
            } catch (IllegalArgumentException e) {
                System.err.print("[ERROR] 로또 구입 수량에 맞게 적절한 돈을 지불해주세요.");
            }
        }
    }
}
