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
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoWinningChecker checker = new LottoWinningChecker(List.of(1,2,3,4,5,6), 7);
        LottoResult result = checker.check(lotto);
        assertThat(lottoResultManager.add(result)).isEqualTo(0);
    }

    @DisplayName("로또 수익률 계산")
    @Test
    void calculateLottoRateOfReturn(){
        LottoWinningChecker checker = new LottoWinningChecker(List.of(1,2,3,10,11,12), 7);

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoResult result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        lotto = new Lotto(List.of(23,32,45,4,5,6));
        result = checker.check(lotto);
        lottoResultManager.add(result);

        assertThat(lottoResultManager.calculateRateOfReturn(2)).isEqualTo(55.6);
    }
}
