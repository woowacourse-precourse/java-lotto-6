package lotto.Service;

import java.text.DecimalFormat;
import lotto.Enum.LottoResult;
import lotto.Lotto;

public class GameResultOutputService {
    private static final String LOTTO_RESULT_SEPERATOR = " - ";
    private static final String UNIT_STATEMENT = "개";
    private static final String OUTPUT_STATEMENT = "당첨 통계\n" + "---";

    private static String getResultMessage(LottoResult lottoResult) {
        return lottoResult.getDescription().concat(LOTTO_RESULT_SEPERATOR);
    }

    public static void printOutputStatement(){
        System.out.println(OUTPUT_STATEMENT);
    }

    public static void printThreeMatch(int three) {
        String statement = getResultMessage(LottoResult.THREE);
        statement = statement.concat(three + UNIT_STATEMENT);
        System.out.println(statement);
    }

    public static void printFourMatch(int four) {
        String statement = getResultMessage(LottoResult.FOUR);
        statement = statement.concat(four + UNIT_STATEMENT);
        System.out.println(statement);

    }

    public static void printFiveWithoutBonus(int fiveNoBonus) {
        String statement = getResultMessage(LottoResult.FIVE_WITH_NO_BONUS);
        statement = statement.concat(fiveNoBonus + UNIT_STATEMENT);
        System.out.println(statement);
    }

    public static void printFiveWithBonus(int fiveBonus) {
        String statement = getResultMessage(LottoResult.FIVE_WITH_BONUS);
        statement = statement.concat(fiveBonus + UNIT_STATEMENT);
        System.out.println(statement);
    }

    public static void printSix(int six){
        String statement = getResultMessage(LottoResult.SIX);
        statement = statement.concat(six + UNIT_STATEMENT);
        System.out.println(statement);
    }

    public static void printRateOfReturn(double rate){
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        String str = decimalFormat.format(rate);
        System.out.println("총 수익률은 " + str + "%입니다.");

    }
}
