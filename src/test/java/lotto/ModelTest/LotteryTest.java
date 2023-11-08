package lotto.ModelTest;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoConstant;
import lotto.Lottery;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("구입할 Lotto의 개수가 정확한지 확인합니다.")
    @Test
    void checkCreatedLotteryNumberOfTicket() {
        Lottery lottery = new Lottery(8000);
        assertThat(lottery.getNumberOfLotto() == 8);
    }

    @DisplayName("numberOfLotto만큼의 Lotto 객체를 만들어내는지 확인합니다.")
    @Test
    void numberOfPickedLotto()
    {
        Lottery lottery = new Lottery(8000);
        assertThat(lottery.getLotto().size() == lottery.getNumberOfLotto());
    }

    @DisplayName("pickUniqueNumbersInRange가 적절한 개수와 범위의 수를 반환하는지 확인합니다.")
    @Test
    void validatePickUniqueNumbersInRangeMethod()
    {
        assertThat(Randoms.pickUniqueNumbersInRange(LottoConstant.MINIMUM_NUMBER,
                        LottoConstant.MAXIMUM_NUMBER, 40)
                .stream()
                .filter(i -> i>=LottoConstant.MINIMUM_NUMBER && i<=LottoConstant.MAXIMUM_NUMBER)
                .collect(Collectors.toList())
                .size() == 40);
    }
}