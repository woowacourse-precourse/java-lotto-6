package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    void createTest(){
        LottoNumber number = LottoNumber.getInstance(1);
        LottoNumber expected = LottoNumber.getInstance(1);
        assertEquals(number, expected);
    }

    @DisplayName("로또 번호가 45보다 크거나 1보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 99})
    void createLottoByGreaterThanMaxOrLesserThanMin(int input) {
        assertThatThrownBy(() -> LottoNumber.getInstance(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 45보다 크거나 1보다 작을수 없습니다.");
    }
}
