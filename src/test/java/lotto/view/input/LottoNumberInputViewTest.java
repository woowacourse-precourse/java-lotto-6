package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberInputViewTest {

    private LottoNumberInputView lottoNumberInputView = new LottoNumberInputView();

    @AfterEach
    void tearDown(){
        Console.close();
    }

    @Test
    @DisplayName("사용자는 로또 당첨번호를 입력할 수 있다.")
    public void requestWinningLotto() {
        //given
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        Lotto lotto = lottoNumberInputView.requestWinningLotto();
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
        assertThatThrownBy(()->lottoNumberInputView.requestWinningLotto())
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
        assertThatThrownBy(()->lottoNumberInputView.requestWinningLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 로또 번호를 입력할 수 있다.")
    public void requestBonusLottoNumber() {
        //given
        String input = "45";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        int bonusLottoNumber = lottoNumberInputView.requestBonusLottoNumber(winningLotto);
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
        assertThatThrownBy(() -> lottoNumberInputView.requestBonusLottoNumber(winningLotto))
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
        assertThatThrownBy(() -> lottoNumberInputView.requestBonusLottoNumber(winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_MATCH.getMessage());
    }

}