package lotto.domain.testutil;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

/**
 * 테스트 시, 고정 번호로 로또를 생성하기 위한 LottoGenerator
 */
public final class FixedLottoGenerator implements LottoGenerator {

    /**
     * 객체 생성 시, 고정으로 저장해둘 로또 번호
     */
    private final List<Integer> numbers;

    public FixedLottoGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 고정 로또 번호를 그대로 사용하여 Lotto 객체 생성
     */
    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
