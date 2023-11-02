package lotto.domain;

import lotto.LottoConst;
import lotto.enums.LottoEnum;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static lotto.LottoConst.*;
import static lotto.enums.LottoEnum.*;

public class Result {

    private final Map<LottoEnum, Integer> result = new HashMap<>();


    public void count(LottoEnum lottoEnum) {
        result.put(lottoEnum, result.getOrDefault(lottoEnum, 0) + 1);
    }

    public void printResult(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("3개 일치 (" + df.format(W5.getReward()) + "원) - " + result.getOrDefault(W5, 0) + "개");
        System.out.println("4개 일치 (" + df.format(W4.getReward()) + "원) - " + result.getOrDefault(W4, 0) + "개");
        System.out.println("5개 일치 (" + df.format(W3.getReward()) + "원) - " + result.getOrDefault(W3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(W2.getReward()) + "원) - " + result.getOrDefault(W2, 0) + "개");
        System.out.println("6개 일치 (" + df.format(W1.getReward()) + "원) - " + result.getOrDefault(W1, 0) + "개");
        System.out.println("총 수익률은 " + getTotalReward(amount) + "%입니다.");
    }

    private double getTotalReward(int amount) {
        int W5 = LottoEnum.W5.getReward() * result.getOrDefault(LottoEnum.W5, 0);
        int W4 = LottoEnum.W4.getReward() * result.getOrDefault(LottoEnum.W4, 0);
        int W3 = LottoEnum.W3.getReward() * result.getOrDefault(LottoEnum.W3, 0);
        int W2 = LottoEnum.W2.getReward() * result.getOrDefault(LottoEnum.W2, 0);
        int W1 = LottoEnum.W1.getReward() * result.getOrDefault(LottoEnum.W1, 0);
        int total = W1 + W2 + W3 + W4 + W5;
        double totalDouble = 1.0 * total / (amount * LOTTO_PRICE);
        double round = totalDouble * 100.0;
//        DecimalFormat df = new DecimalFormat("###,###");
//        return df.format(new BigDecimal(round));
        return round;
    }
}
