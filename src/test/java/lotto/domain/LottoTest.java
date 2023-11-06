package lotto.domain;

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
    @DisplayName("로또 번호가 1~45의 숫자가 아니면 예외가 발생한다.")
    @Test
    void outOfRangeException(){
        //given //when //then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되는 확인한다.")
    @Test
    void checkContains(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 1;

        //when
        boolean isContain = lotto.checkContains(bonusNumber);

        //then
        assertThat(isContain).isEqualTo(true);
    }

    @DisplayName("당첨 로또와 내가 산 로또가 몇개가 일치하는지 반환한다.")
    @Test
    void getSameNumberCoun(){
        //given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto myLotto = new Lotto(List.of(1,2,3,7,8,9));

        //when
        int sameNumberCount = winningLotto.getSameNumberCount(myLotto);

        //then
        assertThat(sameNumberCount).isEqualTo(3);
    }
}