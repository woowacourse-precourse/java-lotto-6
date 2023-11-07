package lotto.domain.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTargetNumResultsTest {
    private LottoTargetNumResults lottoTargetNumResults;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;

    @BeforeEach
    void setUp() {
        winLottoNums = new WinLottoNums(List.of(1, 2, 3, 4, 5, 6));
        bonusLottoNum = new BonusLottoNum(7);
        lottoTargetNumResults = new LottoTargetNumResults(List.of(1, 2, 3, 4, 5, 6), 7);
    }


    @DisplayName("당첨 번호 추첨 번호가 같은지 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2", "4,3", "5,4", "6,5"})
    void isSameWinNums(Integer targetNum, Integer indexOfSpecial) {
        // when
        Boolean result = lottoTargetNumResults.isSameWinNums(targetNum);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("당첨 번호 추첨 번호가 같은지 확인한다.")
    @Test
    void isSameBonusNum() {
        Integer targetNum = 7;
        Integer indexOfSpecial = 6;

        // when
        Boolean result = lottoTargetNumResults.isSameBonusNum(targetNum, indexOfSpecial);

        // than
        assertThat(result).isTrue();
    }

}