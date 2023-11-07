package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.NumberRule;
import lotto.domain.Lotto;
import lotto.domain.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class SellerTest {
    private static final String ERROR_MESSAGE_HEADER = Error.ERROR_HEADER.getMessage();
    private static final int LOTTO_PRICE = NumberRule.LOTTO_PRICE.getNumber();

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumberAmountInput() {
        String userInput = "1000원";
        invalidInputAmountTest(
                userInput,
                ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요."
        );
    }

    @DisplayName("입력한 구매 금액이 1000원 미만이면 예외가 발생한다,")
    @Test
    void lessThanLottoPrice() {
        String userInput = "0";
        invalidInputAmountTest(
                userInput,
                ERROR_MESSAGE_HEADER + " " + LOTTO_PRICE + " 이상의 수를 입력하세요."
        );
    }

    @DisplayName("입력한 구매 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void notDividedByLottoPrice() {
        String userInput = "1500";
        invalidInputAmountTest(
                userInput,
                ERROR_MESSAGE_HEADER + " " + LOTTO_PRICE + "단위 이상으로 입력하세요."
        );
    }

    @DisplayName("구매 금액에 맞는 갯수의 자동 로또를 생성한다.")
    @Test
    void giveValidCountOfLotteryToUser() {
        String validUserInput = "1000";
        Lotto validLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .thenReturn(List.of(1, 2, 3, 4, 5, 6));
            Seller seller = new Seller();
            seller.setAmount(validUserInput);
            int validAmount = seller.getAmount();
            List<Lotto> lotteries = seller.giveLotto();

            assertThat(lotteries.size()).isEqualTo(validAmount / LOTTO_PRICE);
            assertThat(lotteries.get(0).getNumbers()).isEqualTo(validLotto.getNumbers());
        }
    }

    private void invalidInputAmountTest(String userInput, String errorMessage) {
        Seller seller = new Seller();
        assertThatThrownBy(() -> seller.setAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}
