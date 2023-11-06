package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.LottoPurchaseAmount;
import lotto.mock.FakePrinter;
import lotto.mock.FakeReader;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private Printer printer;

    @BeforeEach
    void setUp() {
        this.printer = new FakePrinter();
    }

    @DisplayName("1000원 단위로 로또 구입 금액을 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "100000"})
    void inputLottoPurchaseAmount(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = new InputView(reader, printer);

        // when
        LottoPurchaseAmount result = inputView.inputLottoPurchaseAmount();

        // then
        assertThat(result.getAmount()).isEqualTo(input);
    }

    @DisplayName("로또 구입 금액이 양수가 아닐 시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1000"})
    void inputLottoPurchaseAmount_exception1(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = new InputView(reader, printer);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::inputLottoPurchaseAmount);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "999", "1001", "333333"})
    void inputLottoPurchaseAmount_exception2(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = new InputView(reader, printer);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::inputLottoPurchaseAmount);
    }

}