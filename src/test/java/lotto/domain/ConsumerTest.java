package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsumerTest {
    Consumer consumer;

    @BeforeEach
    void setUp(){
        consumer = new Consumer();
    }

    @DisplayName("구매 금액을 저장한다.")
    @Test
    void savePurchaseAmount() {
        //When
        consumer.setPurchaseAmount(5000);
        //Then
        assertThat(consumer.getPurchaseAmount()).isEqualTo(5000);
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void savePurchaseAmountByNotDivided() {
        assertThatThrownBy(() -> consumer.amountValidate(5001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("구매한 로또들을 저장한다.")
    @Test
    void saveLottos() {
        //Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6))
        );
        //When
        consumer.setLottos(lottos);
        //Then
        assertThat(consumer.getLottos()).isEqualTo(lottos);
    }
}
