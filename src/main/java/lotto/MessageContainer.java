package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.PrizeCategory;

public class MessageContainer {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String UNIT = "개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public List<String> createWinningDetails(Map<PrizeCategory, Integer> winningCounts) {
        List<String> WinningDetails = new ArrayList<>();
        WinningDetails.add(PrizeCategory.FIFTH.getMessage() + winningCounts.get(PrizeCategory.FIFTH) + UNIT);
        WinningDetails.add(PrizeCategory.FOURTH.getMessage() + winningCounts.get(PrizeCategory.FOURTH) + UNIT);
        WinningDetails.add(PrizeCategory.THIRD.getMessage() + winningCounts.get(PrizeCategory.THIRD) + UNIT);
        WinningDetails.add(PrizeCategory.SECOND.getMessage() + winningCounts.get(PrizeCategory.SECOND) + UNIT);
        WinningDetails.add(PrizeCategory.FIRST.getMessage() + winningCounts.get(PrizeCategory.FIRST) + UNIT);
        return WinningDetails;
    }

    public String createRateOfReturnMessage(double rateOfReturn) {
        return String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public String getPurchaseQuantityMessage(long purchaseQuantity) {
        return String.format(PURCHASE_QUANTITY_MESSAGE, purchaseQuantity);
    }

    public String getEnterPurchaseAmount() {
        return ENTER_PURCHASE_AMOUNT;
    }

    public String getEnterWinningNumbers() {
        return ENTER_WINNING_NUMBERS;
    }

    public String getEnterBonusNumbers() {
        return ENTER_BONUS_NUMBERS;
    }

    public String getWinningStatistics() {
        return WINNING_STATISTICS;
    }
}
