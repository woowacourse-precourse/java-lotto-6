package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameControllerTest extends NsTest {
    private static LottoGameController controller;

    @BeforeAll
    static void 초기_설정() {
        controller = new LottoGameController();
    }

    @DisplayName("로또구매 금액에 따른 수량 및 번호 반환(buy_unit=1000)")
    @Test
    void 로또_구매_결과_반환() {
        //given
        long buyCash = 5000;
        long buyAmountExpected = 5;

        List<Lotto> expectedLottos = new ArrayList<>();
        expectedLottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        expectedLottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        expectedLottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        expectedLottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        expectedLottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Lottos lottos = controller.purchaseLotto(buyCash);
                    assertThat(lottos.getLottoAmount()).isEqualTo(buyAmountExpected);

                    List<Lotto> lottoTickets = lottos.getLottoTickets();

                    for (int index = 0; index < lottoTickets.size(); index++) {
                        assertThat(lottoTickets.get(index).getNumbersMessage())
                                .isEqualTo(expectedLottos.get(index).getNumbersMessage());
                    }
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );

    }

    @DisplayName("입력한 로또 당첨번호 생성 로직")
    @Test
    void 당첨_로또_생성기능() {
        //given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto winningLotto = controller.generateWinningLotto(winningNumbers);

        //then
        assertThat(winningLotto.getNumbersMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        winningNumbers.forEach((number) -> assertThat(winningLotto.isContains(number)).isTrue());
    }

    @DisplayName("보너스 번호 검증기능 예외처리")
    @ParameterizedTest
    @ValueSource(longs = {-1, 46, 1, 3, 6})
    void 보너스번호_검증_기능_예외처리(long inputBonusNumber) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> controller.validateBonusNumber(winningLotto, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 로또들과 당첨번호 비교 및 등수 결과 반환 기능")
    @Test
    void 결과_계산_기능() {
        //given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bounsNumber = 7;

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bounsNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        Lottos userLottos = new Lottos(lottos);

        Map<Rank, Long> expected = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> expected.put(rank, 0L));
        expected.put(Rank.FIFTH, 1L);

        //when
        Result result = controller.getResult(userLottos, winningLotto);

        //then
        Arrays.stream(Rank.values())
                .forEach(rank -> assertThat(result.getProfit(rank)).isEqualTo(rank.getRankReward(expected.get(rank))));
    }

    @Override
    public void runMain() {

    }
}
