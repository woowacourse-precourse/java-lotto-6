package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    private final String INPUT_COST_MESSAGE = "구입금액을 입력해주세요.";
    private final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private final String INPUT_ANSWER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String RESULT_MESSAGE = "당첨 통계";
    private final String SEPARATOR = "---";
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
        System.out.println();
        System.out.println(INPUT_ANSWER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonus() {
        System.out.println();
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }

    public void printResult(String resultMessage) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(SEPARATOR);
        System.out.print(resultMessage);
    }
}
