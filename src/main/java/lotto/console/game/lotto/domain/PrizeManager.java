package lotto.console.game.lotto.domain;

import java.util.List;

public class PrizeManager {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void registerWinningNumbers(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }
    public void registerBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public PrizeDetail generatePrizeDetailByLottos(List<Lotto> lottos) {
        PrizeDetail prizeDetail = new PrizeDetail();
        for (Lotto lotto : lottos) {
            prizeDetail.updateDetailByLotto(lotto.getNumbers(), winningNumbers, bonusNumber);
        }
        return prizeDetail;
    }
}
