package lotto.ViewTest.OutputViewTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.View.OutputView;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class printResultRecordTest extends NsTest {
    public void checkResultRecordResult()
    {
        assertThat(output()).contains("당첨 통계", "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

    public void runMain()
    {
        List<Integer> resultRecord = new ArrayList<>(List.of(1, 1, 1, 1, 1));
        new OutputView().printResultRecord(resultRecord);
    }
}
