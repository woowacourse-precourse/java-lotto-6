package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
	@DisplayName("로또 구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
	@Test
	void createLottoByNonDivisibleBy1000() {
		assertThatThrownBy(() -> new Lotto(1001, List.of(1, 2, 3, 4, 5, 6), 7))
				.isInstanceOf(IllegalArgumentException.class);
	}
	
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(1000, List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 번호의 범위가 1부터 45 사이에 포함되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNumberNotInOneToFourtyfive() {
    	assertThatThrownBy(() -> new Lotto(1000, List.of(0, 1, 2, 3, 4, 46), 5))
    			.isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(1000, List.of(1, 2, 3, 4, 5, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호의 범위가 1부터 45 사이에 포함되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByBonusNumberNotInOneToFourtyfive() {
    	assertThatThrownBy(() -> new Lotto(1000, List.of(1, 2, 3, 4, 5, 6), 46))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
    	assertThatThrownBy(() -> new Lotto(1000, List.of(1, 2, 3, 4, 5, 6), 6))
    			.isInstanceOf(IllegalArgumentException.class);
    }
}