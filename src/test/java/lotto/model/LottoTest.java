package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.DuplicateNumbersException;
import lotto.exception.InvalidLottoSizeException;
import lotto.fixture.LottoFixture;
import lotto.fixture.NumberFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.fromNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.fromNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(DuplicateNumbersException.class);
    }

    @CsvSource({"45, false", "10, false", "6, true"})
    @ParameterizedTest
    void 해당_넘버가_로또에_포함되어_있는지_여부를_반환한다(int num, boolean expected) {
        // given
        Number number = NumberFixture.create(num);
        Lotto lotto = LottoFixture.create(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.contains(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @MethodSource("provideParametersForCountMatchingNumbers")
    @ParameterizedTest()
    void 해당_로또와_몇개의_수가_일치하는지_개수를_반환한다(String lottoNumber, String winningLottoNumber, int expected) {
        // given
        Lotto lotto = LottoFixture.create(lottoNumber);
        Lotto winningLotto = LottoFixture.create(winningLottoNumber);
        List<Number> lottoNumbers = winningLotto.getLottoNumbers();

        // when
        int result = lotto.countMatchingNumbers(lottoNumbers);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideParametersForCountMatchingNumbers() {
        return Stream.of(Arguments.of("1,2,3,4,5,6", "1,2,3,10,11,12", 3),
                Arguments.of("1,5,10,15,20,25", "1,5,10,20,40,45", 4),
                Arguments.of("1,2,3,4,5,6", "10,11,12,20,40,45", 0),
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6", 6)
        );
    }
}
