package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> LottoFixture.createLotto(numbers))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> LottoFixture.createLotto(numbers))
                .isInstanceOf(ExistDuplicatedNumberException.class);
    }

    @Test
    void 당첨_번호와_일치하는_로또_번호의_수를_센다() {
        // given
        List<LottoNumber> winningNumbers = LottoFixture.createLottoNumbers(List.of(1, 3, 5, 7, 9, 11));

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = LottoFixture.createLotto(lottoNumbers);

        // when
        int count = lotto.countCorrectNumbers(winningNumbers);

        // then
        assertThat(count).isEqualTo(3);
    }

    @CsvSource({"1, true", "7, false"})
    @ParameterizedTest
    void 로또_번호_중에_보너스_번호가_존재하면_true_를_반환한다(String number, boolean expected) {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = LottoFixture.createLotto(lottoNumbers);
        LottoNumber bonusNumber = LottoNumber.createWith(number);

        // when

        boolean result = lotto.hasBonusNumber(bonusNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
