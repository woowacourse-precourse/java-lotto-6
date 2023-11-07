package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
        assertThatThrownBy(() -> consumer.setPurchaseAmount(5001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("구매한 로또들을 저장한다.")
    @Test
    void saveLottos() {
        //Given
        consumer.setPurchaseAmount(2000);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6))
        );
        //When
        consumer.setLottos(lottos);
        //Then
        assertThat(consumer.getLottos()).isEqualTo(lottos);
    }

    @DisplayName("저장할 로또의 개수가 구매 금액에 해당하는 로또 개수 보다 작다면 예외가 발생한다. ")
    @Test
    void saveLottosByOverCount() {
        //Given
        consumer.setPurchaseAmount(2000);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6))
        );
        //When & Then
        assertThatThrownBy(() -> consumer.setLottos(lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 개수가 구매한 개수와 일치하지 않습니다.");
    }

    @DisplayName("저장할 로또의 개수가 구매 금액에 해당하는 로또 개수 보다 크다면 예외가 발생한다. ")
    @Test
    void saveLottosByUnderCount() {
        //Given
        consumer.setPurchaseAmount(1000);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,6))
        );
        //When & Then
        assertThatThrownBy(() -> consumer.setLottos(lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또의 개수가 구매한 개수와 일치하지 않습니다.");
    }
}
