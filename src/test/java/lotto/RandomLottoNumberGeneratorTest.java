package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import java.util.List;

class RandomLottoNumberGeneratorTest {
    private static final int lottoNumbersSize = 6;
    private static final int lottoNumberMin = 1;
    private static final int lottoNumberMax = 45;

    @DisplayName("로또 번호를 생성하면 6개고, 생성된 번호는 로또 범위안이어야 한다.")
    @RepeatedTest(50)
    void create() {
        //given
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();

        //when
        List<Integer> lottoNumbers = lottoNumberGenerator.create();

        //then
        assertThat(lottoNumbers.size())
                .isEqualTo(lottoNumbersSize);

        lottoNumbers.forEach(number -> assertThat(number)
                .isGreaterThanOrEqualTo(lottoNumberMin)
                .isLessThanOrEqualTo(lottoNumberMax));
    }
}