package lotto.util;

import static lotto.constant.Game.MAX_NUMBER;
import static lotto.constant.Game.MIN_NUMBER;
import static lotto.constant.Game.TOTAL_PICK;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoNumberGeneratorTest {
    @RepeatedTest(100)
    @DisplayName("생성된 로또 번호는 1과 45사이의 값들로 이루어져야 한다.")
    void validLottoNumber() {
        List<Integer> lotto = LottoNumberGenerator.generate();

        for (int num : lotto) {
            assertThat(num).isBetween(MIN_NUMBER.getNum(), MAX_NUMBER.getNum());
        }
    }

    @RepeatedTest(100)
    @DisplayName("생성된 번호 중 중복되는 번호가 있어서는 안 된다.")
    void duplicateNumberShouldNotExists() {
        List<Integer> lotto = LottoNumberGenerator.generate();
        Set<Integer> numbers = new HashSet<>(lotto);

        assertThat(numbers.size()).isEqualTo(TOTAL_PICK.getNum());
    }
}
