package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.BonusNumber;
import model.Lotto;
import validators.InputException;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("사용자가 입력한 값이 NULL이면 예외가 발생한다.")
    @Test
    void createEmptyValue() {
		assertThatThrownBy(() -> InputException.checkNull(null))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력한 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createNotNumber() {
    	assertThatThrownBy(() -> InputException.checkNumber("문자열"))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("구매금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createWrongAmount() {
    	assertThatThrownBy(() -> InputException.checkRightAmount(2555, 1000))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("입력한 당첨번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createWrongRange() {
    	assertThatThrownBy(() -> new Lotto(List.of(1, 54, 2, 0, 8, 40)))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호와 당첨번호를 비교해서 중복이 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberOverLap() {
    	assertThatThrownBy(() -> InputException.checkBonusNumberOverlap(5, List.of(1,2,3,4,5,6)))
    			.isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력한 문자열 형태의 당첨번호를 List로 변경한다.")
    @Test
    void createChangeWinningNumber() {
    	List<Integer> lotto = Lotto.changeNumberList("1, 2, 3, 4, 5, 6");
    	
    	assertThat(lotto).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("사용자가 입력한 문자열 형태의 보너스 번호를 숫자로 변경한다.")
    @Test
    void createChangeBonusNumber() {
    	int bonusNumber = BonusNumber.changeNumber("7");
    	
    	assertThat(bonusNumber).isEqualTo(7);
    }
}