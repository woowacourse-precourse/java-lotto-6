package lotto.model.lotto;

import static lotto.utils.LottoConstant.LOTTO_SIZE;
import static lotto.utils.LottoConstant.MAX_NUMBER;
import static lotto.utils.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoMachine implements LottoMachine{
    @Override
    public Lotto generateLotto() {
        List<Integer> numbers = generateRandomNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }
}
