package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위에 있지 않으면 예외가 발생한다.")
    @Test
    void createNotInRange() {
        assertThatThrownBy(() -> Lotto.makeLotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto 생성 테스트")
    @Test
    void makeLottoTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lottoTest = Lotto.makeLotto(numbers);
        assertThat(numbers).isEqualTo(lottoTest.getLottoNumbers());
    }
    // 아래에 추가 테스트 작성 가능
}