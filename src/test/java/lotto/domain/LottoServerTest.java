package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.infra.RandomLottoGenerator;
import lotto.io.ConsoleInputReader;
import lotto.io.IoException;
import lotto.io.LottoInput;
import lotto.io.LottoOutput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServerTest extends NsTest {

    @Test
    void 정상적인_입력에_대한_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 101,500,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Test
    void 구입_금액의_비정상적인_입력에_대한_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("0", "a", "1500", "2000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            DomainException.PRICE_LESS_THAN_OR_EQUAL_TO_ZERO.getMessage(),
                            IoException.NOT_NUMBER.getMessage(),
                            DomainException.PRICE_NOT_DIVISIBLE_BY_UNIT.getMessage(),
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 101,500,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    @Test
    void 당첨_번호의_비정상적인_입력에_대한_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("2000", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "a,2,3,4,5,6", "1,2,3,4,5", "46,1,2,3,4,5", "1,1,1,1,1,1", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "2개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 7]",
                            IoException.NOT_NUMBER.getMessage(),
                            DomainException.LOTTO_SIZE.getMessage(),
                            DomainException.LOTTO_RANGE.getMessage(),
                            DomainException.LOTTO_DUPLICATION.getMessage(),
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 101,500,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }
    @Override
    protected void runMain() {
        LottoServer lottoServer = new LottoServer(
                new LottoController(new LottoInput(new ConsoleInputReader()), new LottoOutput(new LottosConverter(), new StatisticsConverter())),
                new RandomLottoGenerator()
        );
        lottoServer.run();
    }
}