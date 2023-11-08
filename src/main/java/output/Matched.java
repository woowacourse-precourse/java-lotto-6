package output;

import java.util.Arrays;
import value.*;

public class Matched {
    private final int[] count = new int[6];
    // totalcount, first, second, third, fourth, fifth

    public Matched() {
    }

    public void showStatistics() {
        System.out.println(LottoDefaultMessage.RESULT_STATISTICS.getString());
        System.out.println(LottoDefaultMessage.FIFTH_PRIZE.getString() + count[5] + "개");
        System.out.println(LottoDefaultMessage.FOURTH_PRIZE.getString() + count[4] + "개");
        System.out.println(LottoDefaultMessage.THIRD_PRIZE.getString() + count[3] + "개");
        System.out.println(LottoDefaultMessage.SECOND_PRIZE.getString() + count[2] + "개");
        System.out.println(LottoDefaultMessage.FIRST_PRIZE.getString() + count[1] + "개");
        System.out.println(LottoDefaultMessage.TOTAL_EARN_RATIO_START.getString()
                + calculateWinningPriceRatio()
                + LottoDefaultMessage.TOTAL_EARN_RATIO_END.getString());

        System.out.println(Arrays.toString(count));
    }

    public float calculateWinningPriceRatio() {
        return (float) (count[1] * LottoDefaultValue.FIRST_PRIZE.getNumber()
                + count[2] * LottoDefaultValue.SECOND_PRIZE.getNumber()
                + count[3] * LottoDefaultValue.THIRD_PRIZE.getNumber()
                + count[4] * LottoDefaultValue.FOURTH_PRIZE.getNumber()
                + count[5] * LottoDefaultValue.FIFTH_PRIZE.getNumber())
                / (count[0] * LottoDefaultValue.LOTTO_PRICE.getNumber()) * 100;
    }

    public void updateMatched(int matchedCount, boolean matchedBonusNum) {
        count[0]++;
        if (matchedCount == 6) {
            count[7 - matchedCount]++;
            return;
        }
        if (matchedBonusNum && matchedCount == 5) {
            count[7 - matchedCount]++;
            return;
        }
        if (matchedCount >= 3) {
            count[8 - matchedCount]++;
        }
    }
}
