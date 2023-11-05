package lotto.view;

import lotto.constants.OutputMessage;
import lotto.view.dto.LottoResult;

import java.util.Map;
import java.util.StringJoiner;

import static lotto.constants.OutputMessage.*;

public final class OutputView {

    private OutputView() {}

    public static String purchaseQuantity(int quantity) {
        return String.format(PURCHASE_QUANTITY.getMessage(), quantity);
    }

    public static String lottoResult(LottoResult lottoResult) {
        StringJoiner result = new StringJoiner("\n");

        result.add(String.format(RANK_5.getMessage(), lottoResult.getRank5()));
        result.add(String.format(RANK_4.getMessage(), lottoResult.getRank4()));
        result.add(String.format(RANK_3.getMessage(), lottoResult.getRank3()));
        result.add(String.format(RANK_2.getMessage(), lottoResult.getRank2()));
        result.add(String.format(RANK_1.getMessage(), lottoResult.getRank1()));

        return result.toString();
    }

    public static String profitRate(double profitRate) {
        return String.format(PROFIT_RATE.getMessage(), profitRate);
    }

}
