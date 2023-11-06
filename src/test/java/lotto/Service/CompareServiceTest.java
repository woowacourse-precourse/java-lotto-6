package lotto.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoResults;
import lotto.dto.WinnerAndBonusNumber;
import lotto.model.BonusNumber;
import lotto.model.CompareResult;
import lotto.model.Lotto;
import lotto.model.WinnerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareServiceTest {
    private final CompareService compareService;

    CompareServiceTest() {
        compareService = new CompareService();
    }

    @DisplayName("로또 번호와 당첨번호 & 보너스 번호 비교")
    @Test
    void calculateMatchingTest() {
        //given
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(winnerNumber, 7);
        List<Lotto> lottos = createLottos();

        WinnerAndBonusNumber winnerAndBonusNumber = new WinnerAndBonusNumber(winnerNumber, bonusNumber);
        LottoResults lottoResults = new LottoResults(lottos);

        //when
        List<CompareResult> statistics = compareService.calculateMatching(lottoResults.getLottos(),
                winnerAndBonusNumber.getWinnerNumber(), winnerAndBonusNumber.getBonusNumber());

        //then
        List<CompareResult> collect = statistics.stream().filter(st -> st.getMatchCount() == 3)
                .collect(Collectors.toList());
        assertEquals(collect.size(), 1);
        assertEquals(collect.get(0).isMatchBonus(), false);
    }

    private static List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        return lottos;
    }


}