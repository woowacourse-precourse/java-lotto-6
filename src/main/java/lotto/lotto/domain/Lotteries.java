package lotto.lotto.domain;

import static lotto.lottoNumberGenerator.domain.LottoNumberGenerator.makeLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    private List<Lotto> lotteries;

    public Lotteries() {
        this.lotteries = new ArrayList<>();
    }

    private void validate(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }
    }

    public void publishLotteries(Integer amount) throws IllegalArgumentException {
        validate(amount);
        try {
            for (int i = 0; i < amount; i++) {
                List<Integer> numbers = makeLottoNumbers();
                this.lotteries.add(new Lotto(numbers));
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Integer getPublishedLotteryAmount() {
        return this.lotteries.size();
    }

    public void printAllLotteries() {
        for (Lotto lotto : this.lotteries) {
            lotto.printNumbers();
        }
    }

}
