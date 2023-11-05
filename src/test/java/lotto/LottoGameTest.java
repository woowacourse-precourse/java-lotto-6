package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGameTest {

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
    @DisplayName("getPurchaseAmount 함수에서 입력받은 값이 1,000원 단위가 아닐 경우 IllegalArgumentException에러 발생")
    void getPurchaseAmount_함수에서_입력값이_1000원_단위가_아니면_IllegalArgumentException에러_발생() {
        try (MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
            //given
            mock.when(Console::readLine).thenReturn("8300");
            LottoGame lottoGame = new LottoGame();
            //when,then
            assertThrows(IllegalArgumentException.class, lottoGame::getPurchaseAmount);
        }
    }
}