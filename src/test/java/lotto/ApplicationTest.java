package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 숫자_비교_테스트() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winNumbers = List.of(2, 3, 5, 7, 8, 9);

        int matchingCount = Application.countMatchNumbers(lottoNumbers, winNumbers);

        assertThat(matchingCount).isEqualTo(3);
    }

    @Test
    void 로또_생성_테스트() {
        int numberOfTickets = 5;
        List<Lotto> lottoTickets = Application.generateLottoTickets(numberOfTickets);

        assertThat(lottoTickets).hasSize(numberOfTickets);
        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    void 순위_반환_테스트() {
        assertThat(Application.getLottoRank(6, false)).isEqualTo(Application.LottoRank.FIRST);
        assertThat(Application.getLottoRank(5, true)).isEqualTo(Application.LottoRank.SECOND);
        assertThat(Application.getLottoRank(5, false)).isEqualTo(Application.LottoRank.THIRD);
        assertThat(Application.getLottoRank(4, false)).isEqualTo(Application.LottoRank.FOURTH);
        assertThat(Application.getLottoRank(3, false)).isEqualTo(Application.LottoRank.FIFTH);
        assertThat(Application.getLottoRank(0, false)).isEqualTo(Application.LottoRank.NONE);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
