package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PRINT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_COUNT_PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printLottoPurchaseAmountInputMessage() {
        System.out.println(PRINT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printCountPurchaseLotto(int purchaseLottoCount) {
        System.out.println();
        System.out.println(purchaseLottoCount + PRINT_COUNT_PURCHASE_LOTTO_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> generateLottoNumbers) {
        System.out.println(generateLottoNumbers.toString());
    }
}
