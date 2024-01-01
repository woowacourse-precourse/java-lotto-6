package lotto.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {

    @ValueSource(ints = {-1, 46})
    @ParameterizedTest
    void validateBonusNumberRangeTest(int bonusNumber) {

        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDistinctBonusNumberTest() {
        
        int bonusNumber = 6;
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
