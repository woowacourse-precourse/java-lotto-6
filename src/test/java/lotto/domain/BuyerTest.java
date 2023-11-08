package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @DisplayName("Buyer 객체 생성 테스트")
    @Test
    void Buyer_객체_생성_테스트() {
        int purchaseAmount = 1000;
        assertThat(Buyer.from(purchaseAmount)).isInstanceOf(Buyer.class);
    }

    @DisplayName("Buyer 객체 구매한 로또 리스트 초기값 반환 테스트")
    @Test
    void Buyer_구매한_로또_리스트_초기값_반환_테스트() {
        Buyer buyer = Buyer.from(1000);
        assertThat(buyer.getPurchasedLotto()).isEqualTo(new ArrayList<Lotto>());
    }

    @DisplayName("Buyer 객체 구매한 로또 리스트 초기값 반환 실패 테스트")
    @Test
    void Buyer_구매한_로또_리스트_초기값_반환_실패_테스트() {
        Buyer buyer = Buyer.from(1000);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(buyer.getPurchasedLotto()).isNotEqualTo(new ArrayList<Lotto>() {{
            add(lotto);
        }});
    }

    @DisplayName("Buyer 객체 로또 구매 테스트")
    @Test
    void Buyer_로또_구매_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Buyer buyer = Buyer.from(1000);
        buyer.buyLotto(lotto);
        assertThat(buyer.getPurchasedLotto()).contains(lotto);
    }

    @DisplayName("Buyer 객체 구매 금액 반환 테스트")
    @Test
    void Buyer_구매_금액_반환_테스트() {
        Buyer buyer = Buyer.from(1000);
        assertThat(buyer.getPurchaseAmount()).isEqualTo(1000);
    }

    @DisplayName("Buyer 객체 구매 금액 반환 실패 테스트")
    @Test
    void Buyer_구매_금액_반환_실패_테스트() {
        Buyer buyer = Buyer.from(1000);
        assertThat(buyer.getPurchaseAmount()).isNotEqualTo(1001);
    }

    @DisplayName("Buyer 객체 로또 등수 초기값 반환 테스트")
    @Test
    void Buyer_로또_등수_초기값_반환_테스트() {
        Buyer buyer = Buyer.from(1000);
        assertThat(buyer.getResultRank()).isEqualTo(new HashMap<Rank, Integer>() {{
            put(Rank.FIFTH, 0);
            put(Rank.FORTH, 0);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 0);
            put(Rank.FIRST, 0);
        }});
    }

    @DisplayName("Buyer 객체 로또 등수 초기값 반환 실패 테스트")
    @Test
    void Buyer_로또_등수_초기값_반환_실패_테스트() {
        Buyer buyer = Buyer.from(1000);
        assertThat(buyer.getResultRank()).isNotEqualTo(new HashMap<Rank, Integer>() {{
            put(Rank.FIFTH, 0);
            put(Rank.FORTH, 0);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 0);
            put(Rank.FIRST, 1);
        }});
    }

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외처리")
    @Test()
    void 구매_금액_숫자_아닌_경우_예외처리() {
        String inputPurchaseAmount = "1000j";
        assertThatThrownBy(() -> Validation.validateInputIsNumber(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000의 배수가 아닐 경우 예외처리")
    @Test
    void 구매_금액이_1000_배수_아닌_경우_예외처리() {
        int purchaseAmount = 1100;
        assertThatThrownBy(() -> Validation.validateDivisibleNumber(purchaseAmount, 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}