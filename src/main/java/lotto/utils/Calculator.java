package lotto.utils;

import static lotto.utils.LottoEnum.*;

import java.util.List;
import lotto.domain.model.ResultTable;

public class Calculator {

    public static int getLottoCount(int amountMoney) {
        return amountMoney / LOTTO_PRICE.getValue();
    }

    public static double getProfitRate(long totalPrice, long amountMoney) {
        return 100 * (double) totalPrice / amountMoney;
    }

    public static long evaluateTotalPrice(List<ResultTable> statistics) {
        return statistics.stream()
                .mapToLong(ResultTable::getTotalPrize).sum();
    }
}
