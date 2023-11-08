package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String requestAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String requestWinNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        return Console.readLine();
    }

    public String requestBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return Console.readLine();
    }
}
