package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private WinningLotto winningLotto;
    private Money money;

    @BeforeEach
    @DisplayName("초기값 세팅")
    void setUp() {
        List<Lotto> userLottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12))
        );
        money = new Money("4000");

        user = new User(userLottoList.size(), new LottoTickets(userLottoList));

        winningLotto = new WinningLotto(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                new BonusNumber("7")
        );
    }

    @Test
    @DisplayName("초기 값을 바탕으로 올바른 등수가 나오는지 테스트")
    void testCompareWinningLotto() {
        user.compareWinningLotto(winningLotto);

        assertThat(WinningResult.FIRST.getCountResult()).isEqualTo(0);
        assertThat(WinningResult.SECOND.getCountResult()).isEqualTo(1);
        assertThat(WinningResult.THIRD.getCountResult()).isEqualTo(1);
        assertThat(WinningResult.FOURTH.getCountResult()).isEqualTo(1);
        assertThat(WinningResult.FIFTH.getCountResult()).isEqualTo(0);
    }
}
