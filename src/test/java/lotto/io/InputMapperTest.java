package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.WinningGrade;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningDetails;
import lotto.domain.WinningNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

@DisplayName("입력값을 매핑해주는 클래스에")
class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @DisplayName("구매 금액 도메인으로 변환 요청시 객체를 반환한다.")
    @Test
    void toPurchaseAmount() {
        // given
        final String input = "3000";

        // when
        final PurchaseAmount purchaseAmount = inputMapper.toPurchaseAmount(input);

        // then
        assertThat(purchaseAmount.toValue()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("당첨 번호 도메인으로 변환 요청시 객체를 반환한다.")
    @Test
    void toWinningNumbers() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final String input = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));

        // when
        final WinningNumbers result = inputMapper.toWinningNumbers(input);

        // then
        final WinningDetails winningDetails =
                result.compare(new Lottos(List.of(new Lotto(numbers))));
        assertThat(winningDetails.toWinningResult().numOfWinningGrade(WinningGrade.FIRST_GRADE))
                .isOne();
    }

    @DisplayName("보너스 번호 도메인으로 변환 요청시 객체를 반환한다.")
    @Test
    void toBonusNumber() {
        // given
        final int expected = 1;
        final String input = String.valueOf(expected);

        // when
        final BonusNumber bonusNumber = inputMapper.toBonusNumber(input);

        // then
        assertThat(bonusNumber.toValue()).isEqualTo(expected);
    }
}
