package lotto.view;

import lotto.model.LottoPaper;
import lotto.model.PrizeCategory;
import lotto.model.dto.LottoResultDTO;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private static final String DASH_FORMAT = "---";

    private enum OutputMessage {
        PURCHASE_RESULT("개를 구매했습니다."),
        WINNING_STATISTICS("당첨 통계"),
        RESULT_FORMAT_HEADER(" ("),
        RESULT_FORMAT_MIDDLE("원) - "),
        RESULT_FORMAT_FOOTER("개"),
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

    public void printWinningStatistics(LottoResultDTO resultDTO) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setGroupingUsed(true);

        System.out.printf("%s%n%s%n", OutputMessage.WINNING_STATISTICS.message, DASH_FORMAT);
        for (PrizeCategory category : PrizeCategory.values()) {
            System.out.printf(
                    "%s%s%s%s%d%s%n",
                    category.getNAME(), OutputMessage.RESULT_FORMAT_HEADER.message,
                    numberFormat.format(category.getBasicPrize()), OutputMessage.RESULT_FORMAT_MIDDLE.message,
                    resultDTO.getMatchResult(category), OutputMessage.RESULT_FORMAT_FOOTER.message
            );
        }
        printReturnRate(resultDTO);
    }
}
