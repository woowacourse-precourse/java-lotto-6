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
import java.util.List;

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


}
