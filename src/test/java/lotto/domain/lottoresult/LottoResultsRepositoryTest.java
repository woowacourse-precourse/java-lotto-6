package lotto.domain.lottoresult;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsRepositoryTest {

    @DisplayName("3등, 4등으로 로또 결과를 업데이트 해 DTO 를 통해 총 상금을 받으면, 총 상금은 1,550,000 이다.")
    @Test
    void lottoResultRepositoryTest_1() {
        //given
        LottoResultsRepository lottoResultsRepository = new LottoResultsRepository();
        //when
        lottoResultsRepository.saveLottoResult(LottoResult.THIRD);
        lottoResultsRepository.saveLottoResult(LottoResult.FOURTH);
        //then
        assertThat(lottoResultsRepository.getTotalLottoPrizeMoney()).isEqualTo(1550000);
    }
}