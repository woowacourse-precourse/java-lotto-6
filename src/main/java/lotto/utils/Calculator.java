package lotto.utils;

import static lotto.domain.LottoEnum.LOTTO_PRICE;

import java.util.Map;
import lotto.domain.StaticsEnum;
import lotto.domain.model.ResultTable;

public class Calculator {

    public static int getLottoCount(int amountMoney) {
        return amountMoney / LOTTO_PRICE.getValue();
    }

    public static double getProfitRate(long totalPrice, long amountMoney) {
        return 100 * (double) totalPrice / amountMoney;
    }

    public static long evaluateTotalPrice(Map<StaticsEnum, ResultTable> statistics) {
        return statistics.values().stream()
                .mapToLong(ResultTable::getTotalPrize).sum();
    }
}
