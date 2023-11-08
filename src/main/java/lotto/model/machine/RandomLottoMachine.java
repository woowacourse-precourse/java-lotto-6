package lotto.model.machine;

import static lotto.model.lotto.LottoConstant.LOTTO_SIZE;
import static lotto.model.lotto.LottoConstant.MAX_NUMBER;
import static lotto.model.lotto.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.lotto.Lotto;

public class RandomLottoMachine implements LottoMachine {
    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = generateRandomNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }
}
