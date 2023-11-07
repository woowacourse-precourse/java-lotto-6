package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자 6개 뽑기 테스트")
    void generateUniqueAndRandomSixNumber() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

}
