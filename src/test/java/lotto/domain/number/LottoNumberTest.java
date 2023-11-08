package lotto.domain.number;

import lotto.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest()
    @ValueSource(ints = {1, 4, 5})
    void 생성자로_범위내의_정수가_주어진_경우_캐싱된_인스턴스를_반환한다(int number) {
        LottoNumber lottoNumber = LottoNumber.from(number);

        Assertions.assertTrue(lottoNumber == LottoNumber.from(number));
    }

    @ParameterizedTest()
    @ValueSource(ints = {-1, 46, 100})
    void 생성자로_범위를_초과하는_정수가_주어진_경우_예외를_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_NOT_IN_RANGE.message());
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 12, 22})
    void 파라매터로_전달된_정수리스트에_number가_포함되는지를_반환한다(int number) {
        List<Integer> numbers = List.of(1, 12, 22, 24, 42, 44);
        LottoNumber lottoNumber = LottoNumber.from(number);

        Assertions.assertTrue(lottoNumber.isHit(numbers));
    }
}