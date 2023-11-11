package service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Lotto;
import domain.LottoResult;
import domain.UserLotto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultServiceTest extends NsTest {

    private LottoResultService lottoResultService;

    private List<Lotto> lottoList;
    private UserLotto userLotto;

    @BeforeEach
    void initLottoResultService(){
        lottoResultService = new LottoResultService();
    }

    @BeforeEach
    void initLottoList(){
        Lotto lotto1 = new Lotto(List.of(3,4,5,6,7,8));
        Lotto lotto2 = new Lotto(List.of(23,33,35,12,5,1));
        Lotto lotto3 = new Lotto(List.of(33,44,35,26,9,28));
        Lotto lotto4 = new Lotto(List.of(13,9,2,19,45,1));

        lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);
        lottoList.add(lotto4);
    }

    @BeforeEach
    void initUserLotto(){
        userLotto = new UserLotto("10000");
        userLotto.setInputLotto("33,44,35,26,9,28");
        userLotto.setInputBonusLotto("1");
    }


    @Test
    @DisplayName("10000원 로또 구매 > 로또 3등-1개, 1등-1개  > 당첨의 수익률은 20,000,050.000%")
    @Override
    protected void runMain() {
        //given: @BeforeEach

        //when
        LottoResult lottoResult = lottoResultService.getLottoResultStatistic(lottoList,userLotto);

        //then
        assertThat(lottoResult.getProfitRate()).isEqualTo(new BigDecimal("20000050.0"));
    }
}
