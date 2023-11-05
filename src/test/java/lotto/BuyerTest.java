package lotto;

import lotto.domain.Lotto;
import lotto.domain.buyer.model.Buyer;
import lotto.domain.buyer.service.BuyerService;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class BuyerTest {

    @Test
    @DisplayName("로또 구매 금액은 1000원 단위로 입력되어야 한다.")
    void buyTest() {

        BuyerService buyerService = new BuyerService();

        String[] tMoney = {"1000", "2020", "0", "-2000", "   ", "money"};

        for(int i=1; i<tMoney.length; i++) {

            int testIdx = i;
            assertThatThrownBy(() -> buyerService.buy(tMoney[testIdx]))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("구매자는 복권 위원회에게 당첨 결과 조회를 요청할 수 있음")
    void checkTest() {

        Buyer testBuyer = new Buyer();
        List<Lotto> testLottos = new ArrayList<>();
        testLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        testLottos.add(new Lotto(List.of(5, 6, 7, 8, 9, 10)));
        testBuyer.setLottos(testLottos);

        assertThat(testBuyer.tryCheck()).isInstanceOf(HashMap.class);
    }


}
