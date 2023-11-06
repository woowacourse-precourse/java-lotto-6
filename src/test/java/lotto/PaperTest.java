package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.collection;

class PaperTest {
    private Paper paper=new Paper();
    @Test
    void 랜덤번호_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    paper.pickLottoNumber();
                    assertThat(paper.getNumber()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));

                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 일치하는숫자개수_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    paper.pickLottoNumber();
                    paper.checkCorrespondNum(List.of(1, 2, 23, 41, 42, 43),7);
                    assertThat(paper.getCorrespondNum()).isEqualTo(4);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 당첨금액_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    paper.pickLottoNumber();
                    paper.checkCorrespondNum(List.of(1, 2, 23, 41, 42, 43),7);
                    paper.checkWinMoney();
                    assertThat(paper.getWinMoney()).isEqualTo(50000);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

}
