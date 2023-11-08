package lotto.domain.lottoDrawMachine.lottoDraw;

import java.util.List;

public class LottoDrawGenerator {
    public LottoDraw generate(List<Integer> numbers, Integer bonusNumber){
        return LottoDraw.of(numbers, bonusNumber);
    }
}
