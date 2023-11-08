package lotto.ServiceTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Lottery;
import lotto.Lotto;
import lotto.ServiceImp.LottoServiceImp;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest extends NsTest
{
    LottoServiceImp lottoServiceImp = new LottoServiceImp();

    public LottoServiceTest()
    {
        lottoServiceImp.initializeLottery(8000);
    }

    @Test
    public void createProfitRateValueTest()
    {
        assertEquals(25394437.5, lottoServiceImp.getProfitRate(List.of(1, 1, 1, 1, 1)));
    }

    public void runMain()
    {
        Application.main(new String[]{});
    }
}
