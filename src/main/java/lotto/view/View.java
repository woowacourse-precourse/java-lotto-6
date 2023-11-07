package lotto.view;

import static lotto.constant.ConstantMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ConstantMessage;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class View {
    public static void printConstantMessage(ConstantMessage ConstantMessage) {
        System.out.print(ConstantMessage.getMessage());
    }

    public static String inputBuyMoney() {
        printConstantMessage(INPUT_BUY_MONEY);
        return Console.readLine();
    }

    public static String inputWinNumber() {
        printConstantMessage(INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        printConstantMessage(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.print(lottoTicketCount);
        printConstantMessage(BUY_LOTTO_TICKET);
    }

    public static void printLotto(List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getLotto().toString());
        }
    }

    public static void printWinCount(Map<String, Integer> result, String key) {
        if (result.containsKey(key)) {
            System.out.print(result.get(key));
        }
        if (!result.containsKey(key)) {
            System.out.print(0);
        }
    }

    public static void printResult(Map<String, Integer> result, double rateOfReturn) {
        printConstantMessage(WINNING_STAT);
        printConstantMessage(THREE_CORRECT);
        printWinCount(result, "three");
        printConstantMessage(COUNT);

        printConstantMessage(FOUR_CORRECT);
        printWinCount(result, "four");
        printConstantMessage(COUNT);

        printConstantMessage(FIVE_CORRECT);
        printWinCount(result, "five");
        printConstantMessage(COUNT);

        printConstantMessage(FIVE_BONUS_CORRECT);
        printWinCount(result, "fiveBonus");
        printConstantMessage(COUNT);

        printConstantMessage(SIX_CORRECT);
        printWinCount(result, "six");
        printConstantMessage(COUNT);
        printRateOfReturn(rateOfReturn);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        final String ROUND_POSITION = "%.1f";
        System.out.println("총 수익률은 " + String.format(ROUND_POSITION, rateOfReturn) + "%입니다.");
    }
}
