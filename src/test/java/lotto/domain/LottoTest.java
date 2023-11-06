package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.message.ErrorMessage;

class LottoTest {
		
    @DisplayName("로또 번호의 개수가 LOTTO_SIZE를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_ERROR.getFormattedMessage(Lotto.LOTTO_SIZE));
    }
    
    @DisplayName("로또 번호의 개수가 LOTTO_SIZE라면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation1() {
    	Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    	assertThat(lotto.getSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }
    
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
    
    @DisplayName("로또 번호가 중복되지않으면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation2() {
    	new Lotto(List.of(1, 2, 3, 4, 5, 6));

    }
    
    @DisplayName("로또 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 45, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(
        				ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
        						.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
    }
    
    @DisplayName("로또 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER라면 정상적으로 작동한다.")
    @Test
    void checkNomalOperation3() {
    	new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
    
    @DisplayName("로또 번호의 출력결과를 확인한다.")
    @Test
    void checkPrintNumbers() {
    	Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    	
    	assertThat(lotto.printNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}