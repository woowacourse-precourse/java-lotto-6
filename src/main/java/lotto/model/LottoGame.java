package lotto.model;

import java.util.List;
import lotto.vo.BonusNumber;

public class LottoGame {

    private final Player player;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(final Player player, final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.player = player;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame createGame(final Player player, final Lotto lotto, final BonusNumber bonusNumber) {
        return new LottoGame(player, lotto, bonusNumber);
    }

    private int countMatchedNumber(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        return (int) playerNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean containBonusNumber(BonusNumber bonusNumber, List<Integer> playerNumbers) {
        Integer number = bonusNumber.number();
        if (playerNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
