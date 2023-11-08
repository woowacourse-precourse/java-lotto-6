package lotto.policy;

public class LottoPricePolicy implements PricePolicy {

    @Override
    public int price() {
        return 1_000;
    }

}
