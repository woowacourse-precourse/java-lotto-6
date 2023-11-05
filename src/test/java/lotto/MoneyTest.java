package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
	/*
	 * @DisplayName("금액 미입력 혹은 공백 입력 시 예외가 발생한다.")
	 * 
	 * @Test void createLottoByOverSize() { assertThatThrownBy(() -> new Money("")
	 * .isInstanceOf(IllegalArgumentException.class)); }
	 */

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}