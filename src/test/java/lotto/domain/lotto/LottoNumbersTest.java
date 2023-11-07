package lotto.domain.lotto;

import lotto.constants.LottoConsts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoNumbersTest {
    private LottoNumbers lottoNumbers;
    private Set<LottoNumber> lottoNumberSet;


    @BeforeEach
    void setUp() {
        lottoNumbers = LottoNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        lottoNumberSet = IntStream.rangeClosed(1, LottoConsts.LOTTO_NUMBERS_SIZE.getValue())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Test
    void 일치하는_번호_개수_계산() {
        // given
        final LottoNumbers otherLottoNumbers = LottoNumbers.from(List.of(3, 2, 1, 7, 9, 8));

        // when
        final int matchCount = lottoNumbers.countMatch(otherLottoNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스_번호_확인() {
        // given
        final LottoNumber bonusNumber = new LottoNumber(7);

        // when
        final boolean result = lottoNumbers.checkBonusNumber(bonusNumber);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 로또_번호_리스트_수정_불가_검증() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberSet);
        final Set<LottoNumber> numbers = lottoNumbers.numbers();

        // when & then
        assertThatThrownBy(() -> numbers.add(new LottoNumber(7)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 로또_번호_크기_불일치_예외_검증() {
        // given
        final Set<LottoNumber> invalidSizeNumbers = new HashSet<>(lottoNumberSet);
        invalidSizeNumbers.add(new LottoNumber(7)); // 번호 하나를 추가하여 사이즈 증가

        // when & then
        assertThatThrownBy(() -> new LottoNumbers(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_예외_검증() {
        // given
        final List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5); // 중복 번호 포함

        // when & then
        assertThatThrownBy(() -> LottoNumbers.from(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
