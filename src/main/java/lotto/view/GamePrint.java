package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.MatchingLotto;

public class GamePrint {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "\n%s개를 구매했습니다.\n";
    private static final String INPUT_WINNER_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPERATION = "---";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void numberOfPurchases(int buyLottoNumber) {
        System.out.printf(BUY_LOTTO, buyLottoNumber);
    }

    public static void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.printSortedNumber());
        }
    }

    public static void winnerNumbersMessage() {
        System.out.println(INPUT_WINNER_NUMBER);
    }

    public static void bonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void winningStatistics(MatchingLotto matchingLotto) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPERATION);
        System.out.println("3개 일치 (5,000원) - " + matchingLotto.getMatchedThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + matchingLotto.getMatchedFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchingLotto.getMatchedFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingLotto.getMatchedBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchingLotto.getMatchedSix() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.",matchingLotto.calculateLottoReturnRate());
    }
}
