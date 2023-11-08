package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

public class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 22000, 43000})
    void 로또_생성_갯수_테스트(int budgetPrice) {
        Lottos lottos = Lottos.createLottos(createBudget(budgetPrice));

        Assertions.assertThat(lottos.getLottosSize())
                .isEqualTo(budgetPrice / 1000);
    }

    @Test
    void 로또_출력_테스트() {
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())).willReturn(List.of(6, 5, 4, 3, 2, 1));

            Assertions.assertThat(Lottos.createLottos(new Budget(1000)).toString())
                    .contains("[1, 2, 3, 4, 5, 6]");
        }
    }

    @Test
    void 로또_여러개_출력_테스트() {
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(6, 5, 4, 3, 2, 1), List.of(45, 44, 43, 42, 41, 40));

            Assertions.assertThat(Lottos.createLottos(new Budget(2000)).toString())
                    .contains("[1, 2, 3, 4, 5, 6]\n[40, 41, 42, 43, 44, 45]");
        }
    }

    @Test
    void 로또_1등_2등() {
        List<Lotto> initialLottos = new ArrayList<>();
        initialLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        initialLottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));

        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"1", "2", "3", "4", "5", "6"});
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(new WinningNumber(7), winningNumbers);

        Lottos lottos = new Lottos(initialLottos);
        WinningScores winningScores = lottos.calWinningScores(winningNumbers, bonusNumber);

        Assertions.assertThat(winningScores.toString())
                .contains("3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 1개" +
                        "\n6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 로또_미당첨() {
        List<Lotto> initialLottos = new ArrayList<>();
        initialLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        initialLottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));

        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers(new String[]{"40", "41", "42", "43", "44", "45"});
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(new WinningNumber(7), winningNumbers);

        Lottos lottos = new Lottos(initialLottos);
        WinningScores winningScores = lottos.calWinningScores(winningNumbers, bonusNumber);

        Assertions.assertThat(winningScores.toString())
                .contains("3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" +
                        "\n6개 일치 (2,000,000,000원) - 0개");
    }

    private Budget createBudget(int budgetPrice) {
        return new Budget(budgetPrice);
    }
}
