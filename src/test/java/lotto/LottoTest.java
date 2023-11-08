package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.lotto.model.Lotto;

class LottoTest {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_RESULT = "[1, 2, 3, 4, 5, 6]";
    private Lotto lotto;

    @BeforeEach
    void setUp(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        lotto = new Lotto(numbers);
    }

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
    @DisplayName("로또 출력을 위한 문자열 반환")
    @Test
    void 로또_문자열_반환(){
        assertThat(lotto.toString()).isEqualTo(LOTTO_RESULT);
    }

    @DisplayName("로또 사이즈 반환")
    @Test
    void 로또_사이즈_반환(){
        assertThat(lotto.length()).isEqualTo(LOTTO_SIZE);
    }

}
