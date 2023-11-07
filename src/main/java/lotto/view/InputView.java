package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.model.Token;
import lotto.util.TypeConverter;

public class InputView {

    private static final String READ_AMOUNT_MSG = "구입금액을 입력해 주세요.";

    public Token readAmount() {
        System.out.println(READ_AMOUNT_MSG);
        int amount = TypeConverter.toInt(readLine());
        System.out.println();
        return new Token(amount);
    }
}
