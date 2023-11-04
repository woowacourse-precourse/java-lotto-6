package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final Integer price;
    int n;

    public LottoGenerator(Integer price) {
        validatePrice(price);
        this.price = price;
        this.n = price / 1000;
    }

    private List<Integer> generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return numbers;
    }

    public Lottos newLotto() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < n; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }
        return lottos;
    }

    private void validatePrice(Integer price) {
        final int MAX = 1000;
        if (price > MAX) {
            throw new IllegalArgumentException();
        }
    }

}