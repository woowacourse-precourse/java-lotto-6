package lotto.model;

import java.util.Map;

public class LottoProfit {
    private final Map<String, Integer> lottoResult;
    private final Money money;
    private Double result;

    public LottoProfit(Map<String, Integer> lottoResult, Money money) {
        this.lottoResult = lottoResult;
        this.money = money;
    }

    public Double getResult(){
        return result;
    }

    private int calculateSum() {
        int sum = 0;
        sum += lottoResult.get("1st") * 2000000000;
        sum += lottoResult.get("2nd") * 30000000;
        sum += lottoResult.get("3rd") * 1500000;
        sum += lottoResult.get("4th") * 50000;
        sum += lottoResult.get("5th") * 5000;
        return sum;
    }
}
