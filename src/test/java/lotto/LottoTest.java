package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Constants;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 빈 입력이면 예외가 발생한다.")
    @Test
    void createLottoByEmptyNumber() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 50, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 음수면 예외가 발생한다.")
    @Test
    void createLottoByNaturalNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 소수면 예외가 발생한다.")
    @Test
    void createLottoByFloatNumber() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4.1,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotANumber() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,%,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 쉼표로 구분되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNoComma() {
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5#6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,3,4,5,,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validation.inputWinnerNumberExceptionCheck("1,2,,,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 빈 입력이면 예외가 발생한다.")
    @Test
    void inputMoneyByEmpty() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수면 예외가 발생한다.")
    @Test
    void inputMoneyByNotNaturalNumber() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 소수면 예외가 발생한다.")
    @Test
    void inputMoneyByFloatNumber() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck("1000.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputMoneyByNotANumber() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 Constants.MONEY_PER_TICKET 단위가 아니면 예외가 발생한다.")
    @Test
    void inputMoneyByNotMoneyperTicket() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 (Integer.MAX_VALUE - 8) * Constants.MONEY_PER_TICKET 보다 크면 예외가 발생한다.")
    @Test
    void inputMoneyByOverRange() {
        assertThatThrownBy(() -> Validation.inputMoneyExceptionCheck(Long.toString(Constants.MAX_MONEY.toLong() + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "1",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 빈 입력이면 예외가 발생한다.")
    @Test
    void inputBonusByEmpty() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputBonusByNotANumber() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "~",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 음수면 예외가 발생한다.")
    @Test
    void inputBonusByNegativeNumber() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "-7",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 소수면 예외가 발생한다.")
    @Test
    void inputBonusByFloatNumber() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "7.0",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void inputBonusByOverRange() {
        assertThatThrownBy(() -> {
            Validation.inputBonusNumberExceptionCheck(
                    "46",
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액으로 구매한 로또 갯수를 계산한다.")
    @Test
    void ticketsForMoney() {
        Control controller = new Control();
        assertThat(controller.ticketsForMoney(Constants.MONEY_PER_TICKET.toLong() * 1)).isEqualTo(1);
        assertThat(controller.ticketsForMoney(Constants.MONEY_PER_TICKET.toLong() * 10)).isEqualTo(10);
        assertThat(controller.ticketsForMoney(Constants.MONEY_PER_TICKET.toLong() * 100)).isEqualTo(100);
        assertThat(controller.ticketsForMoney(Constants.MONEY_PER_TICKET.toLong() * Constants.SAFE_ARRAY_SIZE.toLong()))
                .isEqualTo(Constants.MAX_MONEY.toLong() / Constants.MONEY_PER_TICKET.toLong());
    }

    @DisplayName("로또 갯수로 구매 금액을 계산한다.")
    @Test
    void moneyForTickets() {
        Control controller = new Control();
        assertThat(controller.moneyForTickets(1)).isEqualTo(Constants.MONEY_PER_TICKET.toLong() * 1);
        assertThat(controller.moneyForTickets(100)).isEqualTo(Constants.MONEY_PER_TICKET.toLong() * 100);
        assertThat(controller.moneyForTickets(Constants.SAFE_ARRAY_SIZE.toInt()))
                .isEqualTo(Constants.MONEY_PER_TICKET.toLong() * Constants.SAFE_ARRAY_SIZE.toLong());
    }

    @DisplayName("로또 번호 중 당첨 번호와 같은 숫자의 갯수를 계산한다.")
    @Test
    void compareTicket() {
        Control controller = new Control();
        Lotto winner = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(controller.compareTicket(winner, new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(SameNumber.SAME6);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(2, 3, 4, 5, 6, 7)))).isEqualTo(SameNumber.SAME5);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(3, 4, 5, 6, 7, 8)))).isEqualTo(SameNumber.SAME4);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(4, 5, 6, 7, 8, 9)))).isEqualTo(SameNumber.SAME3);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(5, 6, 7, 8, 9, 10)))).isEqualTo(SameNumber.SAME0);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(6, 7, 8, 9, 10, 11))))
                .isEqualTo(SameNumber.SAME0);
        assertThat(controller.compareTicket(winner, new Lotto(List.of(7, 8, 9, 10, 11, 12))))
                .isEqualTo(SameNumber.SAME0);
    }

    @DisplayName("로또 번호 중 보너스 번호의 여부를 확인한다.")
    @Test
    void compareBonusNumber() {
        Control controller = new Control();
        Lotto noBonusNumberTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto bonusNumberTicket = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Integer bonus = 7;
        assertThat(controller.compareBonus(noBonusNumberTicket, bonus)).isEqualTo(0);
        assertThat(controller.compareBonus(bonusNumberTicket, bonus)).isEqualTo(1);
    }

    @DisplayName("로또들의 당첨 여부를 확인한다.")
    @Test
    void getcompareResult() {
        Control controller = new Control();
        Lotto winnerTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;
        Lotto tickets[] = {
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8))
        };
        Map<SameNumber, Integer> expact = Map.of(
                SameNumber.SAME6, 1,
                SameNumber.SAME5BONUS, 1,
                SameNumber.SAME4, 2);
        assertThat(controller.getCompareResult(winnerTicket, bonus, tickets)).isEqualTo(expact);
    }
}