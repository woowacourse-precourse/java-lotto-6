package lotto.service;

import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();
    RandomUtils randomUtils = new RandomUtils();

    @DisplayName("구매 금액에 맞게 로또가 구입되는지 확인하기")
    @Test
    void buyLotto() {
        int lottoAmount = randomUtils.RandomNumber() * Value.LOTTO_TICKET_PRICE;
        lottoService.createUserLottos(lottoAmount);

        assertEquals(lottoService.getUserLottoCount(), lottoAmount/Value.LOTTO_TICKET_PRICE);
    }

}