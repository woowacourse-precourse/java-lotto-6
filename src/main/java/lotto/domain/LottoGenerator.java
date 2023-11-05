package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> myLotto;
    private List<Integer> numbers;

    public LottoGenerator(int amount) {
        myLotto = new ArrayList<>();
        generate(amount);
    }

    private void generate(int amount) {
        while (amount > 0) {
            this.numbers = RandomNumberGenerator.getNumbers();
            sort();
            myLotto.add(new Lotto(this.numbers));
            amount--;
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }
}
