package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;
import lotto.Util.LottoComparator;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 숫자가 아닌 값이 있다면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> new LottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 초과한 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new LottoNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 비교 테스트")
    @Test
    void compareLottoTest() {
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        LottoComparator lottoComparator = new LottoComparator(winLotto);
        assertThat(lottoComparator.compareLotto(userLotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 비교 테스트")
    @Test
    void compareBonusNumberTest() {
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber("7");
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        LottoComparator lottoComparator = new LottoComparator(winLotto);
        assertThat(lottoComparator.compareBonusNumber(userLotto, bonusNumber)).isEqualTo(true);
    }
}