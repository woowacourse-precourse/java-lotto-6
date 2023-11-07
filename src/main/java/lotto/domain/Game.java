package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Generator;

public class Game {
    private final Pay pay;
    private List<Lotto> userLottos;
    private Lotto winnerNumber;
    private BonusNumber bonusNumber;

    public Game(int pay) {
        this.pay = new Pay(pay);
        generateUserLottos();
    }

    private void generateUserLottos() {
        this.userLottos = IntStream.range(0, pay.getLottoAmounts())
                .mapToObj(i -> new Lotto(Generator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    public void generateWinnerNumber(List<Integer> winnerNumber) {
        this.winnerNumber = new Lotto(winnerNumber);
    }

    public void generateBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Lotto> getLottos() {
        return userLottos;
    }
}
