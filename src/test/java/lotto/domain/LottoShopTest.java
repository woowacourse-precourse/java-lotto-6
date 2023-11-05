package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    private NumberGenerator numberGenerator;
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        numberGenerator = new TestRandomGenerator();
        lottoShop = new LottoShop(numberGenerator);
    }

    @ParameterizedTest
    @DisplayName("구매금액에 따른 로또 개수 확인 테스트")
    @ValueSource(ints = {1000, 2000, 3000})
    void createByBuyerLottoWithTestRandomGenerator(int price) {
        List<Lotto> buyerLotto = lottoShop.createByBuyerLotto(price);

        assertEquals(buyerLotto.size(), price / 1000);
    }
}




