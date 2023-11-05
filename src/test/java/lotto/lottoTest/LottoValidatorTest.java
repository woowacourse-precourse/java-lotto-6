package lotto.lottoTest;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoValidatorTest {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static Lotto lotto;

    @BeforeEach
    public void init() {
        lotto = LottoGenerator.generateRandomLotto();
    }

    @Test
    @DisplayName("로또_번호_갯수_테스트")
    public void lottoNumberCountTest() {
        //given

        //when

        //then
        assertThat(lotto.getLotto().size()).isEqualTo(LOTTO_NUMBERS_COUNT);
    }

    @Test
    @DisplayName("로또_번호_범위_초과_테스트")
    public void lottoNumberRangeExceptionTest() {
        //given

        //when

        //then
        for (int number : lotto.getLotto()) {
            assertThat(number)
                    .isGreaterThan(0)
                    .isLessThan(46);
        }
    }

    @Test
    @DisplayName("로또_번호_중복_테스트")
    public void lottoNumberDuplicateTest() {
        //given

        //when

        //then
        assertThat(lotto.getLotto()
                .stream().distinct()
                .count())
                .isEqualTo(LOTTO_NUMBERS_COUNT);
    }
}
