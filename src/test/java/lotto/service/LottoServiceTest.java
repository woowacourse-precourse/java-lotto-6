package lotto.service;

import lotto.dto.MoneyDto;
import lotto.dto.ResultDto;
import lotto.dto.WinNumbersDto;
import lotto.util.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final int SINGLE_LOTTO_PRICE = 1000;

    LottoService lottoService = new LottoService();

    @Test
    void 로또에_1등으로_당첨된_경우_1등에_대한_카운트가_1씩_올라간다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    // 1개의 로또를 샀다
                    purchaseLottoGivenCount(1);
                    WinNumbersDto winNumbersDto = new WinNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
                    ResultDto resultDto = lottoService.generateResult(winNumbersDto);
                    assertThat(resultDto.rankingCount().containsKey(Ranking.FIRST)).isTrue();
                    assertThat(resultDto.rankingCount().get(Ranking.FIRST)).isEqualTo(1);
                }, List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 로또에_2등_3등으로_당첨된_경우_각_등수에_대한_카운트가_1씩_올라간다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    // 2개의 로또를 샀다
                    purchaseLottoGivenCount(2);
                    WinNumbersDto winNumbersDto = new WinNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
                    ResultDto resultDto = lottoService.generateResult(winNumbersDto);
                    assertThat(resultDto.rankingCount().get(Ranking.SECOND)).isEqualTo(1);
                    assertThat(resultDto.rankingCount().get(Ranking.THIRD)).isEqualTo(1);
                },
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8)
        );
    }

    @Test
    void 해당_등수가_없으면_카운트에_등록되지_않아_조회하면_null을_반환한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    purchaseLottoGivenCount(1);
                    WinNumbersDto winNumbersDto = new WinNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
                    ResultDto resultDto = lottoService.generateResult(winNumbersDto);
                    assertThat(resultDto.rankingCount().containsKey(Ranking.SECOND)).isFalse();
                    assertThat(resultDto.rankingCount().get(Ranking.SECOND)).isNull();
                    assertThat(resultDto.rankingCount().get(Ranking.FIFTH)).isNull();
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    private void purchaseLottoGivenCount(int count) {
        lottoService.purchaseLottoes(new MoneyDto(SINGLE_LOTTO_PRICE * count));
    }
}