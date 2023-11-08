package lotto.modelTest;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberTest {
    private WinningNumbers winningNumbers;
    private final String[] testWinningNumberSetting = {"1", "2", "3", "4", "5", "6"};

    @BeforeEach
    void setup() {
        winningNumbers = new WinningNumbers(testWinningNumberSetting);
    }

    @Test
    void inputBonusNumberNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(" ", winningNumbers);
        });
    }

    @Test
    void inputInvalidTypeBonusNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("칠", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("7.", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("seven", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(" 7", winningNumbers);
        });
    }

    @Test
    void inputInvalidRangeOfBonusNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("46", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("0", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("-1", winningNumbers);
        });
    }

    @Test
    void inputDuplicateWithWinningNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("1", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("2", winningNumbers);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("3", winningNumbers);
        });
    }


}