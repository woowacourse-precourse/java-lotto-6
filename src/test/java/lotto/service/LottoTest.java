package lotto.service;

import static lotto.constant.ErrorMessage.WINNUMBER_LENGTH;
import static lotto.constant.ErrorMessage.WINNUMBER_NO_DUPLICATE_LENGTH;
import static lotto.constant.ErrorMessage.WINNUMBER_RANGE;
import static lotto.constant.NumberConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.NUMBERS_LENGTH;
import static lotto.constant.NumberConstant.START_LOTTO_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    @ParameterizedTest
    @MethodSource("generateRangeData")
    @DisplayName("당첨 번호 범위 테스트! 1-45 사이")
    void rangeCheckTest(List<Integer> rangeNumbers){
        Assertions.assertThatThrownBy(()-> rangeCheck(rangeNumbers)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(WINNUMBER_RANGE.getMessage());
    }

    static Stream<Arguments> generateRangeData() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3,46,47,48)),
            Arguments.of(Arrays.asList(-1, 0, 1,2,3,4))
        );
    }







    private void rangeCheck(List<Integer> numbers) {
        for (Integer winnerNumber : numbers) {
            if (isNumberNotInRange(winnerNumber)) {
                throw new IllegalArgumentException(WINNUMBER_RANGE.getMessage());
            }
        }
    }

    private boolean isNumberNotInRange(Integer winnerNumber) {
        return winnerNumber < START_LOTTO_NUMBER.getNumber()
            || winnerNumber > LAST_LOTTO_NUMBER.getNumber();
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateLotto = new HashSet<>(numbers);
        List<Integer> numberNonDuplicate = new ArrayList<>(nonDuplicateLotto);
        if (numberNonDuplicate.size() != NUMBERS_LENGTH.getNumber()) {
            throw new IllegalArgumentException(WINNUMBER_NO_DUPLICATE_LENGTH.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH.getNumber()) {
            throw new IllegalArgumentException(WINNUMBER_LENGTH.getMessage());
        }
    }

}