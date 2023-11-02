package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("[ERROR] 숫자 6개를 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("[ERROR] 중복 되지 않도록 입력해 주세요.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByBound() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 0, 3, 4, 5, 57)))
                .isInstanceOf(IllegalArgumentException.class);
        System.out.println("[ERROR] 1과 45사이의 숫자만 입력해 주세요.");
    }
}