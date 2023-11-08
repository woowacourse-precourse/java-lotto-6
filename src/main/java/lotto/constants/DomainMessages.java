package lotto.constants;

import java.util.List;
import lotto.domain.Lotto;

public enum DomainMessages {
    PROMPT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PROMPT_WINNING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATICS_TOP_BANNER("당첨 통계", "---"),
    LOTTO_PURCHASE_COUNT("%d개를 구매했습니다."),
    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    LOTTO_NUMBERS("[%d, %d, %d, %d, %d, %d]"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    DomainMessages(String message) {
        this.message = String.join("", message, System.lineSeparator());
    }

    DomainMessages(String... messages) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String message : messages) {
            messageBuilder
                    .append(message)
                    .append(System.lineSeparator());
        }
        messageBuilder.append(System.lineSeparator());
        this.message = messageBuilder.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithNumber(Integer number) {
        return String.format(message, number);
    }

    public String getMessageWithLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return String.format(message, lottoNumbers.toArray());
    }

    public String getMessageWithTotalReturn(Double decimal) {
        return String.format(message, decimal);
    }
}
