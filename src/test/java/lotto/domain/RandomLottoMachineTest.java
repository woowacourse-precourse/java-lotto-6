package lotto.domain;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoMachineTest {

    @Test
    void 지정된_범위의_랜덤() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    void 램덤_생성_개수() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        assertThat(numbers).hasSize(6);
    }

    @Test
    void 램덤_중복되지_않은_숫자_생성() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> resultNumbers = new HashSet<>(numbers);
        assertThat(numbers).hasSameSizeAs(resultNumbers);
    }

}