package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    private final String INPUT_COST_MESSAGE = "구입금액을 입력해주세요.";
    private final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final String LEFT_BRACKET = "[";
    private final String RIGHT_BRACKET = "]";
    private final String DELIMITER = ", ";

    public String inputCost() {
        System.out.println(INPUT_COST_MESSAGE);

        return Console.readLine();
    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.print(lottoCount);
        System.out.println(LOTTO_COUNT_MESSAGE);
    }

    public void printLotto(String[] lottoString) {
        System.out.print(LEFT_BRACKET);
        System.out.print(String.join(DELIMITER, lottoString));
        System.out.println(RIGHT_BRACKET);
    }

    public String inputString() {
        return Console.readLine();
    }
}
