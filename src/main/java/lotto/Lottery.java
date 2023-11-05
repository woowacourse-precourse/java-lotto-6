package lotto;

import lotto.Constant.LottoConstant;

public class Lottery {
    private final int cost;
    private final int numberOfLotto;

    public Lottery(int cost)
    {
        this.cost = cost;
        numberOfLotto = cost / LottoConstant.TICKET_PRICE;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

}
