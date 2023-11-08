package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import lotto.service.StatLottoService;
import lotto.service.UserLottoService;
import lotto.validator.NumberValidator;
import lotto.domain.Lotto;
import lotto.domain.Stat;
import lotto.domain.User;
import lotto.domain.Stat.Reward;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또를 천원 단위로 구매했다면 알맞은 구매 개수가 저장된다.")
    @Test
    void payPurchaseAmount() {
        UserLottoService userLottoService = new UserLottoService();
        int purchaseAmount = userLottoService.createLottoCount(7000);
        assertEquals(purchaseAmount, 7);
    }

    @DisplayName("로또 구매 개수에 따라 알맞은 개수의 로또가 생성된다.")
    @Test
    void generateLottoByPurchaseAmount() {
        UserLottoService userLottoService = new UserLottoService();
        int purchase = 6000;
        int ticketCount = userLottoService.createLottoCount(purchase);

        User user = new User(ticketCount);
        user.setLotto();
        assertEquals(user.getLottoList().size(), 6);
    }

    @DisplayName("로또 번호의 범위가 벗어나면 예외가 발생한다.")
    @Test
    void outOfRangeLottoNumber() {
        int choiceNumbers = 46; // 로또 번호의 범위에서 벗어난 수
        IllegalArgumentException illegalException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.validateNumberRange(choiceNumbers));
        Assertions.assertEquals("[ERROR] 입력 값은 1~45사이입니다.", illegalException.getMessage());
    }

    @DisplayName("맞춘 개수에 따라 올바른 상금이 추가된다.")
    @Test
    void calculatePrizeMoneyByMatchingNumbers() {
        StatLottoService statLottoService = new StatLottoService();
        Stat stat = new Stat();
        Reward third = Reward.FIVE;
        statLottoService.addRewardToTotalReward(third, stat);
        assertEquals(stat.getReward(), 1_500_000);
    }
}