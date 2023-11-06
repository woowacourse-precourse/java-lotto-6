package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {


    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 총_일치하는숫자_개수_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Papers papers = new Papers();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    papers.createPapers(2);
                    papers.creatCorrespondNum(lotto.getLottoNumbers(), 7);
                    papers.creatWinMoney();
                    lotto.saveMatchingNumbers(papers.papers);
                    assertThat(lotto.matchingNumbers).contains(2);
                },
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 20, 21, 22)
        );
    }

    @Test
    void 총_수익률_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Papers papers = new Papers();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    papers.createPapers(2);
                    papers.creatCorrespondNum(lotto.getLottoNumbers(), 7);
                    papers.creatWinMoney();
                    lotto.saveMatchingNumbers(papers.papers);
                    lotto.saveRateOfReturn(papers.papers, 2000);
                    assertThat(lotto.rateOfReturn).isEqualTo(500.0f);
                },
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 20, 21, 22)
        );
    }


}