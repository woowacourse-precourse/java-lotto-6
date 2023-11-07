package lotto.model;

import lotto.model.Human;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HumanTest {
    private final int money = 3000;
    private final int count = 3;
    @DisplayName("구매 가격에 맞게 로또 티켓의 개수를 계산하는가?")
    @Test
    void human_구매한만큼_로또개수를_초기화() {
        Human human = new Human(money);
        assertThat(human.getCount()).isEqualTo(count);
    }
}
