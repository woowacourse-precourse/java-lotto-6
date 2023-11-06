package lotto.view.message;

import static lotto.domain.constants.LottoConstants.MATCH_BONUS_MESSAGE_FORMAT;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_AND_BONUS_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_AND_BONUS_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FIVE_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_FOUR_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_FOUR_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_MESSAGE_FORMAT;
import static lotto.domain.constants.LottoConstants.MATCH_SIX_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_SIX_PRICE;
import static lotto.domain.constants.LottoConstants.MATCH_THREE_COUNT;
import static lotto.domain.constants.LottoConstants.MATCH_THREE_PRICE;
import static lotto.domain.constants.LottoConstants.TOTAL_PROFIT_PERCENTAGE_FORMAT;

public enum OutputMessage {

    ASK_FOR_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    ANNOUNCE_FOR_PURCHASE_COUNT("%d개를 구매했습니다."),
    ASK_FOR_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    ANNOUNCE_FOR_TOTAL_PROFIT_PERCENTAGE_FORMAT(String.format("총 수익률은 %s입니다.",TOTAL_PROFIT_PERCENTAGE_FORMAT));

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public enum WinningStatisticsDetails {
        THREE_MATCH(String.format(MATCH_MESSAGE_FORMAT, MATCH_THREE_COUNT, MATCH_THREE_PRICE)),
        FOUR_MATCH(String.format(MATCH_MESSAGE_FORMAT, MATCH_FOUR_COUNT, MATCH_FOUR_PRICE)),
        FIVE_MATCH(String.format(MATCH_MESSAGE_FORMAT, MATCH_FIVE_COUNT, MATCH_FIVE_PRICE)),
        FIVE_AND_BONUS_MATCH(String.format(MATCH_BONUS_MESSAGE_FORMAT, MATCH_FIVE_AND_BONUS_COUNT, MATCH_FIVE_AND_BONUS_PRICE)),
        SIX_MATCH(String.format(MATCH_MESSAGE_FORMAT, MATCH_SIX_COUNT, MATCH_SIX_PRICE));

        private final String detail;

        WinningStatisticsDetails(String detail) {
            this.detail = detail;
        }

        public String getDetail(int number) {
            return String.format(detail, number);
        }
    }
}
