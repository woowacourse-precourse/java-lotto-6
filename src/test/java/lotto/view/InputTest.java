package lotto.view;

import static lotto.Option.ErrorMessage.NOT_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    @DisplayName("입력을 받고 숫자로 변환하는지 확인한다.")
    void inputAndConvertInt() {
        assertThat(MockInput.money("8000")).isEqualTo(8000);
    }

    @Test
    @DisplayName("예외 상황에서 어떤 값을 반환하는지 확인한다.")
    void inputAndCheckOutput() {
        assertThatThrownBy(() -> MockInput.winLottoNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("예외 상황에서 어떤 값을 반환하는지 확인한다")
    void inputAndCheckOutput_2() {
        assertThat(MockInput.winLottoNumbers(",")).isEqualTo(List.of());
    }


    public static class MockInput {
        public static int money(String message) {
            System.out.println("구입금액을 입력해 주세요.");
            return Converter.stringToInt(message);
        }

        public static List<Integer> winLottoNumbers(String message) {
            System.out.println("당첨 번호를 입력해 주세요.");
            return Converter.stringToListInteger(message);
        }

        public static int bonusNumber(String message) {
            System.out.println("보너스 번호를 입력해 주세요.");
            return Converter.stringToInt(message);
        }
    }
}
