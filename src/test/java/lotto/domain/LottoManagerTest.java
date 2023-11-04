package lotto.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import lotto.ui.ConsoleInput;
import lotto.ui.ConsoleOutput;
import lotto.ui.Input;
import lotto.ui.Output;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoManagerTest {
    @ParameterizedTest
    @CsvSource(value = {"1000", "5000", "1000000", "5000000"})
    @DisplayName("금액에 맞는 개수의 로또 구입")
    void 금액에_맞는_개수의_로또_구입(int userInput) {
        //given
        Input input = mock(ConsoleInput.class);
        Output output = mock(ConsoleOutput.class);
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);

        when(input.getPrice()).thenReturn(userInput);
        doNothing().when(output).printLottoPriceRequest();
        when(lottoGenerator.generateLottos(anyInt())).thenReturn(new ArrayList<>());

        LottoManager lottoManager = new LottoManager(input, output, lottoGenerator, new WinningNumbersManager());

        //when
        lottoManager.buyLotto();

        //then
        verify(lottoGenerator).generateLottos(userInput / 1000);
    }
}