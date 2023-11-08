package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparerTest {

    @DisplayName("compareLottos 메소드 : 로또 두 개를 비교 결과 테스트")
    @Test
    void compareLottos_resultTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        assertThat(Comparer.compareLottos(lotto1, lotto2)).isEqualTo(3);
    }

    @DisplayName("containsBonus 메소드 : 보너스 번호 유무 확인 테스트")
    @Test
    void containsBonus_resultTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber = 1;
        Winning winning = new Winning(winningNumbers, bonusNumber);
        assertThat((Comparer.containsBonus(lotto, winning))).isTrue();
    }

}