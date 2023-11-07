package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.service.LottoService;
import lotto.service.RankService;
import org.junit.jupiter.api.BeforeEach;

public class RankServiceTest {

    RankService rankService;

    @BeforeEach
    void setUp() {
        User user = new User(5, createFakeLottos());
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        int bonusNumber = 7;
        rankService = new RankService(user, winningNumbers, bonusNumber);
    }


    private List<Lotto> createFakeLottos() {
        return Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9))
        );
    }
}
