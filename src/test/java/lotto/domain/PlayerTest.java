package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
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
