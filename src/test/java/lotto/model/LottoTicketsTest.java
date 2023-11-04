package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoTicketsTest {

    @Test
    @DisplayName("생성된 로또 번호가 1에서 45 사이의 수인지 검증한다.")
    void generateLottoNumbers_successful() {
        /**
         * given : 1에서 45까지의 수를 골라 6자리의 수를 담은 리스트를 생성한다.
         * when : 리스트를 순회한다.
         * then : 리스트의 원소들이 1에서 45 사이의 수인지 검증한다.
         */
        List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        for (int number : randomNum) {
            assertTrue(number >= 1 && number <= 45);
        }
    }
}