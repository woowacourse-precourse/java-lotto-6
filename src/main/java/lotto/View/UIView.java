package lotto.View;


import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.Prize;

public class UIView {
    private static final String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ANOUNCE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String PARTITION = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String COUNT = "개";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    private static final String PROFIT_PERCENTAGE = "총 수익률은 ";
    private static final String PERCENTAGE = "%입니다.";
    public static void printPurchasePriceInstruction() {
        System.out.println(ENTER_PURCHASE_PRICE);
    }

    public static void printLottoCount(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PURCHASE_ANOUNCE);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberInstruction() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBER);
    }

    public static void printBonusNumberInstruction() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBER);
    }

    public static void printStatisticsDetail() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(PARTITION);
        System.out.println(THREE_CORRECT + Prize.THREE.getCount() + COUNT);
        System.out.println(FOUR_CORRECT + Prize.FOUR.getCount() + COUNT);
        System.out.println(FIVE_CORRECT + Prize.FIVE.getCount() + COUNT);
        System.out.println(FIVE_BONUS_CORRECT + Prize.FIVE_BONUS.getCount() + COUNT);
        System.out.println(SIX_CORRECT + Prize.SIX.getCount() + COUNT);
    }

    public static void printProfit(double roundedProfit) {
        System.out.println(PROFIT_PERCENTAGE + roundedProfit +PERCENTAGE);
    }
}
