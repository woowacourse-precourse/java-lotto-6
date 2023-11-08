package lotto.global.common;

public enum GameMessage {

    NEW_LINE_MESSAGE("\n"),
    PURCHASE_MESSAGE("개를 구매했습니다.\n"),
    WINNING_HISTORY_MESSAGE("\n당첨 통계\n---\n"),
    FIVETH_PRIZE_MESSAGE("3개 일치 (5,000원) - "),
    FOURTH_PRIZE_MESSAGE("4개 일치 (50,000원) - "),
    THIRD_PRIZE_MESSAGE("5개 일치 (1,500,000원) - "),
    SECOND_PRIZE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PRIZE_MESSAGE("6개 일치 (2,000,000,000원) - "),
    COUNT_MESSAGE("개\n"),
    MY_ROI_MESSAGE("총 수익률은 "),
    PERCENTAGE_MESSAGE("%입니다.\n"),
    PURCHASE_PRICE_ERROR_MESSAGE("구입 금액은 1,000원 단위로 입력받으며 1,000원으로 나누어떨어져야 합니다.\n"),
    LOTTO_NUMBERS_COUNT_ERROR_MESSAGE("로또 번호는 쉼표(,)를 기준으로 6개여야 합니다.\n"),
    LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE("로또 번호는 중복되지 않는 숫자 6개여야 합니다.\n"),
    LOTTO_NUMBER_FORMAT_ERROR_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n"),
    BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.\n"),
    PURCHASE_PRICE_MESSAGE("구입 금액을 입력해 주세요.\n"),
    WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.\n");

    public final String message;

    GameMessage(String message) {
        this.message = message;
    }
}