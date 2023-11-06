package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.User;

import java.util.ArrayList;
import java.util.Collections;
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

    public static void ConsolePrintBoughtResult(User user) {
        ConsolePrintNewLine("");
        ConsolePrintNewLine(user.getNumber() + Message.OUTPUT_BOUGHT_NUMBER);
        for (Lotto lotto : user.getLottos().keySet()) {
            List<Integer> copy_lotto = new ArrayList<>(List.copyOf(lotto.getNumbers()));
            Collections.sort(copy_lotto);
            ConsolePrintNewLine(copy_lotto.toString());
        }
        ConsolePrintNewLine("");
    }

    public static void ConsolePrintStatistics(List<Integer> number) {
        ConsolePrintStatInfo();
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FIFTH + number.get(0) + Message.OUTPUT_STATICS_BACK);
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FOURTH + number.get(1) + Message.OUTPUT_STATICS_BACK);
        ConsolePrintNewLine(Message.OUTPUT_STATICS_THIRD + number.get(2) + Message.OUTPUT_STATICS_BACK);
        ConsolePrintNewLine(Message.OUTPUT_STATICS_SECOND + number.get(3) + Message.OUTPUT_STATICS_BACK);
        ConsolePrintNewLine(Message.OUTPUT_STATICS_FIRST + number.get(4) + Message.OUTPUT_STATICS_BACK);
    }

    private static void ConsolePrintStatInfo() {
        ConsolePrintNewLine("");
        ConsolePrintNewLine(Message.OUTPUT_STATICS_INFO);
    }
    public static void ConsolePrintStatResult(double rate) {
        ConsolePrintNewLine(Message.OUTPUT_STATICS_RATE_FRONT + rate + Message.OUTPUT_STATICS_RATE_BACK);
    }
}
