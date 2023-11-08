package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    public String[] errorCode = new String[1];
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7),errorCode))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5),errorCode))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 비교 함수")
    @Test
    void compareNumberTest(){
        Lotto num1 = new Lotto(List.of(1,2,3,4,5,6),errorCode);
        Lotto num2 = new Lotto(List.of(1,2,3,4,5,6),errorCode);
        Lotto num3 = new Lotto(List.of(1,2,3,4,5,7),errorCode);
        Lotto num4 = new Lotto(List.of(7,8,9,10,11,12),errorCode);
        assertThat(num2.compareNumber(num1,0)).isEqualTo(7);
        assertThat(num3.compareNumber(num1,7)).isEqualTo(6);
        assertThat(num4.compareNumber(num1,0)).isEqualTo(0);
    }

}