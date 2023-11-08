package domain;

import static org.assertj.core.api.Assertions.assertThat;

import dto.Lotto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PublishLottoUtilTest {

    private final PublishLottoUtil publishLottoUtil;

    public PublishLottoUtilTest() {
        this.publishLottoUtil = new PublishLottoUtil();
    }

    @Test
    @DisplayName("구매한 로토 개수만큽 발행되는 지 확인한 후 각 로토의 숫자가 6개인지 확인")
    void publishLottoTest() {
        int lottoCnt = 3;
        List<Lotto> lottos = publishLottoUtil.publishLotto(lottoCnt);
        assertThat(lottos.size()).isEqualTo(3);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("발행된 로토의 숫자들이 제대로 출력되는지 확인하는 테스트")
    void showPublishedLotto() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        lottos.add(lotto1);
        lottos.add(lotto2);
        publishLottoUtil.showPublishedLotto(lottos);
    }
}