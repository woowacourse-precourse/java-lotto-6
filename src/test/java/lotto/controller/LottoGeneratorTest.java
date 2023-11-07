package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.controller.LottoGenerator;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest extends NsTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void test_generate_lottos() {
        List<Integer> lottoNumbers = List.of(8, 21, 23, 41, 42, 43);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = lottoGenerator.generateLottos(1);
                    assertEquals(new Lotto(lottoNumbers), lottos.get(0));
                },
                lottoNumbers
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
