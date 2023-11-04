package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultManagerTest {

    private LottoResultManager lottoResultManager;
    @BeforeEach
    void createLottoResultManager(){
        lottoResultManager = new LottoResultManager();
    }
    @Test
    void addLottoResult(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoWinningChecker checker = new LottoWinningChecker(List.of(1,2,3,4,5,6), 7);
        LottoResult result = checker.check(lotto);
        assertThat(lottoResultManager.add(result)).isEqualTo(0);
    }
}
