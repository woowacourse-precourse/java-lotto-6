package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 출력값 생성")
    @Test
    void getNumberString() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).getLottoCreatedResult().equals("[1, 2, 3, 4, 5, 6]"));
    }

    @DisplayName("로또 객체간의 매치되는 숫자 개수 반환")
    @Test
    void matchesNumberList() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).matchesNumberList(new Lotto(List.of(1, 3, 2, 6, 5, 4))) == 6);
    }

    @DisplayName("특정 숫자가 해당 로또 객체에 들어있는지 반환")
    @Test
    void matchsSingleNumber() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).matchesSingleNumber(6) == 1);
    }

    // 아래에 추가 테스트 작성 가능
}