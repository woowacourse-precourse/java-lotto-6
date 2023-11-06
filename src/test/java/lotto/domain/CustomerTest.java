package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void init() {
        this.customer = new Customer("3000");
    }

    @DisplayName("글자를 입력하거나 터무니 없는 값을 입력하면 예외가 발생한다.")
    @Test
    void createCustomerByNotNumber() {
        assertThatThrownBy(() -> new Customer("테스트"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원부터 최대 100,000원까지의 금액을 입력해주세요.");
    }

    @DisplayName("로또 구매 금액이 100,000원을 넘어선 안 된다.")
    @Test
    void createCustomerByOverRange() {
        assertThatThrownBy(() -> new Customer("106000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원부터 최대 100,000원까지의 금액을 입력해주세요.");
    }

    @DisplayName("로또 구매 금액이 1000원보다 적어선 안 된다.")
    @Test
    void createCustomerByUnderRange() {
        assertThatThrownBy(() -> new Customer("200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원부터 최대 100,000원까지의 금액을 입력해주세요.");
    }

    @DisplayName("로또 구매 금액은 1000원 단위가 아니면 안 된다.")
    @Test
    void createCustomerByNotThousandUnit() {
        assertThatThrownBy(() -> new Customer("3400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("로또 구매 금액에 따라 구입 가능한 로또 숫자를 반환한다.")
    @Test
    void possibleBuyLottoByCashInHand() {
        int result = customer.calculateLottoNum();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구매 가능한 갯수만큼 실제로 로또를 구매한다.")
    @Test
    void buyLottoByCashInHand() {
        customer.buyNewLotto();

        List<Lotto> allLotto = customer.getAllLotto();

        assertThat(allLotto.size()).isEqualTo(3);
    }

    @DisplayName("보유한 로또 번호들을 출력 요구 사항에 맞춘 문자열로 바꾸어 리스트로 반환한다.")
    @Test
    void getLottoTextsByList() {
        customer.buyNewLotto();

        List<String> texts = customer.getLottoTexts();

        assertThat(texts.size()).isEqualTo(3);
    }

    @DisplayName("최종 수익률을 계산해 반환한다.")
    @Test
    void getRevenueRatio() {
        Double result = customer.calculateRevenueRatio(10000.0);

        assertThat(result).isEqualTo(333.3);
    }
}