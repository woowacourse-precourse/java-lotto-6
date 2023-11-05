package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.constant.LottoPrice;
import lotto.service.MessageService;

public class LottoResult {
    private final MessageService messageService = new MessageService();
    private final LottoWinningNumbers lottoWinningNumbers;
    private LottoCount lottoCount = new LottoCount();
    private static final int BONUS_CHECK_COUNT = 10;

    public LottoResult(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public LottoCount getLottoStatus(List<Lotto> purchaseLottoNumber) {
        for (Lotto purchaseNumber : purchaseLottoNumber) {
            List<Integer> lottoNumbers = purchaseNumber.getNumbers();
            int matchCount = bonusNumberCheck(getLottoMatchCount(lottoNumbers), lottoNumbers);
            lottoCount = getCount(matchCount);
        }
        outputLottoResult(lottoCount);
        return lottoCount;
    }

    private int getLottoMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoWinningNumbers.getWinningNumber().stream()
                .filter(number -> lottoNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private LottoCount getCount(int matchCount) {
        if (matchCount == LottoPrice.FIRST.getNumber()) {
            lottoCount.addSixCount();
        }
        if (matchCount == LottoPrice.SECOND.getNumber()) {
            lottoCount.addFiveWithBonusCount();
        }
        if (matchCount == LottoPrice.THIRD.getNumber()) {
            lottoCount.addFiveCount();
        }
        if (matchCount == LottoPrice.FOURTH.getNumber()) {
            lottoCount.addFourCount();
        }
        if (matchCount == LottoPrice.FIFTH.getNumber()) {
            lottoCount.addThreeCount();
        }
        return lottoCount;
    }

    private void outputLottoResult(LottoCount lottoCount) {
        messageService.outputLottoStatus(LottoPrice.FIFTH.getNumber(), LottoPrice.FIFTH.FormatPrice(),
                lottoCount.getThreeCount());
        messageService.outputLottoStatus(LottoPrice.FOURTH.getNumber(), LottoPrice.FOURTH.FormatPrice(),
                lottoCount.getFourCount());
        messageService.outputLottoStatus(LottoPrice.THIRD.getNumber(), LottoPrice.THIRD.FormatPrice(),
                lottoCount.getFiveCount());
        messageService.outputLottoWithBonusStatus(LottoPrice.SECOND.getNumber(), LottoPrice.SECOND.FormatPrice(),
                lottoCount.getFiveWithBonusCount());
        messageService.outputLottoStatus(LottoPrice.FIRST.getNumber(), LottoPrice.FIRST.FormatPrice(),
                lottoCount.getSixCount());
    }

    private int bonusNumberCheck(int matchCount, List<Integer> lottoNumbers) {
        if (matchCount == LottoPrice.THIRD.getNumber() && lottoNumbers.contains(lottoWinningNumbers.getBonusNumber())) {
            return matchCount + BONUS_CHECK_COUNT;
        }
        return matchCount;
    }


}
