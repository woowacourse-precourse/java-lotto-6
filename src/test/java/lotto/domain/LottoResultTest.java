package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6),7);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(4,5,6,7,8,9)));
        lottos.add(new Lotto(List.of(2,3,4,5,6,7)));
        lottoResult = new LottoResult(lottos, winningLotto);
    }

    @Test
    @DisplayName("로또 결과에 따라 형식에 맞추어 문자열을 생성하는 기능 테스트")
    void getFormalizedResultTest(){
        //when
        List<String> result = lottoResult.getFormalizedResult();
        //then
        assertThat(result).isEqualTo(List.of("3개 일치 (5,000원) - 1개",
                                                "4개 일치 (50,000원) - 0개",
                                                "5개 일치 (1,500,000원) - 0개",
                                                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                                                "6개 일치 (2,000,000,000원) - 0개"));
    }

    @Test
    @DisplayName("로또 결과에 따른 획득 금액을 반환하는 기능 테스트")
    void getTotalReturnTest(){
        //when
        Long totalReturn = lottoResult.getTotalReturn();
        //then
        assertThat(totalReturn).isEqualTo(30005000);
    }
}