package lotto.view.output;

import lotto.model.dto.LottoResponse;
import lotto.model.dto.PrizeResult;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static final String LOTTO_DELIMITER = ", ";
    private static final String RATE_DIGIT = "%.1f";
    private static final int RATE_PERCENT = 100;

    @Override
    public void askInvestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBoughtLottoSize(final int size) {
        System.out.println();
        System.out.println(size + "개를 구매했습니다.");
    }

    @Override
    public void printEachLottoNumbers(final List<LottoResponse> lottoResponses) {
        for (LottoResponse response : lottoResponses) {
            System.out.println("[" + String.join(LOTTO_DELIMITER, response.numbers()) + "]");
        }
    }

    @Override
    public void askGoalNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void alertResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    @Override
    public void printEachPrize(final List<PrizeResult> results) {
        for (PrizeResult result : results) {
            System.out.println(makePrizeAnswer(result));
        }
    }

    private String makePrizeAnswer(final PrizeResult result) {
        return result.condition() + " (" + String.format("%,d", result.prize()) + "원)" + " - " + result.size() + "개";
    }

    @Override
    public void printProfitRate(final double rate) {
        System.out.println("총 수익률은 " + String.format(RATE_DIGIT, rate * RATE_PERCENT) + "%입니다.");
    }

    @Override
    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
