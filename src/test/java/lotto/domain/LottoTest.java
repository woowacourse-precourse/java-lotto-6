package lotto.domain;

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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_테스트_4등() {
        List<Integer> answerLottoNumber = List.of(1, 3, 5, 14, 4, 45);
        int bonusNumber = 43;
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 22, 45));
        assertThat(lotto.getCorrectCount(answerLottoNumber, bonusNumber)).isEqualTo(4);
    }

    @DisplayName("로또 당첨 테스트_5등")
    @Test
    void 로또_당첨_테스트_5등() {
        List<Integer> answerLottoNumber = List.of(1, 2, 5, 14, 4, 45);
        int bonusNumber = 43;
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 22, 45));
        assertThat(lotto.getCorrectCount(answerLottoNumber, bonusNumber)).isEqualTo(3);
    }

    @DisplayName("로또 당첨 테스트_낙")
    @Test
    void 로또_당첨_테스트_낙() {
        List<Integer> answerLottoNumber = List.of(39, 2, 5, 14, 4, 45);
        int bonusNumber = 43;
        Lotto lotto = new Lotto(List.of(1, 3, 5, 6, 22, 45));
        assertThat(lotto.getCorrectCount(answerLottoNumber, bonusNumber)).isEqualTo(2);
    }
}