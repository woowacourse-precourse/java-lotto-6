package lotto.model;

import java.util.List;

public class User {
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

            boolean checkBonus = (countCorrectNumber == 5) && lotto.isContain(winningLotto.getBonusNumber());

            WinningResult.countLottoResult(countCorrectNumber, checkBonus);

        }
    }

    public double calculateProfit(int money) {
        double totalPrice = (double) WinningResult.calculateTotalPrice();
        return totalPrice / money * 100;
    }

    public int getMoney() {
        return count * 1000;
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottoList() {
        return lottoTickets.getLotto();
    }
}
