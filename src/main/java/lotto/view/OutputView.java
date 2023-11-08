package lotto.view;

import lotto.dto.response.PurchasePriceResponse;
import lotto.dto.response.WinningResponse;
import java.util.List;

public interface OutputView {
    String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    String PURCHASE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    String WINNING_RESULT_MESSAGE_PREFIX = "당첨 통계";
    String WINNING_RESULT_SEPARATE_LINE = "---";
    String MATCH_COUNT_FORMAT = "%d개 일치";
    String MATCH_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    String WINNING_PRICE_COUNT_FORMAT = " (%s원) - %d개";
    String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    void printPurchasePriceQuestionMessage();
    void printWinningNumberQuestionMessage();
    void printBonusNumberQuestionMessage();
    void printPurchaseLottos(final List<PurchasePriceResponse> purchasePriceResponses);
    void printWinningStatistic(final WinningResponse winningResponse);
}
