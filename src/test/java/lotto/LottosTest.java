package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.LottosResult;
import org.junit.jupiter.api.Test;

public class LottosTest extends NsTest {
    private Lottos lottos;

    @Test
    public void buyLottosTest() {
        lottos = new Lottos();
        int ticketAmount = 5;
        assertThat(lottos.buyLottoByTicketAmount(ticketAmount).size()).isEqualTo(ticketAmount);
    }

    private List<List<Integer>> arr;
    @Test
    public void buy8LottosPickedNumberTest() {
        lottos = new Lottos();
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run();
                    assertThat(arr.toString()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
    @Override
    protected void runMain() {
        List<Lotto> re = lottos.buyLottoByTicketAmount(8);
        arr = new ArrayList<>();
        re.forEach(i->arr.add(i.getNumbersForMessage()));
    }
    @Test
    public void lottosMatchUpResult() {
        lottos = setUP();
        Lotto answerLotto = new Lotto(List.of(1, 2, 5, 17, 22, 45));
        int bonusNumber = 3;
        LottosResult lottosResult = new LottosResult(List.of(LottoResult.FOUR_MATCHES,LottoResult.SIX_MATCHES));
        assertThat(lottos.matchUp(answerLotto,bonusNumber)).isEqualTo(lottosResult);
    }

    @Test
    public void lottosMatchUpResultMessage() {
        lottos = setUP();
        Lotto answerLotto = new Lotto(List.of(1, 2, 5, 17, 22, 45));
        int bonusNumber = 3;

        LottosResult results= lottos.matchUp(answerLotto,bonusNumber);
        EnumMap<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
        resultCounts.put(LottoResult.FOUR_MATCHES,1);
        resultCounts.put(LottoResult.SIX_MATCHES,1);

        assertThat(results.getResultCounts()).isEqualTo(resultCounts);
    }
    public Lottos setUP(){
        List<Lotto>  userLottos = new ArrayList<>();

        List<Integer> lotto1 = List.of(1, 3, 5, 14, 22, 45);
        List<Integer> lotto2 = List.of(1, 2, 5, 17, 22, 45);
        userLottos.add(new Lotto(lotto1));
        userLottos.add(new Lotto(lotto2));
        return new Lottos(userLottos);
    }
}
