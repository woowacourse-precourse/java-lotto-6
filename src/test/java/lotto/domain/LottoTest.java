package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.ErrorMessage;

class LottoTest {
		
    @DisplayName("로또 번호의 개수가 LOTTO_SIZE를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_ERROR.getForMatMessage(Lotto.LOTTO_SIZE));
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
    }
    
    @DisplayName("로또 번호의 범위가 MIN_NUMBER ~ MAX_NUMBER가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성	
        assertThatThrownBy(() -> new Lotto(List.of(0, 45, 3, 4, 6, 5)))
                .isInstanceOf(IllegalArgumentException.class)
        		.hasMessageContaining(
        				ErrorMessage.LOTTO_NUMBER_RANGE_ERROR
        						.getForMatMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
    }

    // 아래에 추가 테스트 작성 가능
}