package lotto.model.winninglotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRanking;

public class WinningLotto {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 로또 번호에는 중복이 없어야 합니다. 다시 입력하세요.";

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
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
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private LottoRanking checkRanking(List<LottoNumber> lottoNumbers) {
        int hitCount = (int) lottoNumbers.stream()
            .filter(winningLotto.getLottoNumbers()::contains)
            .count();

        return LottoRanking.getRanking(hitCount, lottoNumbers.contains(bonusLottoNumber));
    }
}
