package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private static final String ASK_WINNING_NUMBER_STATEMENT = "당첨 번호를 입력해주세요";

    public static String askUserWinningGame() {
        OutputService.askStatmement(ASK_WINNING_NUMBER_STATEMENT);
        return Console.readLine();
    }
}
