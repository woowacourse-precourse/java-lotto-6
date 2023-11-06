package service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Lotto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameServiceTest {

    private LottoGameService lottoGameService;

    @BeforeEach
    void init(){
        lottoGameService = new LottoGameService();
    }

    @DisplayName("구매한 로또 당첨 번호 리스트는 null 이 아니다.")
    @Test
    void notNullLottoListTest() {
        // given
        int lottoCount = 15000;

        // when
        List<Lotto> lottoList = getLottoList(lottoCount);

        //then
        assertThat(lottoList).isNotNull();
    }

    @DisplayName("10개의 로또 구매를 구매할 경우 size 는 10이다.")
    @Test
    void purchasedLottoCountTest() {
        // given
        int lottoCount = 10;

        // when
        List<Lotto> lottoList = getLottoList(lottoCount);

        //then
        assertThat(lottoList.size()).isEqualTo(10);
    }

    private List<Lotto> getLottoList(int lottoCount){
        return lottoGameService.getLottoList(lottoCount);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 false")
    @Test
    void purchaseLottoTest() {
        // given
        String purchasedAmount = "13500";

        // when
        boolean isUserLotto = lottoGameService.isGetUserLotto(purchasedAmount);

        //then
        assertThat(isUserLotto).isFalse();
    }

}
