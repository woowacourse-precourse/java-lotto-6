package lotto.domain;

import static lotto.common.util.LottoUtil.HUNDRED;
import static lotto.common.util.LottoUtil.RANK_FIVE_PRICE;
import static lotto.common.util.LottoUtil.RANK_FOUR_PRICE;
import static lotto.common.util.LottoUtil.RANK_ONE_PRICE;
import static lotto.common.util.LottoUtil.RANK_THREE_PRICE;
import static lotto.common.util.LottoUtil.RANK_TWO_PRICE;
import static lotto.common.util.LottoUtil.ZERO;

public class Rank {
    private int five = ZERO.getNumber();
    private int four = ZERO.getNumber();
    private int three = ZERO.getNumber();
    private int two = ZERO.getNumber();
    private int one = ZERO.getNumber();

    public void five() {
        five++;
    }

    public void four() {
        four++;
    }

    public void three() {
        three++;
    }

    public void two() {
        two++;
    }

    public void one() {
        one++;
    }

    public int getFive() {
        return five;
    }

    public int getFour() {
        return four;
    }

    public int getThree() {
        return three;
    }

    public int getTwo() {
        return two;
    }

    public int getOne() {
        return one;
    }

    public double getResultPrice(double buyPrice) {

        int fivePrice = this.getFive() * RANK_FIVE_PRICE.getNumber();
        int fourPrice = this.getFour() * RANK_FOUR_PRICE.getNumber();
        int threePrice = this.getThree() * RANK_THREE_PRICE.getNumber();
        int twoPrice = this.getTwo() * RANK_TWO_PRICE.getNumber();
        int onePrice = this.getOne() * RANK_ONE_PRICE.getNumber();

        return ((double) (fivePrice + fourPrice + threePrice + twoPrice + onePrice) / buyPrice) * HUNDRED.getNumber();
    }
}
