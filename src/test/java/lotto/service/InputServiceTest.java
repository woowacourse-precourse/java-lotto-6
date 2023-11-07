package lotto.service;

import lotto.validation.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest extends IOTest {

    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();
    OutputView outputView = new OutputView();

    InputService inputService = new InputService(inputView, inputValidation, outputView);

    @Test
    void readPurchasingAmountTest() {
        //given
        systemIn("8000");

        //when
        int result = inputService.readPurchasingAmount();

        //then
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    void readWinningNumbersTest() {
        //given
        systemIn("1,13,28,33,38,42");
        List<Integer> winningNumber = Arrays.asList(1, 13, 28, 33, 38, 42);

        //when
        List<Integer> result = inputService.readWinningNumbers();

        //then
        Assertions.assertThat(result).isEqualTo(winningNumber);
    }

    @Test
    void readBonusNumberTest() {
        //given
        systemIn("3");
        List<Integer> winningNumber = Arrays.asList(1, 13, 28, 30, 38, 42);

        //when
        int result = inputService.readBonusNumber(winningNumber);

        //then
        Assertions.assertThat(result).isEqualTo(3);
    }
}