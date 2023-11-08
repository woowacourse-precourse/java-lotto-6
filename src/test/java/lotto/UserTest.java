package lotto;

import lotto.domain.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void setRanksTest() {

        List<Integer> matchedNumbers = List.of(1, 2, 3, 4, 5, 6);
        User user = new User(matchedNumbers);

        user.setRanks(false);

        assertEquals(2001555000, user.totalPrize);
    }

    @Test
    void getProfitPercentageTest() {
        List<Integer> matchedNumbers = List.of(0,0,0,0,0, 6);
        User user = new User(matchedNumbers);

        user.setRanks(true);

        float profitPercentage = user.getProfitPercentage(1000);
        assertEquals(200000000.0f, profitPercentage);
    }
}
