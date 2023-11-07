package lotto;

import lotto.domain.model.Lotto;
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

    @Test
    @DisplayName("compareTo method 로 일치하는 로또 갯수 테스트하기")
    void compareToTest() throws Exception{
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(2,3,4,5,6,7));
        //when
        int matchCount1 = lotto1.compareTo(lotto2);
        int matchCount2 = lotto2.compareTo(lotto1);
        //then
        assertThat(matchCount1).isEqualTo(5);
        assertThat(matchCount2).isEqualTo(5);
     }

     @Test
     @DisplayName("한번도 일치 하지 않을 경우 테스트")
     void compareToNothingTest() throws Exception{
         //given
         Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
         Lotto lotto2 = new Lotto(List.of(11,12,13,14,15,16));
         //when
         int matchCount1 = lotto1.compareTo(lotto2);
         int matchCount2 = lotto2.compareTo(lotto1);
         //then
         assertThat(matchCount1).isEqualTo(0);
         assertThat(matchCount2).isEqualTo(0);
      }
}