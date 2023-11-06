package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Player;

public class Message {
    private static final String NEW_LINE = System.lineSeparator(),
            PROMPT_MONEY = "구입금액을 입력해 주세요.",
            PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.",
            PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.",
            INVALID_MONEY_ERROR = "[ERROR] 구입금액은 1,000원 단위 양수입니다.",
            INVALID_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6자리 숫자입니다.",
            INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";

    private final Messenger messenger;
    private final MessageBuilder messageBuilder;


    public Message(Messenger messenger, MessageBuilder messageBuilder) {
        this.messenger = messenger;
        this.messageBuilder = messageBuilder;
    }

    public void print(Player player) {
        print(messageBuilder.build(player));
    }

    public void print(Player player, LottoResult lottoResult) {
        print(messageBuilder.build(player, lottoResult));
    }

    public void newLine() {
        print(NEW_LINE);
    }

    public void promptMoney() {
        print(PROMPT_MONEY);
    }

    public void promptWinningNumbers() {
        print(PROMPT_WINNING_NUMBERS);
    }

    public void promptBonusNumber() {
        print(PROMPT_BONUS_NUMBER);
    }

    public void invalidMoneyError() {
        print(INVALID_MONEY_ERROR);
    }

    public void invalidWinningNumbersError() {
        print(INVALID_WINNING_NUMBERS_ERROR);
    }

    public void invalidBonusNumberError() {
        print(INVALID_BONUS_NUMBER_ERROR);
    }

    private void print(String string) {
        messenger.print(string);
    }
}
