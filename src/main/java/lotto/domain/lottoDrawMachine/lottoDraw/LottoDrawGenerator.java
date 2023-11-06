package lotto.domain.lottoDrawMachine.lottoDraw;

import java.util.List;

public class LottoDrawGenerator {
    public LottoDraw generate(List<Integer> numbers, Integer bonusNumber){
        numbers.add(bonusNumber);
        return new LottoDraw(numbers);
    }
}
