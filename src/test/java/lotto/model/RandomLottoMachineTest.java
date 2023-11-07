package lotto.model;

import lotto.constant.IntConstants;
import lotto.util.RandomLottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoMachineTest {
    private static final int LOTTO_SIZE = IntConstants.LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_NUMBER = IntConstants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = IntConstants.MAX_LOTTO_NUMBER.getValue();
    RandomLottoMachine randomLottoMachine = new RandomLottoMachine();
    List<Integer> randomLotto = randomLottoMachine.generate();

    @DisplayName("randomLottoMachine에 의해 생성된 로또는 6개의 숫자로 이루어져있다.")
    @Test
    void createRandomLottoWithSixElements() {
        assertThat(randomLotto.size()).isEqualTo(LOTTO_SIZE);
    }

    @DisplayName("randomLottoMachine에 의해 생성된 로또는 모두 다른 숫자로 이루어져 있다.")
    @Test
    void createNotDuplicatedRandomLotto() {
        assertThat(randomLotto.stream().distinct().count()).isEqualTo(LOTTO_SIZE);
    }

    @DisplayName("randomLottoMachine에 의해 생성된 로또는 1부터 45사이의 숫자로 이루어져 있다.")
    @Test
    void createRandomLottoInRange() {
        assertThat(randomLotto.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER));
    }
}
