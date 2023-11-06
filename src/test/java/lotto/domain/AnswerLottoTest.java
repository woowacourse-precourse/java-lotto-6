package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.message.ErrorMessage;

public class AnswerLottoTest {
	
	@DisplayName("당첨로또 번호의 개수가 LOTTO_SIZE를 넘어가면 예외가 발생한다.")
    @Test
    void createAnswerLottoNumbersByOverSize() {
        assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_ERROR.getFormattedMessage(Lotto.LOTTO_SIZE));
    }
    
    @DisplayName("당첨로또 번호의 개수가 LOTTO_SIZE라면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation1() {
    	AnswerLotto answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 8);
    	assertThat(answerLotto.getAnswerLottoNumbersSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }
    
    @DisplayName("당첨로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createAnswerLottoNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
    
    @DisplayName("당첨로또 번호가 중복되지않으면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation2() {
    	new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);

    }
    
    @DisplayName("당첨로또 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
    @Test
    void createAnswerLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new AnswerLotto(List.of(0, 45, 3, 4, 6, 5), 7))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(
        				ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
        						.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
    }
    
    @DisplayName("당첨로또 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER라면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation3() {
    	new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }
    
	@DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createAnswerLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }
	
	@DisplayName("보너스 번호와 로또 번호가 중복이 아닐 경우 정상적으로 작동한다.")
    @Test
    void checkNomalOperation4() {
		new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 8);
    }
	
	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
    @Test
    void createAnswerLottoByBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 47))
		        .isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(
						ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
								.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
    }
	
	@DisplayName("보너스 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER라면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation5() {
		new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 8);
    }
}
