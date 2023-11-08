package lotto;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 매칭을 통해 순위를 올바르게 리턴하는지 검증한다")
    @Test
    void matchingLotto() {

        Lotto winningLotto = new Lotto(List.of(22,23,24,25,26,27));
        int bonusNumber = 10;

        Lotto lotto1 = new Lotto(List.of(22,23,24,25,26,27));
        Lotto lotto2 = new Lotto(List.of(22,23,24,25,26,10));
        Lotto lotto3 = new Lotto(List.of(22,23,24,25,26,28));

        LottoRank rank1 = lotto1.matching(winningLotto, bonusNumber);
        LottoRank rank2 = lotto2.matching(winningLotto, bonusNumber);
        LottoRank rank3 = lotto3.matching(winningLotto, bonusNumber);

        System.out.println(rank2);

        assertThat(rank1).isEqualTo(LottoRank.FIRST);
        assertThat(rank2).isEqualTo(LottoRank.SECOND);
        assertThat(rank3).isEqualTo(LottoRank.THIRD);
    }
}