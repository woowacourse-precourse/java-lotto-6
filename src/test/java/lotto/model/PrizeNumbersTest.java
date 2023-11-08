package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeNumbersTest {

    @ParameterizedTest
    @DisplayName("당첨 번호에 중복되는 보너스 번호는 예외가 발생한다.")
    @ValueSource(ints = {1,3,4})
    void validateBonusNumberDuplicationTest(int source) {
        PrizeNumbers prizeNumbers = new PrizeNumbers(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThatThrownBy(() -> prizeNumbers.validateBonusNumberDuplication(source))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}
