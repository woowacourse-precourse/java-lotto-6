package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setCash1000은_1000을_입력한다() {
        Player player = new Player();
        player.setCash(1000);

        assertEquals(player.getCash(), 1000);
    }

    @Test
    void drawLotto는_번호_6개를_반환한다() {
        Player player = new Player(1000);
        player.drawLotto();
        assertEquals(player.getLottos().get(0).getNumbers().size(), 6);
    }

    @Test
    void 천_단위가_아니면_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Player(1200)).isInstanceOf(IllegalArgumentException.class);
    }
}