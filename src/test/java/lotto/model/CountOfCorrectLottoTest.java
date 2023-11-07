package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfCorrectLottoTest {
    // given
    private final Winning WINNING = Winning.BONUS;
    private final int COUNT = 1;
    private final CountOfCorrectLotto countOfCorrectLotto = new CountOfCorrectLotto(WINNING, COUNT);

    @Test
    public void testGetWinningRank(){
        // when
        int winningRank = countOfCorrectLotto.getWinningRank();
        // then
        assertEquals(Winning.BONUS.getRank(), winningRank);
    }

    @Test
    public void testGetWinningDescription(){
        // when
        String description = countOfCorrectLotto.getWinningDescription();
        // then
        assertEquals(Winning.BONUS.getDescription(), description);
    }

    @Test
    public void testGetWinningPrize(){
        // when
        Integer prize = countOfCorrectLotto.getWinningPrize();
        // then
        assertEquals(Winning.BONUS.getPrize(), prize);
    }

    @Test
    public void testGetCount(){
        // when
        int count = countOfCorrectLotto.getCount();
        // then
        assertEquals(COUNT, count);
    }
}
