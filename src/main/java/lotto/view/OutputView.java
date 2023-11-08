package lotto.view;

import lotto.dto.LottoBundleDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultEntry;

public class OutputView {

    public static final String PAYMENT_REQ_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BUNDLE_SIZE_INFO_MESSAGE = "%d개를 구매했습니다.";
    public static final String WINNING_NUMBERS_REQ_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBERS_REQ_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_INFO_MESSAGE = "당첨 통계";
    public static final String CONTOUR_LINE = "---";
    public static final String PROFIT_RATE_INFO_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String FIRST_STAT_INFO_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";

    public void printPaymentRequest() {
        System.out.println(PAYMENT_REQ_MESSAGE);
    }

    public void printLottoBundle(LottoBundleDto bundle) {
        printBundleCount(bundle.lottos().size());
        bundle.lottos().forEach(this::printLotto);
    }

    private void printBundleCount(int count) {
        System.out.printf((BUNDLE_SIZE_INFO_MESSAGE) + "%n", count);
    }

    private void printLotto(LottoDto lotto) {
        String[] numbers = lotto.numbers().stream()
                .map(Object::toString).
                toArray(String[]::new);

        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public void printWinningLottoNumbersRequest() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_REQ_MESSAGE);
    }

    public void printWinningLottoBonusNumberRequest() {
        System.out.println();
        System.out.println(BONUS_NUMBERS_REQ_MESSAGE);
    }

    public void printResult(LottoResult result) {
        System.out.println();
        printResultMessage();
        printResultStatistics(result);
        printResultProfitRate(result);
    }

    private void printResultStatistics(LottoResult result) {
        printResultStatisticsFifthEntry(result.fifth());
        printResultStatisticsFourthEntry(result.fourth());
        printResultStatisticsThirdEntry(result.third());
        printResultStatisticsSecondEntry(result.second());
        printResultStatisticsFirstEntry(result.first());
    }

    private void printResultStatisticsFirstEntry(LottoResultEntry first) {
        System.out.printf(FIRST_STAT_INFO_MESSAGE, first.count());
        System.out.println();
    }

    private void printResultStatisticsSecondEntry(LottoResultEntry second) {
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", second.count());
        System.out.println();
    }

    private void printResultStatisticsThirdEntry(LottoResultEntry third) {
        System.out.printf("5개 일치 (1,500,000원) - %d개", third.count());
        System.out.println();
    }

    private void printResultStatisticsFourthEntry(LottoResultEntry fourth) {
        System.out.printf("4개 일치 (50,000원) - %d개", fourth.count());
        System.out.println();
    }

    private void printResultStatisticsFifthEntry(LottoResultEntry fifth) {
        System.out.printf("3개 일치 (5,000원) - %d개", fifth.count());
        System.out.println();
    }

    private void printResultProfitRate(LottoResult result) {
        System.out.printf(PROFIT_RATE_INFO_MESSAGE, result.profitRate());
    }

    private void printResultMessage() {
        System.out.println(WINNING_INFO_MESSAGE);
        System.out.println(CONTOUR_LINE);
    }


    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
