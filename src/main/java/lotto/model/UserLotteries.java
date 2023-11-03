package lotto.model;

import java.util.List;

public class UserLotteries {

    private final List<Lotto> Lotteries;

    public UserLotteries(List<Lotto> lotteries) {
        Lotteries = lotteries;
    }

    public void sortAscendingAllLotto() {
        this.Lotteries.forEach(Lotto::sortAscending);
    }

    public int lotteriesCount() {
        return Lotteries.size();
    }

    public List<Lotto> getLotteries() {
        return Lotteries;
    }
}
