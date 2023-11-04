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
    private static final double ZERO = 0;
    private static final double HUNDRED = 100;

    public LottoResult(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public void getLottoStatus(List<Lotto> purchaseLottoNumber) {
        for (Lotto purchaseNumber : purchaseLottoNumber) {
            List<Integer> lottoNumbers = purchaseNumber.getNumbers();
            int matchCount = BonusNumberCheck(getLottoMatchCount(lottoNumbers), lottoNumbers);
            lottoCount = getCount(matchCount);
        }
        outputLottoResult(lottoCount);
    }

    public void getLottoReturnRate(int purchasePrice) {
        int lottoReturn = getLottoReturn();
        if (lottoReturn == 0) {
            messageService.outputLottoReturnRate(ZERO);
            return;
        }
        double returnRate = (double) (lottoReturn - purchasePrice) / purchasePrice * HUNDRED;
        messageService.outputLottoReturnRate(returnRate + HUNDRED);
    }

    private int getLottoReturn() {
        return (lottoCount.getSixCount() * LottoPrice.FIRST.getPrice()
                + lottoCount.getFiveWithBonusCount() * LottoPrice.SECOND.getPrice()
                + lottoCount.getFiveCount() * LottoPrice.THIRD.getPrice()
                + lottoCount.getFourCount() * LottoPrice.FOURTH.getPrice()
                + lottoCount.getThreeCount() * LottoPrice.FIFTH.getPrice());
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

    private int BonusNumberCheck(int matchCount, List<Integer> lottoNumbers) {
        if (matchCount == LottoPrice.THIRD.getNumber() && lottoNumbers.contains(lottoWinningNumbers.getBonusNumber())) {
            return matchCount + BONUS_CHECK_COUNT;
        }
        return matchCount;
    }


}
