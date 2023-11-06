package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;

public enum LottoValue {
    THREE(3, 5000, "3개 일치 (5000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int count;
    private final int winningMoney;
    private final String result;

    LottoValue(int count, int winningMoney, String result) {
        this.count = count;
        this.winningMoney = winningMoney;
        this.result = result;
    }

    public static LottoValue getLottoValue(int count) {
        for (LottoValue lottoValue : LottoValue.values()) {
            if (lottoValue.count == count) {
                return lottoValue;
            }
        }
        return null;
    }

    public static void printResult(List<LottoValue> tmp){
        for (LottoValue lottoValue : LottoValue.values()) {
            System.out.println(lottoValue.result + " - " + tmp.stream().filter(a -> a.name().equals(lottoValue.name())).count() + "개");
        }
    }

    public static void showProfit(List<LottoValue> tmp, int numOfLotto) {
        int total = 0;
        for (LottoValue lottoValue : tmp) {
            total += lottoValue.winningMoney;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("총 수익률은 " + df.format(((float) total/(numOfLotto*1000))*100) + "%입니다.");
    }
}
