package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.constant.Message;

public class InputView {
    public static String inputMoney() {
        System.out.println(Message.INPUT_MONEY);
        String input = readLine();
        System.out.println(input + Message.LINE_BREAKING);
        return input;
    }

    public static String inputPrizeNumber() {
        System.out.println(Message.INPUT_PRIZE_NUMBER);
        String input = readLine();
        System.out.println(input + Message.LINE_BREAKING);
        return input;
    }

    public static String inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER);
        String input = readLine();
        System.out.println(input + Message.LINE_BREAKING);
        return input;
    }
}
