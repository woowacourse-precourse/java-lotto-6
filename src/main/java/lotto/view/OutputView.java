package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.LottoResult;

import java.util.List;
import java.util.StringJoiner;

import static lotto.constants.OutputMessage.*;

public final class OutputView {

    private OutputView() {
    }

    public static void purchaseQuantity(int quantity) {
        String purchaseQuantity = String.format(PURCHASE_QUANTITY.getMessage(), quantity);
        System.out.println(purchaseQuantity);
    }

    public static void lotteries(List<Lotto> lotteries) {
        lotteries.forEach(lotto -> System.out.println(lotto));
    }

    public static void lottoResult(LottoResult lottoResult) {
        StringJoiner result = new StringJoiner("\n");

        result.add(String.format(RANK_5.getMessage(), lottoResult.getRank5()));
        result.add(String.format(RANK_4.getMessage(), lottoResult.getRank4()));
        result.add(String.format(RANK_3.getMessage(), lottoResult.getRank3()));
        result.add(String.format(RANK_2.getMessage(), lottoResult.getRank2()));
        result.add(String.format(RANK_1.getMessage(), lottoResult.getRank1()));

        System.out.println(PROFIT_RATE_INTRO);
        System.out.println(SEPARATOR);
        System.out.println(result);
    }

    public static void profitRate(double profitRate) {
        String format = String.format(PROFIT_RATE.getMessage(), profitRate);
        System.out.println(format);
    }

}
