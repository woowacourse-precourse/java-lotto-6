package lotto.model;

public class LottoCalculator {

    private int[] counts = new int[5];
    private int earningPercentage;

    public int[] getCounts() {
        return counts;
    }

    public void lottoCalculator(int count, boolean bsnum) {
        if (count == 6) {
            counts[0]++;
        } else if (count == 5) {
            if (bsnum) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        } else if (count == 4) {
            counts[3]++;
        } else if (count == 3) {
            counts[4]++;
        }
    }

    public double earningPercentage(int num) {
        double total = counts[0] * 2000000000.0 + counts[1] * 30000000.0 + counts[2] * 1500000.0 + counts[3] * 50000.0 + counts[4] * 5000.0;
        double result1 = total / (double) num;
        double resultnum = Math.round(result1 * 1000.0) /10.0;
        return resultnum;
    }
}
