package lotto;

import lotto.lottoenum.LottoRanking;
import org.junit.jupiter.api.BeforeEach;
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
    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 first를 반환한다.")
    @Test
    void createLottoFirst(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(1,2,3,4,5,6), 7)).isEqualTo(LottoRanking.FIRST);
    }

    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 second를 반환한다.")
    @Test
    void createLottoSecond(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(1,2,3,4,5,8), 8)).isEqualTo(LottoRanking.SECOND);
    }

    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 third를 반환한다.")
    @Test
    void createLottoThird(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(1,2,3,4,5,9), 7)).isEqualTo(LottoRanking.THIRD);
    }

    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 fourth를 반환한다.")
    @Test
    void createLottoFourth(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(1,2,3,4,8,9), 7)).isEqualTo(LottoRanking.FOURTH);
    }

    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 fifth를 반환한다.")
    @Test
    void createLottoFifth(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(1,2,3,8,9,10), 7)).isEqualTo(LottoRanking.FIFTH);
    }

    @DisplayName("로또 번호가 1등 당첨인 경우 enum클래스의 default를 반환한다.")
    @Test
    void createLottoDefault(){
        Lotto curLotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(curLotto.lotteryCheck(List.of(7,8,9,10,11,12), 13)).isEqualTo(LottoRanking.DEFAULT);
    }
}