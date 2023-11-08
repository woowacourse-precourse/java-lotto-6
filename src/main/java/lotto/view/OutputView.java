package lotto.view;

import lotto.GameUtils;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PRINT_RANK_STATISTICS_MESSAGE = """
            당첨 통계
            ---
            """;
    private static final String PRINT_PROFIT_RATE_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String PRINT_PROFIT_RATE_MESSAGE_SUFFIX = "%입니다.";

    public void printException(String exceptionMessage) {
        System.out.println(ERROR_PREFIX + exceptionMessage);
    }

    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurchaseNumber(int number) {
        System.out.println(number + PRINT_LOTTO_PURCHASE_MESSAGE);
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }

    public void requestWinningLotto() {
        System.out.println(REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printRankStatistics(String rankStatistics) {
        System.out.println(PRINT_RANK_STATISTICS_MESSAGE + rankStatistics);
    }

    public void printProfitRate(double profitRate) {
        System.out.println(PRINT_PROFIT_RATE_MESSAGE_PREFIX + GameUtils.convertToPercentageFirstDecimalPlace(profitRate) + PRINT_PROFIT_RATE_MESSAGE_SUFFIX);
    }
}
