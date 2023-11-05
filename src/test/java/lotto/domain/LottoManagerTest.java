package lotto.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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

    @ParameterizedTest
    @CsvSource(value = {"1000", "5000", "100000", "10000000"})
    @DisplayName("로또 구입금액이 정상적인 값일 때")
    void goodCase(int userInput) {
        //given
        Input input = mock(ConsoleInput.class);
        Output output = mock(ConsoleOutput.class);
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);

        when(input.getPrice()).thenReturn(userInput);
        doNothing().when(output).printLottoPriceRequest();
        when(lottoGenerator.generateLottos(anyInt())).thenReturn(new ArrayList<>());

        LottoManager lottoManager = new LottoManager(input, output, lottoGenerator, new WinningNumbersManager());
        lottoManager.buyLotto();

        //then: printError가 호출되지 않는지 확인
        verify(output, never()).printError(anyString());
    }

    @ParameterizedTest
    @CsvSource(value = {"999", "1", "100", "30"})
    @DisplayName("로또 구입금액이 1000원 미만이면 예외")
    void 로또_구입금액이_1000원_미만이면_예외(int userInput) {
        //given
        Input input = mock(ConsoleInput.class);
        Output output = mock(ConsoleOutput.class);
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);

        when(input.getPrice()).thenReturn(userInput, 1000);
        doNothing().when(output).printLottoPriceRequest();
        when(lottoGenerator.generateLottos(anyInt())).thenReturn(new ArrayList<>());

        LottoManager lottoManager = new LottoManager(input, output, lottoGenerator, new WinningNumbersManager());
        lottoManager.buyLotto();

        //then: printError가 호출되는지 확인
        verify(output).printError(anyString());
    }

    @ParameterizedTest
    @CsvSource(value = {"1999", "20001", "1001", "999900"})
    @DisplayName("로또 구입금액이 1000원 단위가 아니면 예외")
    void 로또_구입금액이_1000원_단위가_아니면_예외(int userInput) {
        //given
        Input input = mock(ConsoleInput.class);
        Output output = mock(ConsoleOutput.class);
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);

        when(input.getPrice()).thenReturn(userInput, 1000);
        doNothing().when(output).printLottoPriceRequest();
        when(lottoGenerator.generateLottos(anyInt())).thenReturn(new ArrayList<>());

        LottoManager lottoManager = new LottoManager(input, output, lottoGenerator, new WinningNumbersManager());
        lottoManager.buyLotto();

        //then: printError가 호출되는지 확인
        verify(output).printError(anyString());
    }
}