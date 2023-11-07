package lotto.serviceTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Service.RandomLottoCreService;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomLottoCreServiceTest extends NsTest {
    RandomLottoCreService randomLottoCreService = new RandomLottoCreService();
    @DisplayName("주어진 개수만큼 무작위 로또를 생성한다.")
    @Test
    public void 무작위_로또_생성() {
        // given
        int count = 5;

        // when
        List<Lotto> lottos = randomLottoCreService.createRandomLottos(count);

        // then
        Assertions.assertEquals(lottos.size(), count);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
