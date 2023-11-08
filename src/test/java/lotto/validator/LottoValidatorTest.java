package lotto.validator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.ErrorMessage.ENTER_PROPER_LOTTO_COUNT;
import static lotto.constant.NumericConstant.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 번호의 갯수가 LOTTO_SIZE를 넘어가면 안된다")
    void validateIsProperSize() {
        List<Integer> haveManyNumber
                = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE + 1);
        List<Integer> haveFewNumber
                = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE - 1);

        assertThatThrownBy(() -> LottoValidator.validateIsProperSize(haveManyNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENTER_PROPER_LOTTO_COUNT);

        assertThatThrownBy(() -> LottoValidator.validateIsProperSize(haveFewNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENTER_PROPER_LOTTO_COUNT);
    }

    @ParameterizedTest
    @ValueSource(ints = {MIN_LOTTO_NUMBER-1, MAX_LOTTO_NUMBER+1})
    @DisplayName("로또 번호의 범위는 MIN_LOTTO_NUMBER와 MAX_LOTTO_NUMBER 사이여야한다.")
    void validateDuplicatedNumber(int number) {
        assertThatThrownBy(() -> LottoValidator.validateRangeOfNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENTER_PROPER_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호는 서로 중복되지 않아야 한다")
    void validateRangeOfNumber() {
        List<Integer> duplicatedNumbers = List.of(25,25,26,27,24,23);

        assertThatThrownBy(() -> LottoValidator.validateDuplicatedNumber(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXIST_DUPLICATED_NUMBER);
    }
}