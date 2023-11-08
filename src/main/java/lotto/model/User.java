package lotto.model;

import java.util.List;
import lotto.utils.Constants;

public class User {
    private final int SECOND_MATCH_COUNT = 5;
    private final int CONVERT_PERCENT = 100;
    private final int count;
    private final LottoTickets lottoTickets;

    public User(int count, LottoTickets lottoTickets) {
        this.count = count;
        this.lottoTickets = lottoTickets;
    }

    public void compareWinningLotto(WinningLotto winningLotto) {
        for (Lotto lotto : lottoTickets.getLotto()) {
            int countCorrectNumber = (int) winningLotto.getWinningLotto().stream()
                    .filter(number -> lotto.isContain(number))
                    .count();

            boolean checkBonus =
                    (countCorrectNumber == SECOND_MATCH_COUNT) && lotto.isContain(winningLotto.getBonusNumber());

            WinningResult.countLottoResult(countCorrectNumber, checkBonus);
        }
    }

    public double calculateProfit(int money) {
        double totalPrice = (double) WinningResult.calculateTotalPrice();

        return totalPrice / money * CONVERT_PERCENT;
    }

    public int getMoney() {
        return count * Constants.ONE_LOTTO_PRICE;
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottoList() {
        return lottoTickets.getLotto();
    }
}
