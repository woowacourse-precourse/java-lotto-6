package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameServiceTest {
    LottoGameService lottoGameService;
    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", " ", "20a0", "aA"})
    void containLottoPurchaseAmountNonDigit(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0원일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "000"})
    void inputZeroValue(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2500", "500"})
    void createPurchaseAmountNotDividedByThousand(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}