package lotto;

import lotto.domain.Lotto;
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

    @DisplayName("로또 번호에 1~45 이외의 숫자가 존재하면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber(){
        assertThatThrownBy(()->new Lotto(List.of(0,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,5,77)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호가 오름차순으로 저장되야한다.")
    @Test
    void createLottoByUnorderedNumbers(){
        //given
        List<Integer> example = List.of(5,44,28,1,17,35);

        //when
        Lotto result = new Lotto(example);

        //then
        assertThat(result.getNumbers()).isEqualTo(List.of(1,5,17,28,35,44));

    }

    @DisplayName("로또 번호 갯수가 6개 미만이면 예외가 발생한다")
    @Test
    void createLottoBySmallSize(){
        assertThatThrownBy(()-> new Lotto(List.of(0,1,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}