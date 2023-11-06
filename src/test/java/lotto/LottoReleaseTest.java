package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Lotto;
import lotto.domain.Customer;
import lotto.utility.GameUtility;
import lotto.utility.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 발행 테스트")
public class LottoReleaseTest extends NsTest{

    @ParameterizedTest
    @DisplayName("지불 금액만큼 로또가 발행되었는 지 테스트한다.")
    @CsvSource(value = "10000, 10")
    void 로또_발행테스트(int payment, int lottoAmount) {
        // given
        Customer user;
        // when
        List<Lotto> tickets = LottoMachine.generateTickets(payment);
        // then
        assertEquals(tickets.size(), lottoAmount);
    }

    @Test
    @DisplayName("로또 번호가 오름차순인지 테스트 한다.")
    void 로또_오름차순_저장테스트() {
        // given
        List<Integer> LottoNumbers = new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43));
        // when, then
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Customer user;
                    assertEquals(LottoMachine.generateTickets(1000).get(0).getNumbers(), LottoNumbers);
                },
                Arrays.asList(43, 41, 42, 23, 21, 8)
        );
    }

    @Override
    protected void runMain() {
    }
}
