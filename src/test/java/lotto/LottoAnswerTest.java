package lotto;

import consts.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoAnswerTest {
    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호가 일치하는 경우")
    void 로또_당첨_번호와_보너스_번호가_일치하는_경우() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호가 6개가 아닌 경우")
    void 로또_당첨_번호가_6개가_아닌_경우() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호가 1 ~ 45 사이가 아닌 경우")
    void 로또_당첨_번호가_1_45_사이가_아닌_경우() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(0, 2, 3, 4, 5, 30), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되는 경우")
    void 당첨_번호와_보너스_번호가_중복되는_경우() {
        assertThatThrownBy(() -> new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @TestFactory
    @DisplayName("당첨 번호와 로또+보너스번호 비교")
    Collection<DynamicTest> 당첨번호와_로또번호_비교하여_순위내기() {
        LottoAnswer lottoAnswer = new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7);
        return List.of(
                DynamicTest.dynamicTest("1등", () -> {
                    assertThat(lottoAnswer.compareAndReturnRank(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(Rank.FIRST);
                }),
                DynamicTest.dynamicTest("2등", () -> {
                    assertThat(lottoAnswer.compareAndReturnRank(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(Rank.SECOND);
                }),
                DynamicTest.dynamicTest("3등", () -> {
                    assertThat(lottoAnswer.compareAndReturnRank(new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(Rank.THIRD);
                }),
                DynamicTest.dynamicTest("4등", () -> {
                    assertThat(lottoAnswer.compareAndReturnRank(new Lotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(Rank.FOURTH);
                }),
                DynamicTest.dynamicTest("5등", () -> {
                    assertThat(lottoAnswer.compareAndReturnRank(new Lotto(List.of(1, 2, 3, 8, 9, 10)))).isEqualTo(Rank.FIFTH);
                })
        );
    }
}
