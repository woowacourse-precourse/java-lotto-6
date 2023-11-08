package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;
import lotto.util.LottoUtil;

import java.util.List;

public class LottoService {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    public void purchaseLottos(Player player, int numberOfLottos) {
        for (int i = 0; i < numberOfLottos; i++) {
            player.buyLotto(generateLotto());
        }
    }

    public LottoResult calculateResult(Player player, List<Integer> winningNumbers, int bonusNumber) {
        return player.calculateResult(winningNumbers, bonusNumber);
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = LottoUtil.generateRandomNumber(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH);
        return new Lotto(randomNumbers);
    }

    public int calculateNumberOfLottos(int purchaseAmount) {
        return purchaseAmount / Lotto.PRICE;
    }
}
