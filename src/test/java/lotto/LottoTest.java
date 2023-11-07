package lotto;

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

    @DisplayName("로또 번호에 특정 숫자가 있다면 true 를 반환한다.")
    @Test
    void isNumberExistedByNumberIsInLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 4;
        //when
        assertThat(lotto.isNumberExisted(bonusNumber))
                .isTrue();
    }

    @DisplayName("로또 번호에 특정 숫자가 있다면 false 를 반환한다.")
    @Test
    void isNumberExistedByNumberIsNotInLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        //when then
        assertThat(lotto.isNumberExisted(bonusNumber))
                .isFalse();
    }

    @DisplayName("로또 번호를 오름차순 정렬해서 출력한다.")
    @Test
    void getSortedNumberStringByNumberIsNotSorted() {
        //given
        Lotto lotto = new Lotto(List.of(3, 4, 5, 1, 2, 6));
        //when then
        assertThat(lotto.getSortedNumberString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("6개의 번호를 맞추면 LottoRank.FIRST 를 반환한다.")
    @Test
    void getRankByLottoHit6Number() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("5개의 번호와 보너스 번호를 맞추면 LottoRank.SECOND 를 반환한다.")
    @Test
    void getRankByLottoHit5NumberAndBonus() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("5개의 번호를 맞추면 LottoRank.THIRD 를 반환한다.")
    @Test
    void getRankByLottoHit5Number() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4개의 번호를 맞추면 LottoRank.FORTH 를 반환한다.")
    @Test
    void getRankByLottoHit4Number() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.FORTH);
    }

    @DisplayName("3개의 번호를 맞추면 LottoRank.FIFTH 를 반환한다.")
    @Test
    void getRankByLottoHit3Number() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("2개 이하의 번호를 맞추면 LottoRank.SIXTH 를 반환한다.")
    @Test
    void getRankByLottoHitUnder3Number() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 11, 8, 9, 10));
        //when then
        assertThat(lotto.getRank(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.SIXTH);
    }
}