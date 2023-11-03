package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    public void 생성된_수가_6개인가() {
        //given
        WinningLotto winningLotto = new WinningLotto();

        //then
        assertEquals(6, winningLotto.size());
    }

    @Test
    public void 중복되지_않은_수를_반환하는가() {
        //given
        WinningLotto winningLotto = new WinningLotto();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        //when
        int size = (int)winningNumbers.stream()
                .distinct()
                .count();

        //then
        assertEquals(6, size);
    }

}
