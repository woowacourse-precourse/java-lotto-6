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
