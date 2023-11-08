package lotto.enums;

import java.text.MessageFormat;

public enum LottoViewConstantMessages {
    PURCHASE_PRICE_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_QUANTITY_MESSAGE("{0}개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_TITLE("당첨 통계"),
    SPLIT_BAR("---"),
    THREE_MATCH_MESSAGE("3개 일치 ({0}원) - {1}개"),
    FOUR_MATCH_MESSAGE("4개 일치 ({0}원) - {1}개"),
    FIVE_MATCH_MESSAGE("5개 일치 ({0}원) - {1}개"),
    BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 ({0}원) - {1}개"),
    SIX_MATCH_MESSAGE("6개 일치 ({0}원) - {1}개"),
    INCOME_RATE_MESSAGE("총 수익률은 {0}%입니다.");
    private final String message;

    LottoViewConstantMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MessageFormat getMessageByMessageFormat() {
        return new MessageFormat(message);
    }
}
