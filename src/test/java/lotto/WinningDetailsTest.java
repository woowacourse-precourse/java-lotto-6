package lotto;

import lotto.element.WinningDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningDetailsTest {
    @DisplayName("출력 형식 테스트")
    @Test
    void executeToString() {
        String[] ans = {"3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"};
        for (WinningDetails wd : WinningDetails.values()) {
            String result = wd.toString();
            assertThat(result).contains(ans[wd.ordinal()]);
        }
    }
}
