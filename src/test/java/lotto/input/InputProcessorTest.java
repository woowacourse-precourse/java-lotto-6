package lotto.input;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class InputProcessorTest {

    private static InputProcessor inputProcessor;
    private static InputReader inputReader;

    @BeforeAll
    static void setup() {
        inputReader = Mockito.mock(InputReader.class);
        inputProcessor = new InputProcessor(inputReader);
    }

    @DisplayName("구입 금액 입력 기능 테스트")
    @Nested
    class testGetUserPurchaseMoney {
        @DisplayName("정수 형태가 아닌 경우 IllegalArgumentException을 발생시킨다.")
        @Test
        void testInvalidInput() {
            //given
            String input = "123ew";
            when(inputReader.read()).thenReturn(input);

            //when
            //then
            assertThatThrownBy(() -> inputProcessor.getUserPurchaseMoney())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정수 형태의 입력을 int로 반환한다.")
        @Test
        void testValidInput() {
            //given
            String input = "123";
            when(inputReader.read()).thenReturn(input);

            //when
            int result = inputProcessor.getUserPurchaseMoney();

            //then
            assertThat(result).isEqualTo(123);
        }
    }

    @DisplayName("당첨 번호 입력 기능 테스트")
    @Nested
    class testGetWinningNumbers {
        @DisplayName("원소가 정수 형태가 아닌 경우 IllegalArgumentException을 발생시킨다.")
        @Test
        void testInvalidInput() {
            //given
            String input = "1,2,3,4,a";
            when(inputReader.read()).thenReturn(input);

            //when
            //then
            assertThatThrownBy(() -> inputProcessor.getWinningNumbers())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName(",로 구분된 정수 입력을 정수 리스트로 반환한다.")
        @Test
        void testValidInput() {
            //given
            String input = "1,2,3,4,5";
            when(inputReader.read()).thenReturn(input);

            //when
            List<Integer> result = inputProcessor.getWinningNumbers();

            //then
            assertThat(result)
                    .contains(1)
                    .contains(2)
                    .contains(3)
                    .contains(4)
                    .contains(5);
        }
    }

    @DisplayName("보너스 번호 입력 기능 테스트")
    @Nested
    class testGetBonusNumber {
        @DisplayName("정수 형태가 아닌 경우 IllegalArgumentException을 발생시킨다.")
        @Test
        void testInvalidInput() {
            //given
            String input = "123ew";
            when(inputReader.read()).thenReturn(input);

            //when
            //then
            assertThatThrownBy(() -> inputProcessor.getBonusNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정수 형태의 입력을 int로 반환한다.")
        @Test
        void testValidInput() {
            //given
            String input = "123";
            when(inputReader.read()).thenReturn(input);

            //when
            int result = inputProcessor.getBonusNumber();

            //then
            assertThat(result).isEqualTo(123);
        }
    }
}