package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
public class TicketPurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1100", "-1", "abc"})
    @DisplayName("올바르지 않은 금액")
    void failed(String input) {
        assertThatThrownBy(() -> new TicketPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 개수 구하기")
    void calculateLottoCount() {
        TicketPurchaseAmount amount = new TicketPurchaseAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6, 7, FIRST"
    })
    @DisplayName("1등 당첨 결과 반환")
    void shouldReturnCorrectPrize(int n1, int n2, int n3, int n4, int n5, int n6, int bn, Ranking expected) {

        // given
        Lotto lottoNumbers = new Lotto(List.of(n1, n2, n3, n4, n5, n6));
        BonusNumber bonusNumber = new BonusNumber(bn);
        prizeNumbers winningNumbers = new prizeNumbers(lottoNumbers, bonusNumber);

        // when
        Lotto myLotto = new Lotto(List.of(n1, n2, n3, n4, n5, n6));

        // then
        assertThat(winningNumbers.calculatePrize(myLotto)).isEqualTo(expected);
    }
}
