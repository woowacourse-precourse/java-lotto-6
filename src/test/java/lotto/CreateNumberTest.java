package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CreateNumberTest {

    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    Lotto lotto = new Lotto(numbers);

    @Test
    void createLottoNumberTest() {
        assertEquals(6, lotto.getNumbers().size());
    }
}