package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.constants.Constants;
import util.exception.DuplicateException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static provider.TestProvider.createTestPurchaseLottos;
import static provider.TestProvider.createTestWinningNumbers;
import static util.message.ExceptionMessage.UNIT_MESSAGE;

public class WinningNumbersTest {

    @DisplayName("당첨번호를 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @Test
    void givenNormalWinningNumbers_thenSuccess() {
        assertThat(WinningNumbers.create(new ArrayList<>(List.of(1,2,3,4,5,6))))
                .isInstanceOf(WinningNumbers.class);

        assertThatCode(() -> WinningNumbers.create(List.of(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨번호를 중복으로 입력한 경우 예외가 발생하지 않는다.")
    @Test
    void givenDuplicateWinningNumbers_thenFail() {
        assertThatThrownBy(() -> WinningNumbers.create(new ArrayList<>(List.of(1,2,3,4,5,5))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


