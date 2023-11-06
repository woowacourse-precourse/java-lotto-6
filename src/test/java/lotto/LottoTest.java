package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("입력 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void countingTheNumberOfLottos(){
        int price = 15300;
        InputPriceAndCalculateLottoCount count = new InputPriceAndCalculateLottoCount();
        assertThatThrownBy(() -> count.validLottoCount(price))
                .isInstanceOf(Exception.class);
    }

    @DisplayName("중복되지 않은 로또 번호는 추가된다.")
    @Test
    void addLottoNumber(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(lotto);
        assertThat(lottos.get(0).getNumbers()).isEqualTo(lotto.getNumbers());
    }

}