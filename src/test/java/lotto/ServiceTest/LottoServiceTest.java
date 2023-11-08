package lotto.ServiceTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Lottery;
import lotto.Lotto;
import lotto.ServiceImp.LottoServiceImp;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import java.util.List;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest extends NsTest
{
    public void createRecordResult()
    {
        assertRandomUniqueNumbersInRangeTest(() -> {
            assertThat(new LottoServiceImp().getResultRecordOfLotto(new Lotto(List.of(1,2,3,4,5,6)), 7)
                    .stream().map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]")))
                        .isEqualTo("[1, 1, 1, 1, 1]");
        },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 10),
                List.of(1, 2, 3, 4, 10, 10),
                List.of(1, 2, 3, 10, 10, 10),
                List.of(1, 2, 3, 4, 5, 7)
        );
    }

    public void createProfitRatePrecisionTest()
    {
        LottoServiceImp lottoServiceImp = new LottoServiceImp();
        lottoServiceImp.initializeLottery(8000);
        double profitRate = lottoServiceImp.getProfitRate(List.of(1, 1, 1, 1, 1));
        assertEquals(profitRate, String.format("%.1f", profitRate));
    }

    public void createProfileRateValueTest()
    {
        LottoServiceImp lottoServiceImp = new LottoServiceImp();
        lottoServiceImp.initializeLottery(8000);
        double profitRate = lottoServiceImp.getProfitRate(List.of(1, 1, 1, 1, 1));
        assertEquals(253944.4, profitRate);
    }

    public void runMain()
    {
        Application.main(new String[]{});
    }
}
