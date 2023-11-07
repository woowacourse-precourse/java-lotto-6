package lotto.view;

import lotto.model.LottoPaper;
import lotto.model.dto.LottoResultDTO;

import java.util.List;

public class OutputView {

    private enum OutputMessage {
        PURCHASE_RESULT("개를 구매했습니다."),
        RETURN_RATE_HEADER("총 수익률은 "),
        RETURN_RATE_FOOTER("%입니다.");

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

    public void printReturnRate(LottoResultDTO resultDTO) {
        System.out.printf(
                "%s%.1f%s",
                OutputMessage.RETURN_RATE_HEADER.message,
                resultDTO.getTotalReturnRate(),
                OutputMessage.RETURN_RATE_FOOTER.message);
    }
}
