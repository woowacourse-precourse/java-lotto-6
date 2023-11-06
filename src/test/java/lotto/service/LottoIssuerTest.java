package lotto.service;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuerTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행")
    @ParameterizedTest(name = "{displayName} : {0}")
    @MethodSource("parameterProvider")
    void checkBuy(PurchaseAmount purchaseAmount) {
        LottoIssuer lottoIssuer = LottoIssuer.of(purchaseAmount);
        assertThat(lottoIssuer.issueLotto().size())
                .isEqualTo(purchaseAmount.exchangeLottoTicket());
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(PurchaseAmount.of(1000)),
                Arguments.of(PurchaseAmount.of(5000)),
                Arguments.of(PurchaseAmount.of(100000))
        );
    }
}
