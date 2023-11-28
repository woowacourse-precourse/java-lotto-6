package lotto.constant;

import java.text.NumberFormat;
import lotto.model.PurchasePrice;

public enum PrintOutMessage {
    PLZ_INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    LOTTO_COUNT("개를 구매했습니다."),
    PLZ_INPUT_WINNER_NUMBER("당첨 번호를 입력해 주세요."),
    PLZ_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTIC("당첨 통계"),
    DIVISION_LINE("---"),
    EARNING_POINT("총 수익률은 %s%%입니다."),
    EMPTY_LINE("\n"),
    COUNT("개");

    public final String message;

    PrintOutMessage(String message) {
        this.message = message;
    }

    public String getMessage(String matchingCount) {
        return String.format(message, matchingCount);
    }

    public static String printLottoCount(int count) {
        return count + LOTTO_COUNT.message;
    }


    public static String calculateEarningRate(long totalPrize, PurchasePrice purchasePrice) {
        double earningRate = (double) totalPrize / purchasePrice.getPrice() * 100;

        String formattedRate = String.format("%.2f", earningRate);

        NumberFormat nf = NumberFormat.getInstance();
        String formattedNumber = nf.format(Double.parseDouble(formattedRate));

        return EARNING_POINT.getMessage(formattedNumber);
    }
}
