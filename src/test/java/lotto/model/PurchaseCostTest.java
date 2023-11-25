package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.message.ErrorMessage.NOT_MULTIPLE_OF_THOUSAND;
import static lotto.message.ErrorMessage.NOT_POSITIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseCostTest {

    @DisplayName("양수가 아니면  예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    public void isNegative(String input) throws Exception {

        assertThatThrownBy(() -> new PurchaseCost(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_POSITIVE.getMessage());
    }

    @DisplayName("1000의 배수가 아니면  예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009"})
    public void validateCanDivideThousand(String input) throws Exception {

        assertThatThrownBy(() -> new PurchaseCost(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    @DisplayName("lottoCount를 계산한다.")
    @ParameterizedTest
    @ValueSource(strings = {"13000"})
    public void calculateLottoCount(String input) throws Exception {

        PurchaseCost purchaseCost = new PurchaseCost(input);
        Assertions.assertThat(purchaseCost.calculateLottoCount()).isEqualTo(13);
    }

}