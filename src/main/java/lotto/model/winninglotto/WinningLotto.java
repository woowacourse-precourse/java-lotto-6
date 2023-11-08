package lotto.model.winninglotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRanking;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;
    private final HitCounter hitCounter;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
        this.hitCounter = createHitCounter(winningLotto, bonusLottoNumber);
    }

    public static WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberNotDuplicated(winningNumbers, bonusNumber);
        Lotto winningLotto = Lotto.issueChooseNumbersLotto(winningNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        return new WinningLotto(winningLotto, bonusLottoNumber);
    }

    public LottoWinningResult getLottoResult(List<Lotto> lottoTicket) {
        List<LottoRanking> lottoRankings = lottoTicket.stream()
            .map(Lotto::getLottoNumbers)
            .map(this::checkRanking)
            .toList();
        return new LottoWinningResult(lottoRankings);
    }

    private static void validateBonusNumberNotDuplicated(List<Integer> winningNumbers,
        int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private HitCounter createHitCounter(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        List<Integer> winningNumbers = winningLotto.getLottoNumbers()
            .stream()
            .map(LottoNumber::number)
            .collect(Collectors.toList());

        return new HitCounter(winningNumbers, bonusLottoNumber.number());
    }

    private LottoRanking checkRanking(List<LottoNumber> lottoNumbers) {
        List<Integer> numbers = lottoNumbers.stream()
            .map(LottoNumber::number)
            .toList();
        HitResult hitResult = hitCounter.countHit(numbers);
        return LottoRanking.getRanking(hitResult.hitCount(), hitResult.isBonusBallHit());
    }
}
