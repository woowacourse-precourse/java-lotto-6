package lotto.lotto.domain;

import static lotto.numberGenerator.domain.NumberGenerator.makeLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    private final List<Lotto> lotteries;

    public Lotteries() {
        this.lotteries = new ArrayList<>();
    }

    private void validate(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] amount must be greater than zero");
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

    public List<Integer> calculateAllLottoRanks(List<Integer> winningNumbers) {
        List<Integer> ranks = new ArrayList<>();
        for (Lotto lotto : this.lotteries) {
            ranks.add(lotto.calculateLottoRank(winningNumbers));
        }
        return ranks;
    }

}
