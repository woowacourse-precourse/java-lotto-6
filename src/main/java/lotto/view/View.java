package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Message;

public class View {
    public String inputCost() {
        System.out.println(Message.INPUT_COST);

        return Console.readLine();
    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.print(lottoCount);
        System.out.println(Message.LOTTO_COUNT);
    }

    public void printLotto(String[] lottoString) {
        System.out.print(Message.LEFT_BRACKET);
        System.out.print(String.join(Message.DELIMITER, lottoString));
        System.out.println(Message.RIGHT_BRACKET);
    }

    public String inputString() {
        System.out.println();
        System.out.println(Message.INPUT_ANSWER);
        return Console.readLine();
    }

    public String inputBonus() {
        System.out.println();
        System.out.println(Message.INPUT_BONUS);
        return Console.readLine();
    }

    public void printResult(String resultMessage) {
        System.out.println();
        System.out.println(Message.RESULT);
        System.out.println(Message.SEPARATOR);
        System.out.print(resultMessage);
    }

    public void printReturnRate(Double returnRate) {
        System.out.print(Message.RETURN_RATE);
        System.out.printf(Message.ONE_DECIMAL_FORMAT, returnRate);
        System.out.print(Message.PERCENT);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
