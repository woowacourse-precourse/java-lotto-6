package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {
    @Test
    @DisplayName("객체 생성에 성공한다.")
    public void testConsumerCreate() {
        // given
        List<Integer> userNumbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers2 = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber1 = 7;
        int bonusNumber2 = 8;

        // when
        Consumer consumer1 = new Consumer(userNumbers1, bonusNumber1);
        Consumer consumer2 = new Consumer(userNumbers2, bonusNumber2);

        // then
        assertEquals(consumer1.getUserNumbers().getLotto(), userNumbers1);
        assertEquals(consumer1.getBonusNumber(), bonusNumber1);

        assertEquals(consumer2.getUserNumbers().getLotto(), userNumbers2);
        assertEquals(consumer2.getBonusNumber(), bonusNumber2);
    }

    @Test
    @DisplayName("같은 숫자를 가진 Consumer 객체들은 동등하다")
    public void testEquals() {
        // given
        List<Integer> userNumbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber1 = 7;
        int bonusNumber2 = 7;

        Consumer consumer1 = new Consumer(userNumbers1, bonusNumber1);
        Consumer consumer2 = new Consumer(userNumbers2, bonusNumber2);

        // when&then
        assertTrue(consumer1.equals(consumer2));
    }

    @Test
    @DisplayName("다른 숫자를 가진 Consumer 객체들은 동등하지 않다")
    public void testNotEquals() {
        // given
        List<Integer> userNumbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers2 = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber1 = 7;
        int bonusNumber2 = 8;

        Consumer consumer1 = new Consumer(userNumbers1, bonusNumber1);
        Consumer consumer2 = new Consumer(userNumbers2, bonusNumber2);

        // when&then
        assertFalse(consumer1.equals(consumer2));
    }

    @Test
    @DisplayName("같은 숫자를 가진 Consumer 객체들의 해시코드는 동일하다")
    public void testHashCode() {
        // given
        List<Integer> userNumbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber1 = 7;
        int bonusNumber2 = 7;

        Consumer consumer1 = new Consumer(userNumbers1, bonusNumber1);
        Consumer consumer2 = new Consumer(userNumbers2, bonusNumber2);

        // when&then
        assertEquals(consumer1.hashCode(), consumer2.hashCode());
    }

    @Test
    @DisplayName("다른 숫자를 가진 Consumer 객체들의 해시코드는 다르다")
    public void testNotEqualHashCode() {
        // given
        List<Integer> userNumbers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers2 = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber1 = 7;
        int bonusNumber2 = 8;

        Consumer consumer1 = new Consumer(userNumbers1, bonusNumber1);
        Consumer consumer2 = new Consumer(userNumbers2, bonusNumber2);

        // when&then
        assertNotEquals(consumer1.hashCode(), consumer2.hashCode());
    }
}