package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.Budget;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import lotto.model.strategy.LottoStrategy;
import lotto.model.strategy.MyLottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoStrategyTest {
    private Budget budget;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private BonusNumber bonusNumber;
    private LottoStrategy lottoStrategy;
    @BeforeEach
    void setUp(){
        budget = new Budget(1000);
        winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6));
        bonusNumber = new BonusNumber(7, winningLotto);
        lottoStrategy = new MyLottoStrategy();
    }

    @DisplayName("6개 번호 일치 시 RANK1 출력 테스트")
    @Test
    void testRank1(){
        List<Integer> testNumbers = Arrays.asList(1,2,3,4,5,6);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        assertThat(lottoStrategy.determineRank(lottoTicket, winningLotto,bonusNumber))
                .isEqualTo(LottoRank.RANK1);
    }






}
