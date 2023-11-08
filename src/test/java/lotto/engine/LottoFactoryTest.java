package lotto.engine;

import static lotto.engine.LottoSystemConstant.LOTTO_MAXIMUM_NUMBER_OF_WINNINGS;
import static lotto.engine.LottoSystemConstant.WINNING_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.engine.domain.Customer;
import lotto.engine.domain.Lotto;
import lotto.engine.dto.WinningResult;
import lotto.engine.manager.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @DisplayName("요청한 갯수만큼 정렬된 로또들을 발행한다.")
    @ParameterizedTest(name = "[{index}차]시도: quantity: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIssueLotto(int quantity) {
        //given
        //when
        List<Lotto> lottos = lottoFactory.issueLotto(quantity);
        //then
        assertThat(lottos).hasSize(quantity);
    }

    @Test
    @DisplayName("로또 발행 내역을 보여준다.")
    void testShowTotalLotto() {
        //given
        List<Lotto> lottos = getLottos();
        //when
        String issuedLottos = lottoFactory.showTotalLotto(lottos);
        //then
        assertThat(issuedLottos).contains("[", "]", ",", "\n");
    }

    @Test
    @DisplayName("사용자가 입력한 당첨번호와 램덤하게 발행된 로또 내역을 집계한다.")
    void testAggregate() {
        //given
        List<Integer> userWinningNumbers = List.of(10, 20, 30, 31, 32, 33);
        Customer customer = new Customer(userWinningNumbers, 15);
        List<Lotto> lottos = getLottos();
        //when
        WinningResult winningResult = lottoFactory.aggregate(customer, lottos);
        Map<Integer, Integer> actual = winningResult.winningCriteria();

        //then
        assertThat(winningResult.profit()).isGreaterThan(100);
        assertThat(actual).containsEntry(LOTTO_MAXIMUM_NUMBER_OF_WINNINGS.value(),1);
    }

    public List<Lotto> getLottos() {
        return List.of(
                new Lotto(List.of(10, 20, 30, 31, 32, 33)),
                new Lotto(List.of(3, 7, 11, 14, 43, 44))
        );
    }


}