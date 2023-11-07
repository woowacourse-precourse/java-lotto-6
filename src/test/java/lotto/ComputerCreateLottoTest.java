package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerCreateLottoTest {

    private LottoController lottoController;

    @BeforeEach
    void after(){
        lottoController = LottoController.getInstance();
    }

    @Test
    void 금액_입력시_로또_번호_발행() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottoTickets1 = lottoController.setLottoBudget("3000");
                    List<Lotto> lottoTickets2 = new ArrayList<>();
                    ArrayList<Integer> number1 = new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43));
                    lottoTickets2.add(new Lotto(number1));
                    boolean isEqual = listsHaveSameElements(
                            lottoTickets1.get(0).getNumbers(),
                            lottoTickets2.get(0).getNumbers()
                    );
                    assertThat(isEqual)
                            .isEqualTo(true);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );

    }
    @Test
    void 정렬확인(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottoTickets = lottoController
                            .setLottoBudget("1000");
                    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(21, 8, 23, 41, 42, 43));
                    Lotto lotto = new Lotto(numbers);
                    boolean isEqual = lottoTickets.get(0).getNumbers().equals(lotto.getNumbers());
                    assertThat(isEqual)
                            .isEqualTo(true);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    public boolean listsHaveSameElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        return set1.equals(set2);
    }
}
