package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @DisplayName("로또 번호 전부 출력")
    @Test
    void getNumber(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String result = String.valueOf(lotto.getNumbers());
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호 지정 출력")
    @Test
    void getNumberIndex(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String result = String.valueOf(lotto.getNumberIndex(0));
        assertThat(result).isEqualTo("1");
    }

    @DisplayName("로또 번호 지정 설정")
    @Test
    void setNumberIndex(){
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        lotto.setNumberIndex(0,7);
        String result = String.valueOf(lotto.getNumbers());
        assertThat(result).isEqualTo("[7, 2, 3, 4, 5, 6]");
    }
}