package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.LottoService;

import java.math.BigDecimal;
import java.util.List;

public class OutputView {

    private static final String INPUT_PURCHASE_PRICE_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_SENTENCE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계" + "\n" + "---";
    private static final String THREE_MATCHES = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHES = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHES = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHES = "6개 일치 (2,000,000,000원) - ";

    private InputView inputView = new InputView();
    private LottoService lottoService = new LottoService();

    public void printInputPurchasePriceSentence() {
        System.out.println(INPUT_PURCHASE_PRICE_SENTENCE);
    }

    public void printIssuingLotteryTicket(List<Lotto> lottos, int lotteryTicketCount) {
        System.out.println();
        System.out.println(lotteryTicketCount + OUTPUT_PURCHASE_COUNT_SENTENCE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printInputWinningNumbersSentence() {
        System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
    }

    public void printBonusNumberSentence() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_SENTENCE);
    }

    public void printResult(List<Prize> prizes, List<Integer> prizeCount) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_MATCHES + prizeCount.get(5) + "개");
        System.out.println(FOUR_MATCHES + prizeCount.get(4) + "개");
        System.out.println(FIVE_MATCHES + prizeCount.get(3) + "개");
        System.out.println(FIVE_AND_BONUS_MATCHES + prizeCount.get(2) + "개");
        System.out.println(SIX_MATCHES + prizeCount.get(1) + "개");
    }

    public void printRateOfReturn(double value) {
        double rateOfReturn = Math.round(value * 10) / 10.0;
        BigDecimal result = new BigDecimal(rateOfReturn);
        String format = String.format("총 수익률은 %,.1f%%입니다.", result);
        System.out.println(format);
    }
}
