package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.generator.InputGenerator;
import lotto.validate.Validate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    private Validate validate;

    @BeforeEach
    public void setUp() {
        validate = new Validate();
    }

    @DisplayName("로또 구매 금액을 문자열 입력")
    @Test
    void inputStringLottoMoney() {
        // Given: 입력값 "1000원" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("1000원");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.inputLottoMoney());
    }

    @DisplayName("로또 구매 금액을 음수 입력")
    @Test
    void inputMinusLottoMoney() {
        // Given: 입력값 "-1000" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("-1000");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.inputLottoMoney());
    }

    @DisplayName("로또 구매 금액을 0 입력")
    @Test
    void inputZeroLottoMoney() {
        // Given: 입력값 "0" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("0");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.inputLottoMoney());
    }

    @DisplayName("로또 구매 금액 올바른 값 입력")
    @Test
    void inputLottoMoney() {
        // Given: 입력값 "0" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("8000");

        Input input = new Input(inputGenerator, validate);
        int expected = 8000;

        // When & THen
        assertEquals(expected, input.inputLottoMoney());
    }

    @DisplayName("로또 당첨 번호에 빈 값 입력")
    @Test
    void inputEmptyWinningNumber() {
        // Given: 입력값 "0" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn(",,,,,");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.inputWinningNumber());
    }

    @DisplayName("범위를 벗어난 로또 당첨 번호 입력")
    @Test
    void inputOverRangeWinningNumber() {
        // Given: 입력값 "1,2,3,4,5,50" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("1,2,3,4,5,50");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.inputWinningNumber());
    }

    @DisplayName("올바른 로또 당첨 번호 입력")
    @Test
    void inputWinningNumber() {
        // Given: 입력값 "1,2,3,4,5,6" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("1,2,3,4,5,6");

        Input input = new Input(inputGenerator, validate);

        // When
        List<Integer> winningNumbers = input.inputWinningNumber();

        // THen
        assertThat(winningNumbers).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("범위를 벗어난 보너스 번호 입력")
    @Test
    void overRangeBonusNumber() {
        // Given: 입력값 "666" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("666");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.bonusNumber());
    }

    @DisplayName("음의 보너스 번호 입력")
    @Test
    void minusBonusNumber() {
        // Given: 입력값 "-7" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("-7");

        Input input = new Input(inputGenerator, validate);

        // When & THen
        assertThrows(IllegalArgumentException.class, () -> input.bonusNumber());
    }

    @DisplayName("올바른 보너스 번호 입력")
    @Test
    void bonusNumber() {
        // Given: 입력값 "-7" 설정
        InputGenerator inputGenerator = mock(InputGenerator.class);
        when(inputGenerator.readLine()).thenReturn("7");

        Input input = new Input(inputGenerator, validate);
        int expected = 7;

        // When & THen
        assertEquals(expected, input.bonusNumber());
    }
}