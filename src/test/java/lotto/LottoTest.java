package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("입력한 금액을 통해 로또를 몇장 살 수 있는지 반환한다.")
    @Test
    void countTickets(){
        //given
        Player player = new Player();
        //when
        assertThat(16).isEqualTo(player.countTickets(16000));
        //then
    }

    @DisplayName("입력한 금액이 1000으로 나누어떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void countTicketsException(){
        //given
        Player player = new Player();
        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> player.countTickets(13500));

        assertThat(e.getMessage()).isEqualTo("[ERROR]1,000원 단위로만 입력가능합니다.");
    }

}