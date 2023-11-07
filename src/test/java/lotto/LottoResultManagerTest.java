package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    private LottoResultManager lottoResultManager;
    @BeforeEach
    void createLottoResultManager(){
        lottoResultManager = new LottoResultManager();
    }

    @DisplayName("로또 결과 저장")
    @Test
    void addLottoResult(){
        assertThat(lottoResultManager.add(LottoResult.FIRST_PRIZE)).isEqualTo(0);
    }

    @DisplayName("로또 수익률 계산")
    @Test
    void calculateLottoRateOfReturn(){
        Lotto winningsLotto = new Lotto(List.of(1,2,3,10,11,12));
        BonusNumber bonusNumber = new BonusNumber(winningsLotto, 7);
        LottoWinningChecker checker = new LottoWinningChecker(winningsLotto, bonusNumber);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(1,2,3,10,11,12));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        checker.check(lotto);

        LottoResultManager resultManager = checker.getLottoResultManager();
        assertThat(resultManager.calculateRateOfReturn(1)).isEqualTo("22,222,277.8");
    }
}
