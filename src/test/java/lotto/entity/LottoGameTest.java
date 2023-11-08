package lotto.entity;

import static org.junit.jupiter.api.Assertions.*;


import lotto.dto.LottoGameDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
class LottoGameTest {
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame("5000");
        lottoGame.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    @DisplayName("올바르지 않은 금액 입력시 예외 발생")
    void throwsExceptionForInvalidBudget() {
        assertThrows(IllegalArgumentException.class, () -> new LottoGame("1100"));
        assertThrows(IllegalArgumentException.class, () -> new LottoGame("-1000"));
        assertThrows(IllegalArgumentException.class, () -> new LottoGame("abcd"));
    }

    @Test
    @DisplayName("로또 게임 금액 설정")
    void amountIsSetCorrectlyBasedOnBudget() {
        assertEquals(5, lottoGame.getAmount());
    }

    @Test
    @DisplayName("로또 생성이 정상적으로 동작하는지 확인")
    void lottoCreationWorksCorrectly() {
        List<List<Integer>> createdLottos = lottoGame.createLotto();
        assertEquals(5, createdLottos.size());
    }

}