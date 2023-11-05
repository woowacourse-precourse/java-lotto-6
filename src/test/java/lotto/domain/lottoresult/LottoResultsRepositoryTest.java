package lotto.domain.lottoresult;


import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.dto.LottoResultsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsRepositoryTest {

    @DisplayName("3등, 4등으로 로또 결과를 업데이트 해 DTO 를 통해 총 상금을 받으면, 총 상금은 1,550,000 이다.")
    @Test
    void lottoResultRepositoryTest_1() {
        //given
        LottoResultsRepository lottoResultsRepository = new LottoResultsRepository();
        lottoResultsRepository.saveLottoResult(LottoResult.THIRD);
        lottoResultsRepository.saveLottoResult(LottoResult.FOURTH);
        //when
        LottoResultsDto lottoResultsDto = lottoResultsRepository.makeLottoResultsDto();
        //then
        assertThat(lottoResultsDto.getTotalLottoPrizeMoney()).isEqualTo(1550000);
    }
}