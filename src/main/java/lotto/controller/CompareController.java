package lotto.controller;

import java.util.List;
import lotto.Service.CompareService;
import lotto.dto.LottoResults;
import lotto.dto.WinnerAndBonusNumber;
import lotto.model.Statistics;

public class CompareController {
    private final CompareService compareService;

    public CompareController(CompareService compareService) {
        this.compareService = compareService;
    }

    public List<Statistics> compareNumber(LottoResults lottoResults, WinnerAndBonusNumber winnerAndBonusNumber) {
        // 당첨 번호 & 로또 번호 비교
        return compareService.calculateMatching(lottoResults.getLottos(), winnerAndBonusNumber.getWinnerNumber(),
                winnerAndBonusNumber.getBonusNumber());
    }
}
