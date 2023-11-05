package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameInputViewTestView {

    private LottoGameInputViewView lottoGameInputView = new LottoGameInputViewView();

    private OutputStream captor;

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private String output() {
        return captor.toString();
    }

    @Test
    @DisplayName("사용자에게 금액을 물어보는 메시지가 출력된다.")
    public void displayRequestLottoPurchaseAmount() {
        // given
        init();
        String input = "8000";
        String result = "구입할 Lotto 금액을 입력해 주세요.\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        lottoGameInputView.requestLottoPurchaseAmount();
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("사용자에게 구입할 로또 금액을 입력받을 수 있다.")
    public void requestLottoPurchaseAmount() {
        // given
        String input = "98000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        long amount = lottoGameInputView.requestLottoPurchaseAmount();
        // then
        assertThat(amount).isEqualTo(98000L);
    }

    @ParameterizedTest(name = "{index}: 숫자가 아닌 입력으로 {0}이 들어오면 예외가 발생한다.")
    @DisplayName("숫자가 아닌 다른 입력이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"asda", "안녕하세요", "中國語", "ひらがな"})
    public void notNumberExceptionTest(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameInputView.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"0", "-1000", "-1500"})
    public void positiveNumberExceptionTest(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameInputView.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
    }

    @Test
    @DisplayName("당첨 로또를 물어보는 메시지를 출력할 수 있다.")
    public void displayRequestWinningLotto() {
        // given
        init();
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = "당첨 번호를 입력해 주세요.\n\n";
        // when
        lottoGameInputView.requestWinningLotto();
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("사용자는 로또 당첨번호를 입력할 수 있다.")
    public void requestWinningLotto() {
        //given
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        Lotto lotto = lottoGameInputView.requestWinningLotto();
        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호를 6개입력하지 않으면 예외가 발생한다.")
    public void numberCountException() {
        //given
        String input = "1,2,3,4,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameInputView.requestWinningLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 1~45에 숫자가 아니면 예외가 발생한다.")
    public void numberRangeException() {
        //given
        String input = "1,2,46,3,4,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoGameInputView.requestWinningLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호를 물어보는 메시지를 출력할 수 있다.")
    public void displayRequestBonusLottoNumber() {
        // given
        init();
        String input = "45";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String result = "보너스 번호를 입력해 주세요.\n\n";
        // when
        lottoGameInputView.requestBonusLottoNumber(winningLotto);
        // then
        assertThat(result).isEqualTo(output());
    }

    @Test
    @DisplayName("보너스 로또 번호를 입력할 수 있다.")
    public void requestBonusLottoNumber() {
        //given
        String input = "45";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        int bonusLottoNumber = lottoGameInputView.requestBonusLottoNumber(winningLotto);
        // then
        assertThat(bonusLottoNumber).isBetween(1, 45);
        assertThat(bonusLottoNumber).isEqualTo(45);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 사이에 숫자가 아니면 예외가 발생한다.")
    public void bonusNumberRangeException() {
        //given
        String input = "0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 45, 5, 6));
        // when //then
        assertThatThrownBy(() -> lottoGameInputView.requestBonusLottoNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 보너스 번호가 포함되면 예외가 발생한다.")
    public void containsNumberException() {
        //given
        String input = "45";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 45, 5, 6));
        // when //then
        assertThatThrownBy(() -> lottoGameInputView.requestBonusLottoNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_MATCH.getMessage());
    }
}
