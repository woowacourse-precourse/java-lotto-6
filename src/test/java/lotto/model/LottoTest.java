package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 매칭되는 갯수 제대로 세는지 확인한다.")
    @Test
    void checkCountMatchLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> eachLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
        int answer = 5;
        assertThat(lotto.countMatchEachLotto(eachLotto)).isEqualTo(answer);
    }

    @DisplayName("보너스 번호 매칭 제대로 확인하는지 확인한다.")
    @Test
    void checkMatchBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 5;
        boolean answer = true;

        assertThat(lotto.checkLottoContainBonus(bonus)).isEqualTo(answer);
    }

}