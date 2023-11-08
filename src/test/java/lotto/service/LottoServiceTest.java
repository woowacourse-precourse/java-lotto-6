package lotto.service;

import lotto.dto.MoneyDto;
import lotto.dto.ResultDto;
import lotto.dto.WinNumbersDto;
import lotto.util.consts.Ranking;
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
                    assertThat(resultDto.rankingCounts().containsKey(Ranking.FIRST)).isTrue();
                    assertThat(resultDto.rankingCounts().get(Ranking.FIRST)).isEqualTo(1);
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
                    assertThat(resultDto.rankingCounts().get(Ranking.SECOND)).isEqualTo(1);
                    assertThat(resultDto.rankingCounts().get(Ranking.THIRD)).isEqualTo(1);
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
                    assertThat(resultDto.rankingCounts().containsKey(Ranking.SECOND)).isFalse();
                    assertThat(resultDto.rankingCounts().get(Ranking.SECOND)).isNull();
                    assertThat(resultDto.rankingCounts().get(Ranking.FIFTH)).isNull();
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void 수익률을_계산해서_반환한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    purchaseLottoGivenCount(2);
                    WinNumbersDto winNumbersDto = new WinNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
                    ResultDto resultDto = lottoService.generateResult(winNumbersDto);
                    assertThat(resultDto.benefitRate()).isEqualTo(101500000.0);
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7));
    }

    @Test
    void 수익률은_소수점_둘째자리에서_반올림한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    purchaseLottoGivenCount(3);
                    WinNumbersDto winNumbersDto = new WinNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
                    ResultDto resultDto = lottoService.generateResult(winNumbersDto);
                    assertThat(resultDto.benefitRate()).isEqualTo(1833.3);
                },
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 4, 11, 12),
                List.of(21, 22, 23, 24, 25, 26));
    }

    private void purchaseLottoGivenCount(int count) {
        lottoService.purchaseLottoes(new MoneyDto(SINGLE_LOTTO_PRICE * count));
    }
}