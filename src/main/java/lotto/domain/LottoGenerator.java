package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {

    private final Integer price;
    int n;

    public LottoGenerator(Integer price) {
        validatePrice(price);
        this.price = price;
        this.n = price / 1000;
    }

    private List<Integer> generateLottoNumber() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 6) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new ArrayList<>(numbers.stream().toList());
    }

    public Lottos wishMeLuck() {
        Lottos lottos = new Lottos();
        for (int i = 0; i < n; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }
        return lottos;
    }

    private void validatePrice(Integer price) {
        final int MAX = 1000000;
        if (price > MAX) {
            throw new IllegalArgumentException();
        }
    }
}