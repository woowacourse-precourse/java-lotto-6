package lotto.view;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Result;

public class OutputView {

    private static final String BUY_ANNOUNCE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String SEPARATE_LINE = "---";
    private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 ";
    private static final String END_MESSAGE = "%입니다.";
    private static final String COUNT = "개";

    public static void printBuyAnnounce() {
        System.out.println(BUY_ANNOUNCE_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void printEachLotto(Lotto oneLotto) {
        System.out.println(oneLotto);
    }

    public static void printWinningNumberInputAnnounce() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputAnnounce() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printStatisticsMessage() {
        System.out.println();
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(SEPARATE_LINE);
    }

    public static void printFinalReturnRate(double finalReturnRate) {
        System.out.println(TOTAL_RETURN_RATE_MESSAGE + finalReturnRate + END_MESSAGE);
    }

    public static void printFinalResult(Map<Result, Integer> finalResult) {
        System.out.println(Result.THREE + finalResult.get(Result.THREE).toString() + COUNT);
        System.out.println(Result.FOUR + finalResult.get(Result.FOUR).toString() + COUNT);
        System.out.println(Result.FIVE + finalResult.get(Result.FIVE).toString() + COUNT);
        System.out.println(Result.BONUS + finalResult.get(Result.BONUS).toString() + COUNT);
        System.out.println(Result.SIX + finalResult.get(Result.SIX).toString() + COUNT);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
