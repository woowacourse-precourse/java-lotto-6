package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.RandomLottoNumberGenerator;

/**
 * Lotto 객체들을 관리하는 클래스
 */
public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    /**
     * 발행할 로또 개수를 받아 로또 생성
     * @param count 발행할 로또 개수
     */
    public Lottos(Integer count) {
        for (int i = 0; i < count; i++) {
            addLotto();
        }
    }

    private void addLotto() {
        Lotto newLotto = makeLotto();

        lottos.add(newLotto);
    }

    private Lotto makeLotto() {
        List<Integer> numbers = RandomLottoNumberGenerator.makeNumber();

        return new Lotto(numbers);
    }
}
