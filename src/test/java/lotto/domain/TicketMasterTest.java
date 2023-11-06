package lotto.service;

import lotto.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class TicketMasterTest {
    static TicketMaster tm;

    @BeforeEach
    void setUP() {
        this.tm = new TicketMaster();
        tm.setWinningNum(new Lotto(List.of(1,2,11,22,33,44)));
    }

    @DisplayName("보너스 번호 입력시 당첨번호와 중복되면 예외처리")
    @Test
    void creatBonusNumDuplicateWinningNumbers() {
        assertThatThrownBy(()->tm.setBonusNum(2)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 갯수를세는 기능")
    @Test
    void checkLotto_TEST() {
        Lotto newLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int result = tm.checkLotto(newLottoNumber);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("로또에 보너스 번호가 있는지 비교하는 기능")
    @Test
    void checkLottoBonusNum_TEST() {
        Lotto newLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        tm.setBonusNum(3);
        assertThat(tm.checkLottoBonus(newLottoNumber)).isEqualTo(true);
    }
}