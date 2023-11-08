package lotto;

import lotto.model.Lotto;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 제한된 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 타입의 로또 번호를 정렬한 후 문자열 타입으로 보기 좋게 변환하여 반환한다.")
    @Test
    void convertLottoListToString() {
        Lotto lotto = new Lotto(List.of(3, 4, 5, 1, 2, 6));

        String lottoFormat = lotto.getNumbersToString();

        assertThat(lottoFormat).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("다른 로또와 일치하는 숫자의 개수를 센다.")
    @Test
    void countSameNumbersWithAnotherLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto anotherLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        int sameNumbersCount = lotto.countSameNumbers(anotherLotto);

        assertThat(sameNumbersCount).isEqualTo(3);
    }
}