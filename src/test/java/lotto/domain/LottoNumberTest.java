package lotto.domain;

import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 46, 100})
    void 생성자는_범위를_벗어난_숫자가_주어지면_예외를_던진다(int number) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 12, 22, 32})
    void equals는_객체_내부값을_비교해_판단한다(int number) {
        assertEquals(new LottoNumber(number), new LottoNumber(number));
    }
}
