package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import lotto.io.OutputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest extends NsTest {
    static public int AMOUNT = 1;
    LottoGenerator lottoGenerator;
    List<Lotto> lottos;

    @BeforeEach()
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 발행시 1~45의 6개의 숫자가 중복없이 오름차순으로 정렬되어 출력된다.")
    @Test
    void createLottos() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]"
                    );
                },
                List.of(45, 42, 38, 16, 14, 13)
        );
    }

    public void runMain() {
        lottos = lottoGenerator.issueLotto(AMOUNT);
        OutputHandler.printLottoAmount(AMOUNT);
        OutputHandler.printLottos(lottos);
    }
}
