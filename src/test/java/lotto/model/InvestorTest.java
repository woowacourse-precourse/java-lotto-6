package lotto.model;

import static lotto.exception.ExceptionMessage.INVEST_MONEY_VALUE_EXCEPTION;
import static lotto.exception.ExceptionMessage.MONEY_REMAIN_EXCEPTION;
import static lotto.exception.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

public class InvestorTest {

    @Test
    @DisplayName("정상 생성 테스트")
    void createInvestorTest() {
        // given
        String investorInput = "5000";

        // when & then
        assertDoesNotThrow(() -> Investor.createDefault(investorInput));
    }

    @Test
    @DisplayName("로또 구입 테스트")
    void buyLottoTest() {
        // given
        String investorInput = "5000";
        Investor investor = Investor.createDefault(investorInput);
        Shop shop = Shop.withOrderedMoney(investor.getInvestMoney());

        // when
        List<Lotto> lottos = shop.createLottos();

        // then
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("금액 증가 정상 테스트")
    void addProfitTest() {
        // given
        String investorInput = "5000";
        Investor investor = Investor.createDefault(investorInput);

        // when
        investor.addProfitMoney(5000);

        // then
        assertThat(investor.calculateProfitRate()).isEqualTo(1.00);
    }

    @Nested
    @DisplayName("Investor 예외 테스트")
    class InvestorExceptionTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "   5  00 "})
        @NullAndEmptySource
        @DisplayName("null, 빈 문자, 일반 문자, 공백 포함 문자 입력 시 예외가 발생한다.")
        void notNumberInputInvestExceptionTest(final String investorInput) {
            // when & then
            assertThatThrownBy(() -> Investor.createDefault(investorInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("음수 입력 시 예외가 발생한다.")
        void negativeNumberInputInvestExceptionTest() {
            // given
            String investorInput = "-1200";

            // when & then
            assertThatThrownBy(() -> Investor.createDefault(investorInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEGATIVE_NUMBER_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("구입 금액이 1000원 미만일 시 예외가 발생한다.")
        void moneyLowerThanMinimum() {
            // given
            String moneyInput = "500";

            // when & then
            assertThatThrownBy(() -> Investor.createDefault(moneyInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVEST_MONEY_VALUE_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("추가 금액이 0 미만일 시 예외가 발생한다.")
        void addProfitNegativeExceptionTest() {
            // given
            String investorInput = "5000";
            Investor investor = Investor.createDefault(investorInput);

            // when & then
            assertThatThrownBy(() -> investor.addProfitMoney(-500)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NEGATIVE_NUMBER_EXCEPTION.getMessage());
        }

        @Test
        @DisplayName("금액이 나누어 떨어지지 않을 시 예외가 발생한다.")
        void remainExceptionTest() {
            // given
            String investorInput = "2390";

            // when & then
            assertThatThrownBy(() -> Investor.createDefault(investorInput)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(MONEY_REMAIN_EXCEPTION.getMessage());
        }
    }
}
