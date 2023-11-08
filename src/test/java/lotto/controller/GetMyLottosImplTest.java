package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.AppConfig;
import lotto.Lotto;
import lotto.model.GameMoney;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class GetMyLottosImplTest {

    AppConfig appConfig = new AppConfig();
    GetMyLottos getMyLottos = appConfig.getMyLottos();

    @Mock
    private Randoms randoms;


    @Test
    void 로또_수령_테스트() {
        GameMoney gameMoney = new GameMoney(3000);

        List<Lotto> lottos = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).
                        thenReturn(List.of(8, 21, 23, 41, 42, 43),
                                List.of(3, 5, 11, 16, 32, 38),
                                List.of(7, 11, 16, 35, 36, 44)
                        );
                lottos.addAll(getMyLottos.getMyLottos(gameMoney));
            }
        });

        Assertions.assertThat(lottos.get(0).getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
        Assertions.assertThat(lottos.get(1).getNumbers()).containsExactly(3, 5, 11, 16, 32, 38);
        Assertions.assertThat(lottos.get(2).getNumbers()).containsExactly(7, 11, 16, 35, 36, 44);


    }

}
