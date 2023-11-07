package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoTicketManagerTest {

    private final LottoTicketManager lottoTicketManager = new LottoTicketManager();

    @Test
    @DisplayName("금액에 맞는 번호 갯수 반환 ")
    public void 금액에_맞는_로또_개수_테스트() {
        assertEquals(1234,lottoTicketManager.countTickets("1234000"));
    }

    @Test
    @DisplayName("보너스 번호에는 1 ~ 45 사이의 숫자만 입력할 수 있다.")
    void 보너스_번호_범위_예외_테스트(){
        Assertions.assertThatThrownBy(()->lottoTicketManager.getBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에는 당첨 번호와 중복 입력할 수 없다.")
    void 보너스_번호_중복_예외_테스트(){
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(1,2,3,4,5,6)));
        Assertions.assertThatThrownBy(()->lottoTicketManager.getBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}