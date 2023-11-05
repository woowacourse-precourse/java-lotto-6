package lotto;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBERS_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    @DisplayName("로또가 로또번호 목록을 받아 생성된다.")
    class createLotto {

        @DisplayName("[실패] 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            //given
            List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

            //when //then
            assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_LOTTO_NUMBERS_AMOUNT.toString());
        }

        @DisplayName("[실패] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            //given
            List<Integer> duplicatedNumbers = List.of(1, 2, 3, 4, 5, 5);

            //when //then
            assertThatThrownBy(() -> Lotto.from(duplicatedNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATED_LOTTO_NUMBERS.toString());
        }

        @DisplayName("[실패] 로또 번호가 지정된 범위 내에 없으면 예외가 발생한다.")
        @Test
        void createLottoByNotInRangeOfLotto() {
            //given
            List<Integer> notInRangeNumbers = List.of(1, 2, 3, 4, 47, 56);

            //when //then
            assertThatThrownBy(() -> Lotto.from(notInRangeNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_IN_RANGE_LOTTO_NUMBER.toString());
        }
    }
}
