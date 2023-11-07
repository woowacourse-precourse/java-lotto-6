package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BonusNumberTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 1~45 사이 수가 아니면 null이 반환된다.")
    @ParameterizedTest
    @CsvSource({"0", "-1", "46"})
    void getNullByNotBetweenStartAndEndInclusive(int bonusNumber) {
        BonusNumber actual = BonusNumber.of(bonusNumber, winningNumbers);
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 null이 반환된다.")
    @ParameterizedTest
    @CsvSource({"1", "5", "6"})
    void getNullByDuplicateNumber(int bonusNumber) {
        BonusNumber actual = BonusNumber.of(bonusNumber, winningNumbers);
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("보너스 번호가 1~45 사이 수이고, 당첨 번호와 중복되지 않으면 해당 번호를 가지는 BonusNumber가 생성된다.")
    @ParameterizedTest
    @CsvSource({"7", "45"})
    void getBonusNumberByInputBonusNumber(int inputBonusNumber) {
        BonusNumber bonusNumber = BonusNumber.of(inputBonusNumber, winningNumbers);
        int actual = bonusNumber.getBonusNumber();
        assertThat(actual).isEqualTo(inputBonusNumber);
    }

}
