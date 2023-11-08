package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import lotto.controller.InputController;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputControllerTest {
    @BeforeEach
    public void setUp() {

    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "a", "", "  "})
    public void inputMoneyTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() ->
                assertThatThrownBy(InputController::inputMoney)
                        .isInstanceOf(NoSuchElementException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "a,b,c", " d", ", ,"})
    public void inputWinningNumberTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            assertThatThrownBy(InputController::inputWinningNumber)
                    .isInstanceOf(NoSuchElementException.class);
        });
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    public void inputBonusNumberTest(Lotto lotto, int input) {
        String inputString = String.valueOf(input);
        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputController.inputBonusNumber(lotto))
                    .isInstanceOf(NoSuchElementException.class); // 예외 타입을 적절히 수정
        });
    }

    private static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
                Arguments.of(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 1
                )
        );
    }
}
