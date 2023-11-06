package lotto;

import camp.nextstep.edu.missionutils.Console;

class InputView {

    private static final String READ_PLAYER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_ANSWER_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String readPlayerMoney() {
        System.out.println(READ_PLAYER_MONEY_MESSAGE);

        return Console.readLine().trim();
    }

    public static String readAnswerLotto() {
        System.out.println(READ_ANSWER_LOTTO_MESSAGE);

        return Console.readLine().trim();
    }
}
