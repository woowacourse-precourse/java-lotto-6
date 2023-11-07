package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.model.AnswerLotto;
import lotto.model.Token;
import lotto.util.TypeConverter;

public class InputView {

    private static final String READ_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NO = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NO = "보너스 번호를 입력해 주세요.";
    public static final String LINE_BREAK = "\n";

    public Token readToken() {
        System.out.println(READ_AMOUNT_MSG);
        int amount = TypeConverter.toInt(readLine());
        return new Token(amount);
    }

    public AnswerLotto readAnswerLotto() {
        return new AnswerLotto(readWinningNo(), readBonusNo());
    }

    private List<Integer> readWinningNo() {
        System.out.println(LINE_BREAK + READ_WINNING_NO);
        return TypeConverter.toList(readLine());
    }

    private int readBonusNo() {
        System.out.println(LINE_BREAK + READ_BONUS_NO);
        return TypeConverter.toInt(readLine());
    }
}
