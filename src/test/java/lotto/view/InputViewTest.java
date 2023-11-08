package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NonNumberException;
import lotto.exception.lotto.LottoFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class InputViewTest {

    @DisplayName("로또 입력은 [1,2,3,4,5,6]와 같은 6개의 숫자를 쉼표(,)로 구분해서 입력한다.")
    @Test
    void validateLottoFormatTest() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("1, 2, 3, 4, 5, a");

            assertThatThrownBy(InputView::inputWinningLottoNumbers)
                    .isInstanceOf(LottoFormatException.class);
        }
    }

    @DisplayName("보너스 번호는 숫자만 입력할 수 있다.")
    @Test
    void validateBonusNumberTest() {
        try (MockedStatic<Console> mockedConsole = Mockito.mockStatic(Console.class)) {
            mockedConsole.when(Console::readLine).thenReturn("a");

            assertThatThrownBy(InputView::inputBonusLottoNumber)
                    .isInstanceOf(NonNumberException.class);
        }
    }
}