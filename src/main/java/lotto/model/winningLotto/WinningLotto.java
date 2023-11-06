package lotto.model.winningLotto;


import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoDTO;
import lotto.model.WinningInfo;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    private WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningNumber, int bonusNumber) {
        return new WinningLotto(winningNumber, bonusNumber);
    }

    public WinningLottoDTO toWinningLottoDTO() {
        return WinningLottoDTO.of(winningNumber, bonusNumber);
    }

    public WinningInfo compare(LottoDTO lottoDTO) {
        List<Integer> lottoNumbers = lottoDTO.numbers();
        List<Integer> winningNumbers = winningNumber.toLottoDTO().numbers();

        long matchedCount = countMatchedNumbers(lottoNumbers, winningNumbers);
        boolean isBonusMatched = isBonusNumberMatched(lottoNumbers);

        return WinningInfo.of((int) matchedCount, isBonusMatched);
    }

    private static long countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusNumberMatched(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
