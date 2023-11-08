package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.constant.LottoConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoOrderTest {
    private LottoBundle lottoBundle;
    private Money money;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Lotto(IntStream
                        .rangeClosed(i, i + 5)
                        .boxed()
                        .toList()))
                .toList();
        lottoBundle = LottoBundle.from(lottos);
        money = Money.of("10000");
    }

    @DisplayName("정적 메소드 of를 통해 LottoOrder객체를 생성할 수 있다.")
    @Test
    void createLottoOrderTest() {
        LottoOrder lottoOrder = LottoOrder.of(money, lottoBundle);

        assertThat(lottoOrder).isNotNull();
    }

    @DisplayName("구매한 로또 수량을 확인할 수 있다.")
    @Test
    void getOrderQuantityTest() {
        LottoOrder lottoOrder = LottoOrder.of(money, lottoBundle);
        int orderQuantity = lottoOrder.getOrderQuantity(LottoConstant.PRICE.getValue());

        assertThat(orderQuantity).isEqualTo(10);
    }

    @DisplayName("구매한 로또 목록을 가져 올 수 있다.")
    @Test
    void getLottosTest() {
        LottoOrder lottoOrder = LottoOrder.of(money, lottoBundle);
        LottoBundle actualLottos = lottoOrder.getLottos();

        assertThat(actualLottos).isEqualTo(lottoBundle);
    }

}