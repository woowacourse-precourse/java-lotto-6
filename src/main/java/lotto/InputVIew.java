package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    private static final String INPUT_TICKETS_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputTicketsAmount(){
        System.out.println(INPUT_TICKETS_AMOUNT);
        return Console.readLine();
    }
}
