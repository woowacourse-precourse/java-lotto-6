package lotto.domain;

import static lotto.constants.Constants.ZERO;

import lotto.Lotto;
import lotto.ui.OutputView;

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

    public List<Lotto> getMyLotto() {
        return myLotto;
    }

    private void generate(int amount) {
        try {
            while (amount > ZERO) {
                this.numbers = RandomNumberGenerator.getNumbers();
                sort();
                myLotto.add(new Lotto(this.numbers));
                amount--;
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printError(illegalArgumentException.getMessage());
            generate(amount);
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }
}
