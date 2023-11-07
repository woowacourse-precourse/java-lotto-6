package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("PuchaseLottos 도메인 클래스 로직 테스트")
class PurchaseLottosTest {

    @DisplayName("1000원으로 나눠떨어지지 않는 구매 금액의 예외처리 확인")
    @Test
    void 구매_금액_예외_테스트(){
        int hasRemainder = 1234;
        Assertions.assertThatThrownBy(() -> new PurchaseLottos(hasRemainder)).isInstanceOf(IllegalArgumentException.class);

        int hasRemainder2 = 12345;
        Assertions.assertThatThrownBy(() -> new PurchaseLottos(hasRemainder2)).isInstanceOf(IllegalArgumentException.class);

        int under1000Won = 567;
        Assertions.assertThatThrownBy(() -> new PurchaseLottos(under1000Won)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 로직 테스트1")
    @Test
    void 정상_로직_테스트1(){
        int amount = 8000;
        PurchaseLottos purchaseLottos = new PurchaseLottos(amount);

        Assertions.assertThat(purchaseLottos.geBuyingLottoNumbers().size()).isEqualTo(8); //8000원은 로또 8장이 있어야 함
    }

    @DisplayName("정상 로직 테스트2")
    @Test
    void 정상_로직_테스트2(){
        int amount = 123000;
        PurchaseLottos purchaseLottos = new PurchaseLottos(amount);

        Assertions.assertThat(purchaseLottos.geBuyingLottoNumbers().size()).isEqualTo(123); //8000원은 로또 8장이 있어야 함
    }

}