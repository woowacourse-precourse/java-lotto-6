import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUtilTest {

    @DisplayName("Lotto번호와 Winning번호 비교하여 일치하는 개수를 반환한다.")
    @Test
    void Winning_Number와_일치하는_개수_반환() {
        // given
        List<Integer> numbers = Arrays.asList(1,3,5,7,9,11);
        Lotto lotto = new Lotto(numbers);

        // when
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        // then
        assertEquals(3, lotto.getMatchCnt(winningNumber));
    }
}