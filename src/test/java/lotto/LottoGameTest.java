package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    @DisplayName("getPurchaseAmount 함수에서 정상 값을 입력한 경우 그대로 출력")
    void getPurchaseAmount_함수에서_정상값_입력한_경우_그대로_출력() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("9000");
            LottoGame lottoGame = new LottoGame();
            //when
            int result = lottoGame.getPurchaseAmount();
            //then
            assertThat(result).isEqualTo(9000);
        }
    }

    @Test
    @DisplayName("validateAmount 함수에서 입력받은 값이 1,000원 단위가 아닐 경우 IllegalArgumentException에러 발생")
    void validateAmount_함수에서_입력값이_1000원_단위가_아니면_IllegalArgumentException에러_발생() {
        //given
        LottoGame lottoGame = new LottoGame();

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateAmount("1200");
        });
    }

    @Test
    @DisplayName("inputWinningNumbers 함수에서 당첨 번호를 조건에 맞게 입력한 경우 그대로 출력")
    void inputWinningNumbers_함수에서_당첨번호_조건에_맞에_입력하면_그대로_출력() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("1,2,3,4,5,6");
            LottoGame lottoGame = new LottoGame();
            //when
            List<Integer> result = lottoGame.inputWinningNumbers();
            //then
            assertThat(result).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        }
    }

    @Test
    @DisplayName("validateWinningNumbers 함수에서 당첨 번호를 5개 입력받은 경우 IllegalArgumentException에러 발생")
    void validateWinningNumbers_함수에서_당첨번호를_5개_입력받은_경우_IllegalArgumentException에러_발생() {
        //given
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateWinningNumbers(winningNumbers);
        });
    }

    @Test
    @DisplayName("validateWinningNumbers 함수에서 당첨 번호를 7개 입력받은 경우 IllegalArgumentException에러 발생")
    void validateWinningNumbers_함수에서_당첨번호를_7개_입력받은_경우_IllegalArgumentException에러_발생() {
        //given
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateWinningNumbers(winningNumbers);
        });
    }

    @Test
    @DisplayName("validateWinningNumbers 함수에서 당첨 번호를 1~45 사이의 숫자를 입력하지 않은 경우 IllegalArgumentException에러 발생")
    void validateWinningNumbers_함수에서_당첨번호를_1에서_45사이의_숫자를_입력하지_않은_경우_IllegalArgumentException에러_발생() {
        //given
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumbers = List.of(1, 2, 67, 4, 5, 6, 7);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateWinningNumbers(winningNumbers);
        });
    }

    @Test
    @DisplayName("validateWinningNumbers 함수에서 당첨 번호에 중복된 숫자 입력할 경우 IllegalArgumentException에러 발생")
    void validateWinningNumbers_함수에서_당첨번호에_중복된_숫자를_입력할_경우_IllegalArgumentException에러_발생() {
        //given
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumbers = List.of(1, 2, 2, 3, 4, 5, 6, 7);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateWinningNumbers(winningNumbers);
        });
    }

    @Test
    @DisplayName("validateBonusNumber 함수에서 보너스 번호를 1~45 사이의 숫자를 입력하지 않은 경우 IllegalArgumentException에러 발생")
    void validateBonusNumber_함수에서_보너스번호를_1에서_45사이의_숫자를_입력하지_않은_경우_IllegalArgumentException에러_발생() {
        // given
        LottoGame lottoGame = new LottoGame();

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoGame.validateBonusNumber(99);
        });
    }
}