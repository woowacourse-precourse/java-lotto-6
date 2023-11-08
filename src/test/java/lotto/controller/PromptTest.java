package lotto.controller;

import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PromptTest {
    private static final String REGEX = ",";
    private static final int NO_LIMIT = -1;
    private final String validMoneyInput = "8000", validLottoInput = "1,2,3,4,5,6", validBonusInput = "7";
    private final int validAmount = 8000, validBonusNumber = 7;
    private final List<Integer> validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private Reader reader;
    private PromptParser promptParser;
    private Message message;
    private Prompt prompt;

    @BeforeEach
    void setUp() {
        reader = mock(Reader.class);
        promptParser = mock(PromptParser.class);
        message = mock(Message.class);

        prompt = new Prompt(reader, promptParser, message);
    }

    @DisplayName("구매 금액 입력")
    @Test
    void promptMoney_성공() {
        when(reader.readLine()).thenReturn(validMoneyInput);
        when(promptParser.integer(validMoneyInput)).thenReturn(validAmount);

        Money money = prompt.promptMoney();

        assertThat(money.getAmount()).isEqualTo(validAmount);
        verify(message, times(1)).promptMoney();
        verify(message, times(1)).newLine();
        verify(reader, times(1)).readLine();
        verify(promptParser, times(1)).integer(validMoneyInput);
    }

    @DisplayName("구매 금액이 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "　", "8000a", "abc", "..."})
    void promptMoney_숫자가아닌입력(String invalidMoneyInput) {
        when(reader.readLine()).thenReturn(invalidMoneyInput).thenReturn(validMoneyInput);
        when(promptParser.integer(invalidMoneyInput.strip())).thenThrow(new NumberFormatException());
        when(promptParser.integer(validMoneyInput)).thenReturn(validAmount);

        Money money = prompt.promptMoney();

        assertThat(money.getAmount()).isEqualTo(validAmount);
        verify(message, times(2)).promptMoney();
        verify(message, times(2)).newLine();
        verify(message, times(1)).invalidMoneyError();
        verify(reader, times(2)).readLine();
        verify(promptParser, times(1)).integer(invalidMoneyInput.strip());
        verify(promptParser, times(1)).integer(validMoneyInput);
    }

    @DisplayName("구매 금액이 1000의 배수가 아니면 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "22,22", "333,333", "4444,4444", "55555,55555"})
    void promptMoney_1000의배수가아닌숫자(String invalidMoneyInput, int invalidAmount) {
        when(reader.readLine()).thenReturn(invalidMoneyInput).thenReturn(validMoneyInput);
        when(promptParser.integer(invalidMoneyInput.strip())).thenReturn(invalidAmount);
        when(promptParser.integer(validMoneyInput)).thenReturn(validAmount);

        Money money = prompt.promptMoney();

        assertThat(money.getAmount()).isEqualTo(validAmount);
        verify(message, times(2)).promptMoney();
        verify(message, times(2)).newLine();
        verify(message, times(1)).invalidMoneyError();
        verify(reader, times(2)).readLine();
        verify(promptParser, times(1)).integer(invalidMoneyInput.strip());
        verify(promptParser, times(1)).integer(validMoneyInput);
    }

    @DisplayName("구매 금액이 음수면 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"-1, -1", "-1111,-1111", "-1000,-1000", "-19000,-19000"})
    void promptMoney_음수(String invalidMoneyInput, int invalidAmount) {
        when(reader.readLine()).thenReturn(invalidMoneyInput).thenReturn(validMoneyInput);
        when(promptParser.integer(invalidMoneyInput.strip())).thenReturn(invalidAmount);
        when(promptParser.integer(validMoneyInput)).thenReturn(validAmount);

        Money money = prompt.promptMoney();

        assertThat(money.getAmount()).isEqualTo(validAmount);
        verify(message, times(2)).promptMoney();
        verify(message, times(2)).newLine();
        verify(message, times(1)).invalidMoneyError();
        verify(reader, times(2)).readLine();
        verify(promptParser, times(1)).integer(invalidMoneyInput.strip());
        verify(promptParser, times(1)).integer(validMoneyInput);
    }

    @DisplayName("로또 번호, 보너스 번호 입력")
    @Test
    void promptWinningLotto_성공() {
        when(reader.readLine()).thenReturn(validLottoInput).thenReturn(validBonusInput);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(1)).promptWinningNumbers();
        verify(message, times(1)).promptBonusNumber();
        verify(message, times(2)).newLine();
        verify(reader, times(2)).readLine();
        verify(promptParser, times(1)).integerList(validLottoInput);
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("로또 번호가 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d,e,f", "a,,c,...,e,f", "1,2,3, ,e,　"})
    void promptWinningLotto_숫자가아닌로또번호(String invalidLottoInput) {
        when(reader.readLine()).thenReturn(invalidLottoInput).thenReturn(validLottoInput).thenReturn(validBonusInput);
        when(promptParser.integerList(invalidLottoInput)).thenThrow(new IllegalArgumentException());
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(2)).promptWinningNumbers();
        verify(message, times(1)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(invalidLottoInput.strip());
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("로또 번호 개수 6개 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7", "1,2,3,4,5"})
    void promptWinningLotto_길이가맞지않는로또번호(String invalidLottoInput) {
        List<Integer> invalidLottoNumbers = parseIntegerList(invalidLottoInput);
        when(reader.readLine()).thenReturn(invalidLottoInput).thenReturn(validLottoInput).thenReturn(validBonusInput);
        when(promptParser.integerList(invalidLottoInput)).thenReturn(invalidLottoNumbers);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(2)).promptWinningNumbers();
        verify(message, times(1)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(invalidLottoInput.strip());
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("로또 번호가 중복되면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,1", "1,2,2,3,4,5", "1,1,1,1,1,1"})
    void promptWinningLotto_중복된로또번호(String invalidLottoInput) {
        List<Integer> invalidLottoNumbers = parseIntegerList(invalidLottoInput);
        when(reader.readLine()).thenReturn(invalidLottoInput).thenReturn(validLottoInput).thenReturn(validBonusInput);
        when(promptParser.integerList(invalidLottoInput)).thenReturn(invalidLottoNumbers);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(2)).promptWinningNumbers();
        verify(message, times(1)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(invalidLottoInput.strip());
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("로또 번호 1부터 45사이가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"46,1,2,3,4,5", "1,2,3,4,5,-1", "46,47,48,49,50,51"})
    void promptWinningLotto_유효하지않은숫자로또번호(String invalidLottoInput) {
        List<Integer> invalidLottoNumbers = parseIntegerList(invalidLottoInput);
        when(reader.readLine()).thenReturn(invalidLottoInput).thenReturn(validLottoInput).thenReturn(validBonusInput);
        when(promptParser.integerList(invalidLottoInput)).thenReturn(invalidLottoNumbers);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(2)).promptWinningNumbers();
        verify(message, times(1)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(invalidLottoInput.strip());
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("보너스 번호가 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "　", "8a", "abc", "..."})
    void promptWinningLotto_숫자가아닌보너스번호(String invalidBonusInput) {
        when(reader.readLine()).thenReturn(validLottoInput).thenReturn(invalidBonusInput).thenReturn(validBonusInput);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(invalidBonusInput)).thenThrow(new IllegalArgumentException());
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(1)).promptWinningNumbers();
        verify(message, times(2)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(invalidBonusInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("보너스 번호 1부터 45사이가 아니면 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"-1,-1", "46,46", "48,48", "-19,-19"})
    void promptWinningLotto_유효하지않은숫자보너스번호(String invalidBonusInput, int invalidBonusNumber) {
        when(reader.readLine()).thenReturn(validLottoInput).thenReturn(invalidBonusInput).thenReturn(validBonusInput);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(invalidBonusInput)).thenReturn(invalidBonusNumber);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(1)).promptWinningNumbers();
        verify(message, times(2)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(invalidBonusInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3", "4,4", "5,5", "6,6"})
    void promptWinningLotto_로또번호와중복되는보너스번호(String invalidBonusInput, int invalidBonusNumber) {
        when(reader.readLine()).thenReturn(validLottoInput).thenReturn(invalidBonusInput).thenReturn(validBonusInput);
        when(promptParser.integerList(validLottoInput)).thenReturn(validLottoNumbers);
        when(promptParser.integer(invalidBonusInput)).thenReturn(invalidBonusNumber);
        when(promptParser.integer(validBonusInput)).thenReturn(validBonusNumber);

        WinningLotto winningLotto = prompt.promptWinningLotto();

        assertThat(winningLotto.getLotto().getNumbers()).isEqualTo(validLottoNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(validBonusNumber);
        verify(message, times(1)).promptWinningNumbers();
        verify(message, times(2)).promptBonusNumber();
        verify(message, times(3)).newLine();
        verify(reader, times(3)).readLine();
        verify(promptParser, times(1)).integerList(validLottoInput.strip());
        verify(promptParser, times(1)).integer(invalidBonusInput.strip());
        verify(promptParser, times(1)).integer(validBonusInput.strip());
    }

    private List<Integer> parseIntegerList(String input) {
        return Arrays.stream(input.split(REGEX, NO_LIMIT))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
    }
}