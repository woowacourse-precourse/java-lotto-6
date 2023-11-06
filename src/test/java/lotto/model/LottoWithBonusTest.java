package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWithBonusTest {
    @DisplayName("중복 보너스 번호")
    @Test
    void duplicatedBonusNumber() {
        Lotto lotto = LottoGenerator.generateAnswerLotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 4;

        assertThatThrownBy(() -> LottoGenerator.generateLottoWithBonus(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호가 중복되었습니다.");
    }

    @DisplayName("보너스 번호 범위")
    @Test
    void rangeBonusNumber() {
        Lotto lotto = LottoGenerator.generateAnswerLotto(List.of(40, 41, 42, 43, 44, 45));
        Integer bonus = 0;

        assertThatThrownBy(() -> LottoGenerator.generateLottoWithBonus(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}