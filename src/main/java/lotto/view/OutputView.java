package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private final static String NEW_LINE = "\n";
    private final static String REQUEST_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private final static String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String START_RESULT_MESSAGE = "\n당첨 통계\n---";
    private final static String FIFTH = "3개 일치 (5,000원) - ";
    private final static String FOURTH = "4개 일치 (50,000원) - ";
    private final static String THIRD = "5개 일치 (1,500,000원) - ";
    private final static String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String FIRST = "6개 일치 (2,000,000,000원) - ";
    private final static String AMOUNT = "개";
    private final static String ALL_PROFIT = "총 수익률은 ";
    private final static String ALL_PROFIT_END = "%입니다.";

    private final static int MAKE_PERCENTAGE = 1000;


    public static void printRequestBuyAmount() {
        System.out.println(REQUEST_BUY_AMOUNT_MESSAGE);
    }

    public static void printBuyCount(int count) {
        System.out.println(NEW_LINE + (count / MAKE_PERCENTAGE) + BUY_COUNT_MESSAGE);
    }

    public static void printCreatedLottos(Lottos lottos) {
        List<List<Integer>> numbers = lottos.getLottos().stream().map(Lotto::getNumbers).toList();
        numbers.forEach(number -> System.out.println(number));
    }

    public static void printRequestWinningNumber() {
        System.out.println(NEW_LINE+REQUEST_WINNING_NUMBER);
    }

    public static void printRequestBonusNumber() {
        System.out.println(NEW_LINE+REQUEST_BONUS_NUMBER);
    }

    public static void printStartResult() {
        System.out.println(START_RESULT_MESSAGE);
    }


    public static void printWinningResult(Map<LottoRank, Integer> lottoRankInfo) {
        System.out.println(FIFTH + lottoRankInfo.get(LottoRank.FIFTH) + AMOUNT);
        System.out.println(FOURTH + lottoRankInfo.get(LottoRank.FOURTH) + AMOUNT);
        System.out.println(THIRD + lottoRankInfo.get(LottoRank.THIRD) +AMOUNT);
        System.out.println(SECOND + lottoRankInfo.get(LottoRank.SECOND) + AMOUNT);
        System.out.println(FIRST + lottoRankInfo.get(LottoRank.FIRST) + AMOUNT);

    }

    public static void printProfitRate(float profitRate) {
        System.out.print(ALL_PROFIT + String.format("%.1f", profitRate) + ALL_PROFIT_END);
    }
}
