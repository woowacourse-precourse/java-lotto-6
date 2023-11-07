package lotto;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoMachine;

public class FixedLottoMachine implements LottoMachine {
    private List<Integer> numbers;
    public FixedLottoMachine(List<Integer> numbers){
        this.numbers = numbers;
    }


    @Override
    public Lotto generateLotto() {
        return new Lotto(numbers);
    }
}
