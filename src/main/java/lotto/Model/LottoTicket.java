package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int numberOfLottos) {
        this.lottos = generateLottos(numberOfLottos);
    }

    private List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
