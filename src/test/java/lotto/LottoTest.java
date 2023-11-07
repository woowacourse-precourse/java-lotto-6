package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static lotto.Input.input_winner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String input = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> input_winner())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1보다 작거나 45보다 큰 숫자를 넣으면 예외가 발생한다.")
    @Test
    void Lower1OrBigger45() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        String input = "0,2,3,4,5,46";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> input_winner())
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}