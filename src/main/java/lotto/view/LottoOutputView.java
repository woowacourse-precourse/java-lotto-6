package lotto.view;

import static lotto.model.LottoRank.RANK_2ND;
import static lotto.model.LottoRank.RANK_NO;
import static lotto.util.Utils.conversionWon;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.dto.LottosCalculateResult;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class LottoOutputView {

    public static final String PLEASE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String NUMBER_OF_PURCHASES = "\n%d개를 구매했습니다.";
    public static final String PLEASE_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String PLEASE_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "\n당첨 통계";
    public static final String CONTOUR = "---";

    public static final String WINNING_RESULT = "%d개 일치 (%s원) - %d개";
    public static final String WINNING_BONUS_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public static void printPurchaseAmount() {
        System.out.println(PLEASE_PURCHASE_AMOUNT);
    }

    public static void printWinningNumber() {
        System.out.println(PLEASE_WINNING_NUMBER);
    }

    public static void printBonusNumber() {
        System.out.println(PLEASE_BONUS_NUMBER);
    }


    /**
     * 구매한 로또를 출력한다.
     *
     * @param lottos 로또(들)을 받는다.
     */
    public static void printPurchaseLotto(List<Lotto> lottos) {
        String makeMessage = String.format(NUMBER_OF_PURCHASES, lottos.size());
        System.out.println(makeMessage);

        for (Lotto lotto :
                lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(LottosCalculateResult calculateResult) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(CONTOUR);

        Map<LottoRank, Integer> result = calculateResult.getMatches();
        for (Entry<LottoRank, Integer> entry :
                result.entrySet()) {
            if (entry.getKey() == RANK_2ND) {
                printBonusResult(entry); // 2등만 다른 양식으로 따로 출력한다.
                continue;
            }
            if (entry.getKey() == RANK_NO) { // 출력하지 않는 내용 제외
                continue;
            }

            printBasicResult(entry);
        }

        System.out.println(String.format(RATE_OF_RETURN, calculateResult.getRateOfReturn()));
    }

    private static void printBasicResult(Entry<LottoRank, Integer> entry) {
        LottoRank key = entry.getKey();
        String reward = conversionWon(key.getPrice());
        int count = entry.getValue();

        String comment = String.format(WINNING_RESULT, (int) key.getMatch(), reward, count);
        System.out.println(comment);
    }

    private static void printBonusResult(Entry<LottoRank, Integer> entry) {
        LottoRank key = entry.getKey();
        String reward = conversionWon(key.getPrice());
        int count = entry.getValue();

        String comment = String.format(WINNING_BONUS_RESULT, (int) key.getMatch(), reward, count);
        System.out.println(comment);
    }

}
