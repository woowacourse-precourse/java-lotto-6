package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultRepositoryTest {

    ResultRepository resultRepository = new ResultRepository();

    @Test
    @DisplayName("당첨 횟수를 저장한다")
    void 당첨_회수_저장() {
        //given
        resultRepository.init();
        resultRepository.save(Rank.FIRST);
        resultRepository.save(Rank.FIFTH);


        //when
        int first = resultRepository.findWinningByRank(Rank.FIRST);
        int fifth = resultRepository.findWinningByRank(Rank.FIFTH);

        //then
        assertThat(first).isEqualTo(1);
        assertThat(fifth).isEqualTo(1);
    }

}