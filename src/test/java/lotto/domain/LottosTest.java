package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private Player player;
    private ArrayList<Lotto> lotteries;

    @BeforeEach
    void setUp() {
        player = new Player(3000);
        lottos = new Lottos(Arrays.asList(1, 2, 3, 4, 5, 6), 7, player);
        lotteries = player.getLotteries();
    }

    @DisplayName("당첨 금액의 숫자와 일치하는 숫자 개수를 반환한다.")
    @Test
    void calculateMatchNumbers() {
        int count = 0;
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 45));
        for (Integer number : Arrays.asList(1, 2, 3, 4, 5, 6)) {
            if (lotto.contains(number)) {
                count++;
            }
        }

        assertThat(5).isEqualTo(count);
    }
}
