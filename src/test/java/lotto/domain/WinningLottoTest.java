package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class WinningLottoTest {

    private List<Integer> winningNumbers;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        winningLotto = new WinningLotto(winningNumbers);
    }

    @Test
    @DisplayName("입력된 당첨 번호가 올바르게 로또로 생성되는지 테스트")
    void create_Winning_Numbers() {
        Assertions.assertThat(winningLotto.getWinningNumbers()).isSameAs(winningNumbers);
    }
}