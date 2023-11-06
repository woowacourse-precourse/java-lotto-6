package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호를 오름차순으로 정리한다.")
    @Test
    void testSortLottoAscending() {
        Lotto inputLotto = new Lotto(new ArrayList<>(Arrays.asList(42, 21, 39, 5, 16, 1)));
        List<Integer> sortedNumbers = List.of(1, 5, 16, 21, 39, 42);

        assertThat(inputLotto.getNumbers()).isEqualTo(sortedNumbers);
    }

}