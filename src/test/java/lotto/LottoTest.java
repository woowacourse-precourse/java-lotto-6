package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호 오름차순 정렬 확인")
    @Test
    void checkSort() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 3, 5, 4, 2, 6));
        Collections.sort(numbers);

        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("금액에 따른 개수 확인")
    @Test
    void priceToNumber() {
        UserLottos lottos = new UserLottos();

        lottos.setAmmount("5000");

        assertThat(lottos.getAmmount()).isEqualTo(5);
    }

    @DisplayName("로또가 임의의 값으로 잘 생성이 되었나 크기로 확인")
    @Test
    void setLottos() {
        UserLottos lottos = new UserLottos();

        for (int i = 0; i < 5; i++) {
            lottos.setLottos();
        }

        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
