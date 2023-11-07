package lotto.domain;

import java.util.List;

//너무 넓은 의미를 갖고 있는 단어인 것 같다. 더 로또 계산과 관련된 로직을 포함하는 클래스라는 의미를 나타내는 이름이 어떤지?... LottoMachine??..
public class Game {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Game(List<Integer> winningNumbers,
                Integer bonusNumber,
                List<Lotto> lottos) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
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
