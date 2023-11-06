package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoPurchaseAmount;
import lotto.mock.FakePrinter;
import lotto.mock.FakeReader;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("1000원 단위로 로또 구입 금액을 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "100000"})
    void inputLottoPurchaseAmount(String input) {
        // given
        Reader reader = new FakeReader(input);
        Printer printer = new FakePrinter();

        InputView inputView = new InputView(reader, printer);

        // when
        LottoPurchaseAmount result = inputView.inputLottoPurchaseAmount();

        // then
        assertThat(result.getAmount()).isEqualTo(input);
    }

}