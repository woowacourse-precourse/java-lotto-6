package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    private static List<Integer> lottoNumbers;

    @BeforeAll
    static void beforeAll() {
        lottoNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
    }

    @DisplayName("보너스 번호가 1보다 작을 경우")
    @Test
    void createBonusNumberByUnderRange () {

        int bonusNumber = 0;

        assertThatThrownBy(() -> new BonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 45보다 큰 경우")
    @Test
    void createBonusNumberByOverRange () {

        int bonusNumber = 46;

        assertThatThrownBy(() -> new BonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우")
    @Test
    void createBonusNumberByDuplicateLottoNumbers () {

        int bonusNumber = 1;

        assertThatThrownBy(() -> new BonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }
}
