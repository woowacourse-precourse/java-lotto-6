package lotto;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("유효한 로또 번호를 가진 로또가 정상적으로 생성된다.")
    @Test
    void createLottoWithValidNumbers() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("로또 번호가 전혀 매치되지 않을 때 결과 테스트")
    @Test
    void matchNoNumbers() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoResult result = userLotto.matchUp(winningLotto, 13);
        assertThat(result).isEqualTo(LottoResult.single(0));
    }

    @DisplayName("로또 번호 일부가 매치될 때 결과 테스트")
    @Test
    void matchSomeNumbers() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        LottoResult result = userLotto.matchUp(winningLotto, 13);
        assertThat(result).isEqualTo(LottoResult.single(3));
    }

    @DisplayName("보너스 번호를 포함해 로또 번호가 전부 매치될 때 결과 테스트")
    @Test
    void matchAllNumbersIncludingBonus() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoResult result = userLotto.matchUp(winningLotto, 7);
        assertThat(result).isEqualTo(LottoResult.single(7));
    }
}