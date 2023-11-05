package lotto.enums;

import java.text.DecimalFormat;

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
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(W5.winCount + "개 일치 (" + df.format(W5.reward) + "원) - " + W5.result + "개");
        System.out.println(W4.winCount + "개 일치 (" + df.format(W4.reward) + "원) - " + W4.result + "개");
        System.out.println(W3.winCount + "개 일치 (" + df.format(W3.reward) + "원) - " + W3.result + "개");
        System.out.println(W2.winCount + "개 일치, 보너스 볼 일치 (" + df.format(W2.reward) + "원) - " + W2.result + "개");
        System.out.println(W1.winCount + "개 일치 (" + df.format(W1.reward) + "원) - " + W1.result + "개");
        System.out.println("총 수익률은 " + getRewardPercent(amount) + "입니다.");
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
