package lotto.Test.FunctionTest;

import lotto.model.lottoResultChecker.Lotto;
import lotto.model.lottoResultChecker.LottoBonus;
import lotto.model.lottoResultChecker.LottoRank;
import lotto.model.lottoResultChecker.LottoRankChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


public class LottoRankCheckerTest {

    private LottoRankChecker rankChecker;
    private Lotto winningLotto;
    private LottoBonus bonus;

    @BeforeEach
    void setUp() {
        rankChecker = new LottoRankChecker();
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonus = new LottoBonus("7", Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("6개 번호가 모두 맞으면 1등을 반환해야 한다")
    void FirstRankerTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoRank rank = rankChecker.determineRank(lotto, winningLotto, bonus);
        assertEquals(LottoRank.FIRST, rank, "6개 번호가 모두 일치할 때 1등을 반환해야 한다");
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 맞으면 2등을 반환해야 한다")
    void SecondRankerTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoRank rank = rankChecker.determineRank(lotto, winningLotto, bonus);
        assertEquals(LottoRank.SECOND, rank, "5개 번호와 보너스 번호가 일치할 때 2등을 반환해야 한다");
    }

}
