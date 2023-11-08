package lotto;

import java.util.List;

public class Converter {


    public static int parseToInt(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException wrongType) {
            throw new IllegalArgumentException("정수를 입력해주세요");
        }
    }

    public enum Prize {
       firstPrize(2000000000), secondPrize(30000000), thridPrize(1500000), forthPrize(50000)
        , fifthPrize(5000), noPrize(0);

        private final int prizeAmout;

       Prize(int prizeAmout) {
           this.prizeAmout = prizeAmout;
       }

       public int getPrizeAmount() {
           return prizeAmout;
       }
    }

    public int carculateWinPrize(List<Integer> wins) {
        int sum = 0;
        for (int i = 0; i < wins.size(); i++) {
            sum += wins.get(i) * Prize.values()[i].getPrizeAmount();
        }
        return sum;
    }
}
