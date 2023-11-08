package lotto;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import lotto.generator.LottoGenerator;
import lotto.shop.LottoShop;
import lotto.validate.Validate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
    private Validate validate;
    private final int LOTTO_PRICE = 1000;

    @BeforeEach
    public void setUp() {
        validate = new Validate();
    }

    @Test
    public void 금액_입력_시_로또_발행() {
        // Given: 로또 발행 숫자 값을 고정
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);
        when(lottoGenerator.getLotto()).thenReturn(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int money = 10000;

        // When: LottoShop 객체의 buyLotto 메서드 실행
        LottoShop lottoShop = new LottoShop(lottoGenerator, validate);
        List<Lotto> lottos = lottoShop.buyLotto(money);

        // THen: 10000원 입력시, 10개의 lotto 발행
        int expectedSize = 10;

        assertEquals(expectedSize, lottos.size());
    }

    @Test
    public void 로또_가격으로_나누어_떨어지지_않는_금액_입력() {
        // Given: 로또 발행 숫자 값을 고정
        LottoGenerator lottoGenerator = mock(LottoGenerator.class);
        when(lottoGenerator.getLotto()).thenReturn(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        int money = 8500;

        LottoShop lottoShop = new LottoShop(lottoGenerator, validate);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> lottoShop.buyLotto(money));
    }
}
