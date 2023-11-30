package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStoreTest {

    /*핵심 도메인 로직 -> 로또 판정 에 대한 테스트 입니다.*/
    @DisplayName("로또 결과에 대한 판정이 올바른지 확인한다.")
    @Test
    void checkJudgement() {
        //given
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(Arrays.asList(3,5,11,41,42,43));
        LottoWithBounusNumber testLotto = new LottoWithBounusNumber(lotto3, 7);
        LottoStore lottoStore = new LottoStore(Arrays.asList(lotto1, lotto2));
        //when
        lottoStore.judgeLotto(testLotto);
        //then
        assertThat(lottoStore.getWinCount()).usingDefaultComparator().isEqualTo(new int[] {0,0,0,0,0,2});
    }
}
