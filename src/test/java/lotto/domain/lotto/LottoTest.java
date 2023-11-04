package lotto.domain.lotto;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
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

    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("번호가 중복되면 예외가 발생한다.")
    public void checkForDuplicateNumbers() {
        // given
        List<Integer> numbers = List.of(1, 3, 3, 4, 5, 6);
        // when // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨된 로또와 비교해서 로또의 순위를 얻을 수 있다.")
    public void determineLottoRank() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int bonus = 6;
        // when
        LottoRank lottoRank = lotto.determineLottoRank(winningLotto, bonus);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨된 로또와 비교한 개수가 5개인 경우 보너스 번호를 통해서 순위가 결정된다")
    @TestFactory
    Collection<DynamicTest> determineLottoRankWithBonus() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        return List.of(
                DynamicTest.dynamicTest("보너스 번호가 포함된 경우 순위는 2등이다.", () -> {
                    //given
                    int bonus = 9;
                    //when
                    LottoRank lottoRank = lotto.determineLottoRank(winningLotto, bonus);
                    // then
                    assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
                }),
                DynamicTest.dynamicTest("보너스 번호가 포함되지 않은 경우 순위는 3등이다.", () -> {
                    //given
                    int notBonus = 45;
                    //when
                    LottoRank lottoRank = lotto.determineLottoRank(winningLotto, notBonus);
                    // then
                    assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
                })
        );
    }
}