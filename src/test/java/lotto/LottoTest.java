package lotto;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @DisplayName("lotto.toDto 메서드 성공 테스트")
    @Test
    void toDto() {
        // given
        final LottoDto expected = new LottoDto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        final LottoDto actual = lotto.toDto();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("로또내의 숫자 포함 여부 성공 테스트")
    @CsvFileSource(files = "src/test/resources/lotto-find.csv", numLinesToSkip = 1)
    @ParameterizedTest
    void contains(
            @ConvertWith(StringSplitter.class) List<Integer> numbers,
            Integer numberToFind,
            boolean doesContain
    ) {
        final Lotto lotto = new Lotto(numbers);

        assertThat(lotto.contains(numberToFind)).isEqualTo(doesContain);
    }

    @DisplayName("로또 개수 비교에 성공 테스트")
    @CsvFileSource(files = "src/test/resources/lotto-match.csv", numLinesToSkip = 1)
    @ParameterizedTest
    void matchCount(
            @ConvertWith(StringSplitter.class) List<Integer> numbers,
            @ConvertWith(StringSplitter.class) List<Integer> anotherNumbers,
            final int matchCount
    ) {
        final Lotto lotto = new Lotto(numbers);
        final Lotto anotherLotto = new Lotto(anotherNumbers);

        final int actualMatchCount = lotto.matchCount(anotherLotto);

        assertThat(actualMatchCount).isEqualTo(matchCount);

    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
