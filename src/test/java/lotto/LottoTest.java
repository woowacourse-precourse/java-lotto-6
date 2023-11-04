package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("로또 생성 후 로또저장소에 저장한다.")
    @Test
    void createLottoAndLottoStore() {
        Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = LottoStore.getInstance().getLotto();
        Lotto lotto = lottos.get(0);
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottos.size()).isEqualTo(1);
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.get(2)).isEqualTo(3);
    }

    @DisplayName("로또를 로또저장소에 저장한 후 발행 내역을 출력한다.")
    @Test
    void createLottoAndLottoStoreHistory() {
        Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto.createLotto(List.of(1, 2, 3, 20, 23, 27));

        String lottoHistory = LottoStore.getInstance().getLottoHistory();
        assertThat(lottoHistory).isEqualTo(
                "[1, 2, 3, 4, 5, 6]\n"+
                "[1, 2, 3, 20, 23, 27]\n"
        );
    }

    @DisplayName("쉼표로 구분된 숫자를 입력받아 숫자 배열로 반환한다.")
    @Test
    void setWinningNumberToArray() {
        String number = "1,2,3,4,5,6";
        List<Integer> numbers = LottoStore.getInstance().setWinningLotto(number);

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.toString()).isEqualTo(
                "[1, 2, 3, 4, 5, 6]"
        );
    }
}