package lotto.domain;

import static lotto.domain.LottoDetails.LOTTO_MAXIMUM;
import static lotto.domain.LottoDetails.LOTTO_MINIMUM;
import static lotto.domain.LottoDetails.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Money money) {
        lottos = new ArrayList<>();
        generateLottos(money);
    }

    private void generateLottos(Money money) {
        int count = money.getNumbersOfLotto();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM, LOTTO_MAXIMUM, LOTTO_SIZE));
            lottos.add(lotto);
        }
    }

    public List<Optional<Rank>> getRanks(WinningLotto winningLotto) {
        return lottos.stream().map(lotto -> Rank.sortRank(lotto, winningLotto)).toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
