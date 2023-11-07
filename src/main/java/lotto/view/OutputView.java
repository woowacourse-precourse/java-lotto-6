package lotto.view;

import lotto.model.LottoPaper;

import java.util.List;

public class OutputView {
    private enum OutputMessage {
        PURCHASE_RESULT("개를 구매했습니다.");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public void printPurchaseResult(int quantity) {
        System.out.printf("%d%s%n", quantity, OutputMessage.PURCHASE_RESULT.message);
    }

    public void printPurchasedLottoPaper(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(lottoPaper.getLottoNumbers());
        }
        System.out.printf("%n");
    }
}
