package lotto.controller;

import java.util.List;
import lotto.dto.LottoResults;
import lotto.dto.WinnerAndBonusNumber;
import lotto.model.CompareResult;
import lotto.service.CompareService;

public class CompareController {
    private final CompareService compareService;

    public CompareController(CompareService compareService) {
        this.compareService = compareService;
    }

    public List<CompareResult> compareNumber(LottoResults lottoResults, WinnerAndBonusNumber winnerAndBonusNumber) {
        // 당첨 번호 & 로또 번호 비교
        return compareService.calculateMatching(lottoResults.getLottos(), winnerAndBonusNumber.getWinnerNumber(),
                winnerAndBonusNumber.getBonusNumber());
    }
}
