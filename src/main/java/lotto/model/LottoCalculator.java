package lotto.model;

public class LottoCalculator {
    private int[] counts = new int[5];

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
        double total = (counts[0] * LottoResult.Rank1.getNum()) + (counts[1] * LottoResult.Rank2.getNum()) + (counts[2] * LottoResult.Rank3.getNum()) + (counts[3] * LottoResult.Rank4.getNum()) + (counts[4] * LottoResult.Rank5.getNum());
        double result1 = total / (double) num;
        double resultnum = Math.round(result1 * 1000.0) /10.0;
        return resultnum;
    }
}
