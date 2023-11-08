package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.config.AppConfig;
import lotto.config.WiningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {
    Judgement judgement;

    @BeforeEach
    void beforeEach() {
        judgement = new AppConfig().judgement();
    }

    @Test
    void 당첨번호판정테스트() {
        //given
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winingNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int targetWiningCount = 6;
        //when
        int winingCount = judgement.judgeWiningNumber(lotto, winingNumber);
        //then
        Assertions.assertThat(winingCount).isEqualTo(targetWiningCount);
    }

    @Test
    void 보너스번호판정테스트() {
        //given
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 4;
        boolean target = true;
        //when
        boolean result = judgement.judgeBonusNumber(lotto, bonusNumber);
        //then
        Assertions.assertThat(result).isEqualTo(target);
    }

    @Test
    void 랭크판정테스트() {
        //given
        int winingCount = 5;
        boolean bonusCount = true;
        WiningRank targetRank = WiningRank.RANK2;
        //when
        WiningRank rank = judgement.judgeRanking(winingCount, bonusCount);
        //then
        Assertions.assertThat(rank).isEqualTo(targetRank);
    }

}