package lotto.domain.lotto;

import java.util.List;
import lotto.numbers.SizedNumbersGenerator;

/**
 * 임의의 6자리 번호를 가진 로또를 생성해주는 객체
 */
public final class RandomLottoGenerator {
    /**
     * 6자리 List<Integer> 생성기
     */
    private final SizedNumbersGenerator sizedNumbersGenerator;

    /**
     * 외부에서 주입해주지 않을 경우, 생성기 디폴트 값은 1~45 사이의 6자리 숫자 리스트를 생성하도록 함
     */
    public RandomLottoGenerator(final SizedNumbersGenerator numbersGenerator) {
        if (numbersGenerator == null) {
            this.sizedNumbersGenerator = createDefaultSizedNumbersGenerator();
            return;
        }
        this.sizedNumbersGenerator = numbersGenerator;
    }

    public Lotto generate() {
        final List<Integer> numbers = this.sizedNumbersGenerator.generate();
        return new Lotto(numbers);
    }

    /**
     * 로또 번호 갯수 및 범위에 맞춘 디폴트 SizedNumbersGenerator 생성 로직
     */
    private SizedNumbersGenerator createDefaultSizedNumbersGenerator() {
        return new SizedNumbersGenerator(
                LottoNumber.MIN_LOTTO_NUMBER,
                LottoNumber.MAX_LOTTO_NUMBER,
                Lotto.LOTTO_NUMBERS_LENGTH
        );
    }

}
