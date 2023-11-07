package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PapersTest {
    private Papers papers = new Papers();

    @Test
    void 여러개의_랜덤로또번호_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    papers.createPapers(2);
                    assertThat(papers.papers.get(0).getNumber()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));
                    assertThat(papers.papers.get(1).getNumber()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));

                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 총_일치하는숫자의_개수_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    papers.createPapers(2);
                    papers.creatCorrespondNum(List.of(8, 21, 23, 1, 2, 3), 7);
                    assertThat(papers.papers.get(0).correspondNumber).isEqualTo(3);
                    assertThat(papers.papers.get(1).correspondNumber).isEqualTo(3);

                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Test
    void 당첨금액_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    papers.createPapers(2);
                    papers.creatCorrespondNum(List.of(8, 21, 23, 1, 2, 3), 7);
                    papers.creatWinMoney();
                    assertThat(papers.papers.get(0).winMoney).isEqualTo(5000);
                    assertThat(papers.papers.get(1).winMoney).isEqualTo(5000);

                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

}
