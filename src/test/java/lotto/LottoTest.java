package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.Profit;
import lotto.domain.WinningDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액에_맞는_로또갯수가_생성() {
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(5000);
        assertThat(lottoPurchaseInfo.getLottos().size()).isEqualTo(5);
    }

    @Test
    void 다섯가지의_당첨통계_생성() {
        Profit profit = new Profit();
        assertThat(profit.getWinningResult().size()).isEqualTo(5);
    }

    @Test
    void 해당하는_통계enum_갯수_증가() {
        Profit profit = new Profit();
        profit.addResult(WinningDetails.FOUR_MATCH);
        Map<WinningDetails, Integer> winningMap = profit.getWinningResult();
        assertThat(winningMap.get(WinningDetails.FOUR_MATCH)).isEqualTo(1);
    }

    @Test
    void 소수점_아래_둘째자리에서_반올림() {
        Profit profit = new Profit();
        assertThat(profit.matchDecimalPlace(35.5)).isEqualTo("35.5");
        assertThat(profit.matchDecimalPlace(33.54)).isEqualTo("33.5");
        assertThat(profit.matchDecimalPlace(35.55)).isEqualTo("35.6");
        assertThat(profit.matchDecimalPlace(0.00)).isEqualTo("0.0");
    }

}