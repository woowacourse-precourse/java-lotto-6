package lotto.model;

import java.util.List;

public class UserLotteries {

    private final List<Lotto> lotteries;

    public UserLotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public void sortAscendingAllLotto() {
        this.lotteries.forEach(Lotto::sortAscending);
    }

    public int lotteriesCount() {
        return lotteries.size();
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
