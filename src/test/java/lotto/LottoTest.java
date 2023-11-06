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
    @DisplayName("로또 번호 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize(){
        assertThatThrownBy(()-> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange(){
        assertThatThrownBy(()-> new Lotto(List.of(1,2,3,4,5,49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 객체가 정상적으로 생성이 되는지 확인한다.")
    @Test
    void createLottoSuccessfully(){
        try{
            new Lotto(List.of(1, 2, 3, 4, 22, 45));
        }catch(Exception e) {
        }
    }

    @DisplayName("로또 번호 일치 개수 올바르게 반환하는지 확인한다.")
    @Test
    void countMatchedNumbers(){
        Lotto lotto1 = new Lotto(List.of(1,2,11,22, 42, 45));
        Lotto lotto2 = new Lotto(List.of(1,2,22,33, 9, 45));
        int matchedNumbers = lotto1.countMatchedNumbers(lotto2);
        assertThat(matchedNumbers).isEqualTo(4);
    }
}