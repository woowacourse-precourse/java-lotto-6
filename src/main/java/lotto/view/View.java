package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.PRIZE_TYPE;
import lotto.model.Constants;

public class View {
    final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    final static String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해주세요.";
    final static String FORMAT_BUYING_LOTTO_COUNT_N = "%d개를 구매했습니다.";
    final static String INPUT_MONEY_FOR_BUY_LOTTO = "구입금액을 입력해주세요.";
    final static String FORMAT_PRIZE_STATUS = "%d개 일치%s (%s원) - %d개";
    final static String FORMAT_EARNING_RATE = "총 수익률은 %.2f%%입니다.";

    public static void lottoList(List<Lotto> lotto) {
        View.buyingLottoN(lotto.size());
        for (Lotto value : lotto) {
            var item = value.getNumbers();
            var strLotto = list2String(item);
            println(strLotto);
        }
        println();
    }

    private static String list2String(List<Integer> item) {
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        sb.append(item.get(0));
        for (int k = 1; k < item.size(); ++k) {
            sb.append(", ");
            sb.append(item.get(k));
        }
        sb.append(']');
        return sb.toString();
    }

    public static void inputBonusNumber() {
        println(INPUT_BONUS_NUMBER);
    }

    public static void inputPrizeNumber() {
        println(INPUT_PRIZE_NUMBER);
    }

    public static void buyingLottoN(int n) {
        printlnFormat(FORMAT_BUYING_LOTTO_COUNT_N, n);
    }

    public static void moneyForBuyLotto() {
        println(INPUT_MONEY_FOR_BUY_LOTTO);
    }

    public static void resultStatics(Map<PRIZE_TYPE, Integer> result, double earningRate) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        final Object[][] data = {
                {PRIZE_TYPE.FIVETH, 3, ""},
                {PRIZE_TYPE.FOURTH, 4, ""},
                {PRIZE_TYPE.THIRD, 5, ""},
                {PRIZE_TYPE.SECOND, 5, ", 보너스 볼 일치"},
                {PRIZE_TYPE.FIRST, 6, ""}
        };
        println("당첨통계");
        println("---");
        for (int i = 0; i < Constants.PRIZE_COUNT; ++i) {
            PRIZE_TYPE prizeType = (PRIZE_TYPE) data[i][0];
            int matchNumberCount = (int) data[i][1];
            String additionalString = (String) data[i][2];
            int prizeMoney = Constants.PRIZE_MONEY.get(prizeType);
            int numberOfPrize = result.get(prizeType);
            printlnFormat(FORMAT_PRIZE_STATUS,
                    matchNumberCount, additionalString, decFormat.format(prizeMoney), numberOfPrize);
        }
        printlnFormat(FORMAT_EARNING_RATE, earningRate);
        println();
    }

    private static void println(String str) {
        System.out.println(str);
    }

    public static void println() {
        println("");
    }

    public static void error(String str){
        println("[ERROR] "+str);
    }

    private static void printlnFormat(String format, Object... args) {
        println(String.format(format, args));
    }

}
