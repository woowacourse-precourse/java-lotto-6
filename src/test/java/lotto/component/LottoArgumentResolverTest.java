package lotto.component;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import lotto.dto.LottoArgument;
import lotto.service.LottoMessagePrinter;
import lotto.view.read.InputView;
import lotto.view.write.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class LottoArgumentResolverTest {

    @Mock
    InputView reader;

    LottoMessagePrinter printer;

    @Spy
    LottoValidator validator;

    LottoArgumentResolver resolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        printer = LottoMessagePrinter.of(new OutputView());
        resolver = LottoArgumentResolver.of(reader, printer, validator);
    }

    @Test
    void 구매_금액_입력이_올바를_때_로또_사이즈를_정확히_읽는다() {
        // Arrange
        when(reader.readLine()).thenReturn("1000");

        // Act
        int result = resolver.readLottoSize();

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @CsvSource({"-1", "0", "999", "abc", "1000a", "1000.0", "1000.1", "1000.9", "1000.10"})
    @ParameterizedTest
    void 구매_금액_입력이_올바르지_않으면_재입력_받는다(String invalidInput) {
        // Arrange
        String validInput = "1000";

        when(reader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        // Act
        int result = resolver.readLottoSize();

        // Assert
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 당첨_번호_입력이_올바를_때_정렬된_당첨_번호를_반환한다() {
        // Arrange
        String inputWinNumbers = "33, 40, 12, 19, 29, 20";
        when(reader.readLine()).thenReturn(inputWinNumbers);
        doNothing().when(validator).verifyWinNumbers(anyString());

        // Act
        List<Integer> result = resolver.readWinNumbers();

        // Assert
        assertThat(result).containsExactly(12, 19, 20, 29, 33, 40);
    }

    @CsvSource({"''", "' '", "1,2,3,4,5,5", "1,2,3,4,5,6,7", "1,2,3,4,5,100", "-1,1,2,3,4,5", "a,b,c,d,e,f"})
    @ParameterizedTest
    void 당첨_번호_입력이_올바르지_않으면_재입력_받는다(String invalidInput) {
        // Arrange
        String validInput = "33, 40, 12, 19, 29, 20";

        when(reader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        // Act
        List<Integer> actual = resolver.readWinNumbers();

        // Assert
        assertThat(actual).containsExactly(12, 19, 20, 29, 33, 40);
    }

    @Test
    void 보너스_번호_입력이_올바를_때_올바른_보너스_번호를_반환한다() {
        // Arrange
        List<Integer> winNumbers = List.of(12, 19, 20, 29, 33, 40);
        when(reader.readLine()).thenReturn("7");

        // Act
        int actual = resolver.readBonusNumber(winNumbers);

        // Assert
        assertThat(actual).isEqualTo(7);
    }

    @CsvSource({"''", "' '", "a", "-1", "100", "12"})
    @ParameterizedTest
    void 보너스_번호_입력이_올바르지_않으면_재입력_받는다(String invalidInput) {
        // Arrange
        List<Integer> winNumbers = List.of(12, 19, 20, 29, 33, 40);
        String validInput = "7";

        when(reader.readLine())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        // Act
        int actual = resolver.readBonusNumber(winNumbers);

        // Assert
        assertThat(actual).isEqualTo(7);
    }

    @Test
    void 모든_입력을_받으면_결과를_반환한다() {
        //Arrange
        String purchaseAmountInput = "1000";
        String winNumbersInput = "33, 40, 12, 19, 29, 20";
        String bonusNumberInput = "7";

        when(reader.readLine())
                .thenReturn(purchaseAmountInput)
                .thenReturn(winNumbersInput)
                .thenReturn(bonusNumberInput);

        //Act
        LottoArgument argument = resolver.resolve();

        //Assert
        assertThat(argument.getLottos()).hasSize(1);
        assertThat(argument.getWinning())
                .extracting("numbers", "bonusNumber")
                .containsOnly(List.of(12, 19, 20, 29, 33, 40), 7);
    }
}