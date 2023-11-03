package lotto.service;


import lotto.domain.Customer;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;
class TicketMasterTest {
    @DisplayName("Customer의 coin/1000개의 로또를 생성한다.")
    @Test
    void sellLotto_TEST() {
        Customer cs = new Customer(4000);
        TicketMaster.makeTicket(cs);
        assertThat(cs.customerLotto.size()).isEqualTo(4);
    }

    @DisplayName("보너스 번호 입력시 당첨번호와 중복되면 예외처리")
    @Test
    void creatBonusNumDuplicateWinningNumbers() {
        TicketMaster.setWinningNum(new Lotto(List.of(1,2,11,22,33,44)));
        assertThatThrownBy(()->TicketMaster.setBonusNum(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 갯수를 확인할 수 있어야 한다.")
    @Test
    void checkLotto_TEST() {
        Customer cs = new Customer(1000);
        cs.customLotto = new Lotto(List.of(java.util.List.of(1, 2, 3, 4, 5, 6, 7)));
        TicketMaster.setWinningNum(new Lotto(List.of(1,2,11,22,33,44)));
        TicketMaster.setBonusNum(3);
        int result = TicketMaster.checkLotto(cs);
        assertThat(result).isEqualTo(3);
    }

}