package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.constant.LottoNumberConstant;
import lotto.mock.FakePrinter;
import lotto.mock.FakeReader;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        InputView inputView = InputView.of(reader, printer);

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
        InputView inputView = InputView.of(reader, printer);

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
        InputView inputView = InputView.of(reader, printer);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::inputLottoPurchaseAmount);
    }

    @DisplayName("당첨 번호 입력 시 번호가 6개가 아니면 예외를 발생한다.")
    @Test
    void inputWinningNumbers() {
        // given
        Reader reader = new FakeReader("1,2,3,4,5,6,7");
        InputView view = InputView.of(reader, printer);

        // when
        assertThatThrownBy(view::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 %d개 입력해야합니다.".formatted(Lotto.DEFAULT_NUMBER_SIZE));
    }

    @DisplayName("당첨 번호 입력 시 번호가 1~45 사이가 아니면 예외를 발생한다.")
    @Test
    void inputWinningNumbersRange() {
        // given
        Reader reader = new FakeReader("-1,2,3,4,5,46");
        InputView view = InputView.of(reader, printer);

        // when
        assertThatThrownBy(view::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
                        LottoNumberConstant.MIN_LOTTO_NUMBER,
                        LottoNumberConstant.MAX_LOTTO_NUMBER
                ));
    }

    @DisplayName("당첨 번호 입력 시 번호가 중복되면 예외를 발생한다.")
    @Test
    void inputWinningNumbers_duplicated() {
        // given
        Reader reader = new FakeReader("1,1,3,4,5,45");
        InputView view = InputView.of(reader, printer);

        // when
        assertThatThrownBy(view::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 중복될 수 없습니다.");
    }

}