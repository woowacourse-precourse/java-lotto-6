package lotto.domain.lotto.generator;

import java.util.List;
import lotto.domain.lotto.entity.Lotto;

public abstract class LottoGenerator {
    protected static final int LOTTO_NUMBER_START = 1;
    protected static final int LOTTO_NUMBER_END = 45;
    protected static final int LOTTO_SIZE = 6;

    protected abstract List<Integer> pickLottoNumbers();

    public Lotto generate() {
        List<Integer> lottoNumbers = pickLottoNumbers();
        return new Lotto(lottoNumbers);
    }
    //랜덤 로또 : 아무 값도 입력 안받고 그냥 Lotto 또는 List<>를 반환하면 됨
    // () -> Lotto
    //정답 로또 : List<Integer>를 입력받아 Lotto를 반환하면 됨
    // (List<Integer>) -> Lotto
    //정답 로또는 Generator를 사용하지 않는걸로?


    public Lotto generate(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
