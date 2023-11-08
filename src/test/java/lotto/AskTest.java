package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AskTest {

    @Test
    @DisplayName("보너스 번호는 당첨번호와 중복되면 에러가 발생한다.")
    void DuplicatedBonusNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Ask.checkValidBonusNumber(new Lotto(numbers), numbers.get(Randoms.pickNumberInRange(0, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}