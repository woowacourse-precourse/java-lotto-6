package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputControllerTest {
    private InputController inputController;

    @BeforeEach
    void init() {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView();
        inputController = new InputController(inputView, inputValidator);
    }

    @DisplayName("사용자 입력(String 타입)을 구입 금액 값(int)으로 변환하는 기능 테스트.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "6000:6000", "110000:110000"}, delimiter = ':')
    void 구입_금액_변환_테스트(String givenBudget, int expected) {
        // when
        int actual = inputController.createBudget(givenBudget);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("사용자 입력(String 타입)을 List<Integer>로 변환하는 기능 테스트.")
    @Test
    void 당첨_번호_변환_테스트() {
        String userInput = "1,2,3,4,5,20";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 20);

        // when
        Lotto createdWinningNumbers = inputController.createWinningNumbers(userInput);
        List<Integer> actual = createdWinningNumbers.getNumbers();

        // then
        assertThat(actual).containsAll(expected);
    }

    @DisplayName("사용자 입력(String 타입)을 보너스 번호 값(int)으로 변환하는 기능 테스트.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "45:45"}, delimiter = ':')
    void 보너스_번호_변환_테스트(String givenBonusNumber, int expected) {
        // when
        int actual = inputController.createBonusNumber(givenBonusNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
