package lotto;

import static lotto.settings.ErrorMessage.INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
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
    @DisplayName("로또 번호가 모두 올바르게 입력된 경우 예외없이 저장된다.")
    @Test
    void createCorrectLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 35, 5, 6, 7));
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByUngerRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 46, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    @DisplayName("산 로또와 당첨 번호가 몇개 맞는지 세서 반환해준다.")
    @Test
    void compareLottoNumbers() {
        Lotto winningLotto = new Lotto(List.of(1, 4, 5, 7, 17, 26));
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));

        assertThat(winningLotto.matching(buyLotto)).isEqualTo(5);
    }

    @DisplayName("5개를 맟추고 보너스 점수를 맞추면 2등을 반환해준다.")
    @Test
    void findRankTwo() {
        Lotto winningLotto = new Lotto(List.of(1, 4, 5, 7, 17, 26));
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));
        int correctNumber = 5;
        int bonusNumer = 6;
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(2);
    }

    @DisplayName("5개를 맟추고 보너스 점수를 못맞추면 3등을 반환해준다.")
    @Test
    void findRankThree() {
        Lotto winningLotto = new Lotto(List.of(1, 4, 5, 7, 17, 26));
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));
        int correctNumber = 5;
        int bonusNumer = 16;
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(3);
    }

    @DisplayName("산 로또의 번호를 오름차순으로 ','로 구분하여 문자열로 변경해줍니다.")
    @Test
    void listToAscendingString() {
        Lotto buyLotto = new Lotto(List.of(1, 4, 3, 6, 7, 2));
        String stringBuyLotto = buyLotto.listToAscendingString();
        assertThat(stringBuyLotto).isEqualTo("1, 2, 3, 4, 6, 7");
    }
}