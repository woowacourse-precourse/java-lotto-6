package lotto.enums;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

import static lotto.LottoConst.LOTTO_COUNT;
import static lotto.LottoConst.LOTTO_PRICE;

public enum LottoEnum {

    W1(LOTTO_COUNT, 0,2000000000, 0),
    W2(LOTTO_COUNT-1, 1,30000000, 0),
    W3(LOTTO_COUNT-1, 0,1500000, 0),
    W4(LOTTO_COUNT-2, 0,50000, 0),
    W5(LOTTO_COUNT-3, 0,5000, 0);


    private final int winCount;
    private final int bonusCount;
    private final int reward;
    private int result;


    LottoEnum(int winCount, int bonusCount, int reward, int result) {
        this.winCount = winCount;
        this.bonusCount = bonusCount;
        this.reward = reward;
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public static void printResult(int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printEnums();
        System.out.println("총 수익률은 " + getRewardPercent(amount) + "입니다.");
    }

    private static void printEnums() {
        LottoEnum[] values = LottoEnum.values();
        Arrays.sort(values, Comparator.reverseOrder());
        for (LottoEnum value : values) {
            System.out.println(getResultString(value));
        }
    }

    private static String getResultString(LottoEnum value) {
        DecimalFormat df = new DecimalFormat("###,###");
        if (value.equals(W2)){
            return value.winCount + "개 일치, 보너스 볼 일치 (" + df.format(value.reward) + "원) - " + value.result + "개";
        }
        return value.winCount + "개 일치 (" + df.format(value.reward) + "원) - " + value.result + "개";
    }

    private static String getRewardPercent(int amount) {
        int total = getTotal();
        double totalDouble = 100.0 * total / (amount * LOTTO_PRICE);
        DecimalFormat df = new DecimalFormat("0.0%");
        return df.format(totalDouble / 100.0);
    }

    private static int getTotal() {
        int total = 0;
        LottoEnum[] values = LottoEnum.values();
        for (LottoEnum value : values) {
            total += value.reward * value.result;
        }
        return total;
    }

    public static void getLottoEnum(int count, int bonusCount) {
        LottoEnum[] values = LottoEnum.values();
        for (LottoEnum value : values) {
            if (value.winCount == count && value.bonusCount == bonusCount) {
                value.result++;
                return;
            }
        }
    }



}
