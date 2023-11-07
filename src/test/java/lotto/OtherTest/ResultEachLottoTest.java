package lotto.OtherTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.model.ResultEachLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultEachLottoTest extends NsTest {
    @Test
    @DisplayName("매치_카운트와_보너스_매치에_따른_등수_확인")
    void 등수_확인() {
        // 1등 케이스
        ResultEachLotto result = new ResultEachLotto(6, 0);
        Assertions.assertEquals(1, result.getRank());

        // 2등 케이스
        result = new ResultEachLotto(5, 1);
        Assertions.assertEquals(2, result.getRank());

        // 3등 케이스
        result = new ResultEachLotto(5, 0);
        Assertions.assertEquals(3, result.getRank());

        // 4등 케이스
        result = new ResultEachLotto(4, 0);
        Assertions.assertEquals(4, result.getRank());

        // 5등 케이스
        result = new ResultEachLotto(3, 0);
        Assertions.assertEquals(5, result.getRank());

        // 등수에 해당하지 않는 케이스
        result = new ResultEachLotto(2, 0);
        Assertions.assertEquals(-1, result.getRank());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
