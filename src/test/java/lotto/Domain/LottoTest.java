package lotto.Domain;

import lotto.Domain.Lotto;
import lotto.service.InputService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    Lotto lotto ;
    InputService inputService;

    @BeforeEach
    @Test
    void init() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.lottosize=14;
        inputService=new InputService();
    }
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

    @DisplayName("로또 구입금액 을 이용해 로또 발행 갯수를 구하는 기능.")
    @Test
    void lotto3() {
        String price="14000";
        lotto.generateLottoSize(price);
        Assertions.assertThat(lotto.lottosize).isEqualTo(14);
    }
    @DisplayName("로또 발행 갯수만큼 로또번호를 생성하는 기능.")
    @Test
    void lotto4() {
        lotto.generateLottoNum();
        Assertions.assertThat(lotto.getLottoNum().size()).isEqualTo(14);

    }
}