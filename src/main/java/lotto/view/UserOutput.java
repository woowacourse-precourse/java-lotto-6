package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import java.util.List;

public class UserOutput {
    private static void ConsolePrintNewLine(String message) {
        System.out.println(message);
    }

    public static void ConsolePrintBoughtInfo() {
        ConsolePrintNewLine(Message.INPUT_BOUGHT_MONEY);
    }

    public static void ConsolePrintWinningInfo() {
        ConsolePrintNewLine(Message.INPUT_WINNING_NUMBER);
    }

    public static void ConsolePrintBonusInfo() {
        ConsolePrintNewLine("");
        ConsolePrintNewLine(Message.INPUT_BONUS_NUMBER);
    }

    public static void ConsolePrintBoughtResult(int number, List<Lotto> lottos) {
        ConsolePrintNewLine("");
        ConsolePrintNewLine(number + Message.OUTPUT_BOUGHT_NUMBER);
        for (Lotto lotto : lottos) {
            ConsolePrintNewLine(lotto.toString());
        }
        ConsolePrintNewLine("");
    }

    public static void ConsolePrintStatistics(String rank, List<Integer> number) {
        ConsolePrintStatInfo();
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FIFTH + number.get(4));
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FOURTH + number.get(3));
        ConsolePrintNewLine(Message.OUTPUT_STATICS_THIRD + number.get(2));
        ConsolePrintNewLine(Message.OUTPUT_STATICS_SECOND + number.get(1));
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FIRST + number.get(0));
    }

    private static void ConsolePrintStatInfo() {
        ConsolePrintNewLine("");
        ConsolePrintNewLine(Message.OUTPUT_STATICS_INFO);
    }
    public static void ConsolePrintStatResult(double rate) {
        ConsolePrintNewLine(Message.OUTPUT_STATICS_RATE_FRONT + rate + Message.OUTPUT_STATICS_RATE_BACK);
    }
}
