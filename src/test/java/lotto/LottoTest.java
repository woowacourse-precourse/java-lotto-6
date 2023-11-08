package lotto;

import lotto.configs.ComparisonScore;
import lotto.models.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 1~45사이의 정수가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 비교한 점수를 반환한다.")
    @Test
    void createComparisonScore(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        System.out.println(lotto);
        assertThat(lotto.getComparisonScore(
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), 6))
                .isEqualTo(ComparisonScore.FIVE_BONUS);
    }

    @DisplayName("로또 번호를 문자열로 반환한다.")
    @Test
    void printLotto(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}