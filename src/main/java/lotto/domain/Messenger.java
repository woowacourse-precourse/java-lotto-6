package lotto.domain;

import lotto.utils.MessageBuilder;
import lotto.utils.Writer;

public class Messenger {
    private final static String PROMPT_MONEY, PROMPT_WINNING_NUMBERS, PROMPT_BONUS_NUMBER,
            INVALID_MONEY_ERROR, INVALID_WINNING_NUMBERS_ERROR, INVALID_BONUS_NUMBER_ERROR;

    static {
        PROMPT_MONEY = "구입금액을 입력해 주세요.";
        PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

        INVALID_MONEY_ERROR = "[ERROR] 구입금액은 1,000원 단위 양수입니다.";
        INVALID_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6자리 숫자입니다.";
        INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";
    }

    public void print(Player player) {
        Writer.print(MessageBuilder.build(player));
    }

    public void print(Player player, LottoResult lottoResult) {
        Writer.print(MessageBuilder.build(player, lottoResult));
    }

    public void promptMoney() {
        Writer.print(PROMPT_MONEY);
    }

    public void promptWinningNumbers() {
        Writer.print(PROMPT_WINNING_NUMBERS);
    }

    public void promptBonusNumber() {
        Writer.print(PROMPT_BONUS_NUMBER);
    }

    public void invalidMoneyError() {
        Writer.print(INVALID_MONEY_ERROR);
    }

    public void invalidWinningNumbersError() {
        Writer.print(INVALID_WINNING_NUMBERS_ERROR);
    }

    public void invalidBonusNumberError() {
        Writer.print(INVALID_BONUS_NUMBER_ERROR);
    }

    public void newLine() {
        Writer.newLine();
    }
}
