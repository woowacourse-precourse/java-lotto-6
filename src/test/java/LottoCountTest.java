import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @DisplayName("로또개수가 원하는 개수만큼 나오는지 확인한다.")
    @Test
    void setLotties() {
        LottoCount lottoCount = new LottoCount(8000);

        int lottoCnt = lottoCount.getLottoCount();
        int compareValue = lottoCount.getLotties().size();

        assertThat(lottoCnt).isEqualTo(compareValue);
    }
}
