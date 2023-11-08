package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.AppConfig;
import lotto.Lotto;
import lotto.model.GameMoney;
import lotto.model.WinLotto;
import lotto.model.WinLottoPlaceCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class CountWinLottoImplTest {


    AppConfig appConfig = new AppConfig();
    GetMyLottos getMyLottos = appConfig.getMyLottos();
    GetWinLotto getWinLotto = appConfig.getWinLotto();
    CountWinLotto countWinLotto =appConfig.countWinLotto();

    List<Lotto> lottos = new ArrayList<>();
    GameMoney gameMoney = new GameMoney(8000);

    @Mock
    private Randoms randoms;

    @BeforeEach
    void setMyLotto(){

        assertTimeoutPreemptively(Duration.ofSeconds(10L), () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(() -> randoms.pickUniqueNumbersInRange(anyInt(),anyInt(),anyInt())).
                        thenReturn(List.of(8, 21, 23, 41, 42, 43), //2등
                                List.of(3, 5, 11, 21, 41, 38), // 5등
                                List.of(8,11,21,23,41,42), // 1등
                                List.of(8,11,21,25,41,42), // 3등
                                List.of(7, 11, 21, 41, 42, 44), //4등
                                List.of(3, 8, 16, 21, 23, 42), //4등
                                List.of(2, 7, 16, 35, 38, 44),
                                List.of(7, 11, 15, 29, 31, 44)

                        );
                lottos.addAll(getMyLottos.getMyLottos(gameMoney));
            }
        });
    }

    @Test
    void 이긴_게임_횟수(){
        Lotto winNumber = getWinLotto.validWinNumber("8,11,21,23,41,42");
        int bonusNum= getWinLotto.validBonusNumber("43",winNumber);
        WinLotto winLotto = new WinLotto(winNumber,bonusNum);
        //WinLotto winLotto = getWinLotto.validWinLotto("8,11,21,23,41,42","43");
        WinLottoPlaceCount winLottoPlaceCount = countWinLotto.lottoPlaceCount(winLotto,lottos);
        Assertions.assertThat(winLottoPlaceCount.getWinLottoPlaceCount()).containsExactly(2,1,2,1,1,1);
    }

    @Test
    void 수익률_계산(){
        Lotto winNumber = getWinLotto.validWinNumber("8,11,21,23,41,42");
        int bonusNum= getWinLotto.validBonusNumber("43",winNumber);
        WinLotto winLotto = new WinLotto(winNumber,bonusNum);
        //WinLotto winLotto = getWinLotto.validWinLotto("8,11,21,23,41,42","43");
        WinLottoPlaceCount winLottoPlaceCount = countWinLotto.lottoPlaceCount(winLotto,lottos);
        double rate = countWinLotto.getRateMoney(winLottoPlaceCount,gameMoney);

        Assertions.assertThat(rate).isEqualTo(25395062.5);
        String formattedNumber = String.format("%.1f", rate);
        System.out.println("formattedNumber = " + formattedNumber);
    }


}
