package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.input.constant.Constant.LOTTO_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LOTTO_NUMBER_SIZE) {
            int number = pickNumberInRange(1, 45);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }


}
