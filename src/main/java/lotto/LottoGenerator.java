package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final Integer countLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoGenerator(Integer countLotto) {
        this.countLotto = countLotto;
    }

    public List<Lotto> generateLottos() {

        for (int i = 0; i < countLotto; i++) {
            lottos.add(generateLotto(generateNumbers()));
        }
        return lottos;
    }

    public Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}
