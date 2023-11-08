package lotto.domain.number;

import lotto.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    void 생성시_숫자가_6개가_아닌_리스트가_주어진_경우_예외를_발생한다() {
        List<LottoNumber> lottoNumbers = this.generateLottoNumbers(1, 2, 3, 4, 5);

        Assertions.assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_NOT_ENOUGH.message());
    }

    @Test
    void 생성시_비어있는_리스트가_주어진_경우_예외를_발생한다() {
        Assertions.assertThatThrownBy(() -> new LottoNumbers(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_IS_EMPTY.message());
    }

    @Test
    void 생성시_중복된_번호가_존재하는_경우_예외를_발생한다() {
        List<LottoNumber> lottoNumbers = this.generateLottoNumbers(1, 2, 3, 3, 4, 5);

        Assertions.assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.message());
    }

    @Test
    void 정수_리스트가_주어진_경우_히트_카운트를_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(this.generateLottoNumbers(1, 2, 3, 4, 5, 6));

        int hitCount = lottoNumbers.getHitCount(numbers);

        assertEquals(6, hitCount);
    }

    private List<LottoNumber> generateLottoNumbers(int... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }
        return lottoNumbers;
    }
}