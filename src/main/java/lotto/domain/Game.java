package lotto.domain;

import java.util.List;

//너무 넓은 의미를 갖고 있는 단어인 것 같다. 더 로또 계산과 관련된 로직을 포함하는 클래스라는 의미를 나타내는 이름이 어떤지?... LottoMachine??..
public class Game {
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private Integer bonusNumber;

    public Game(Lotto winningLotto,
                Integer bonusNumber,
                List<Lotto> lottos) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    private void validate(Lotto winningLotto, Integer bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getLottoNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호가 보너스 번호를 포함하고 있습니다.");
        }
    }

    public List<Rank> calculateRanks() {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto.getLottoNumbers(), bonusNumber))
                .toList();
    }
}
