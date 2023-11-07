package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Generator;

public class Game {
    private List<Lotto> userLottos;
    private Lotto winnerNumber;
    private BonusNumber bonusNumber;

    public void generateUserLottos(int amount) {
        this.userLottos = IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(Generator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    public void generateWinnerNumber(String winnerNumber) {
        this.winnerNumber = new Lotto(winnerNumber);
    }

    public void generateBonusNumber(String bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Lotto> getLottos() {
        return userLottos;
    }
}
