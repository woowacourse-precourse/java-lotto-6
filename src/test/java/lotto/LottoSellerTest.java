package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Number;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoSellerTest {
    private static final String ERROR_MESSAGE_HEADER = Error.ERROR_MESSAGE_HEADER.getMessage();
    private static final int LOTTO_PRICE = Number.LOTTO_PRICE.getNumber();

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumberAmountInput() {
        String userInput = "1000원";
        invalidInputAmountTest(
                userInput,
                ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요."
        );
    }

    @DisplayName("입력한 구매 금액이 0원이면 예외가 발생한다.")
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
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .thenReturn(List.of(1, 2, 3, 4, 5, 6));
            LottoSeller lottoSeller = new LottoSeller();
            lottoSeller.setAmount(validUserInput);
            int validAmount = lottoSeller.getAmount();
            List<Lotto> lotteries = lottoSeller.giveLotto();

            assertThat(lotteries.size()).isEqualTo(validAmount / LOTTO_PRICE);
            assertThat(lotteries.get(0).getNumbers()).isEqualTo(lotto.getNumbers());
        }
    }

    private void invalidInputAmountTest(String userInput, String errorMessage) {
        LottoSeller lottoSeller = new LottoSeller();
        assertThatThrownBy(() -> lottoSeller.setAmount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
}
