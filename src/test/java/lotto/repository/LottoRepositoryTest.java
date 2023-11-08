package lotto.repository;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    private static final int LOTTO_NUMBERS_CIPHER = 6;

    LottoRepository lottoRepository = new LottoRepository();

    @Test
    void 로또를_생성하면_DTO로_생성된_로또를_반환한다() {
        LottoDto createdDto = lottoRepository.createLotto();
        List<Integer> createdNumbers = createdDto.numbers();
        assertThat(createdNumbers.size()).isEqualTo(LOTTO_NUMBERS_CIPHER);
    }

    @Test
    void 생성된_로또_번호_직접_확인해보기() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoDto createdDto = lottoRepository.createLotto();
            List<Integer> createdNumbers = createdDto.numbers();
            assertThat(createdNumbers).isEqualTo(lottoNumbers);
        }, lottoNumbers);
    }

    @Test
    void 리포지토리를_통해서_보관하고있는_도메인_정보를_DTO를_통해서_조회가능() {
        // 2번 생성 및 저장
        LottoDto lotto1 = lottoRepository.createLotto();
        LottoDto lotto2 = lottoRepository.createLotto();

        List<LottoDto> lottoDtoes = lottoRepository.findLottoDtoes();
        assertThat(lottoDtoes.size()).isEqualTo(2);
        assertThat(lottoDtoes.get(0)).isEqualTo(lotto1);
        assertThat(lottoDtoes.get(1)).isEqualTo(lotto2);
    }
}