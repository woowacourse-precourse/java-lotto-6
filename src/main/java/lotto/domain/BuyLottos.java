package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class BuyLottos {
    private final List<Lotto> buyLottos;

    public BuyLottos(List<Lotto> buyLottos, List<Integer> randomNumbers) {
        this.buyLottos = buyLottos;
    }

    public List<Lotto> getBuyLottos() {
        return buyLottos;
    }

    private List<Lotto> generateLottoNumbersOfBuy(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(sortLottoNumbers(generateLottoNumbers())));
        }
        return lottos;
    }

    private List<Integer> sortLottoNumbers(List<Integer> generateLottoNumbers) {
        return generateLottoNumbers.stream().sorted().collect(Collectors.toList());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
