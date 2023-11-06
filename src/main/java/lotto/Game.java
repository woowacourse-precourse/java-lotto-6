package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoNumberGenerator.generateRandomLottoNumber;

public class Game {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    private Game(List<Integer> winningNumbers,
                 Integer bonusNumber,
                 Integer numberOfLottos) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.lottos = new ArrayList<>();
        while (numberOfLottos != lottos.size()) {
            lottos.add(new Lotto(generateRandomLottoNumber()));
        }
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Rank> calculateRanks() {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningNumbers, bonusNumber))
                .toList();
    }

}
