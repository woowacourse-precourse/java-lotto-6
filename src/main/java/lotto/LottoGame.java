package lotto;

import lotto.InputHandler;
import lotto.Lotto;
import lotto.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(int purchaseAmount) {
        this.lottos = generateLottos(purchaseAmount / 1000);
        this.winningNumbers = InputHandler.getWinningNumbers();
        this.bonusNumber = InputHandler.getBonusNumber();
    }

    private List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            generatedLottos.add(new Lotto(RandomNumbersGenerator.generateLottoNumbers()));
        }
        return generatedLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}