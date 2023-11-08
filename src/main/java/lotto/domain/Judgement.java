package lotto.domain;

import lotto.dto.LottoResultDto;
import lotto.dto.WinningNumberDto;

import java.util.List;

public class Judgement {
    public Judgement() {
    }

    public LottoResultDto countLottoCorrectNumbers(Lotto userLotto, WinningNumberDto winningNumberDto) {
        int winningNumberCount = compareWinningNumberWithLotto(userLotto, winningNumberDto.getWinngingNumber());
        boolean isBonusNumberCorrect = compareBonusNumberWithLotto(userLotto, winningNumberDto.getBonusNumber());

        return new LottoResultDto(winningNumberCount,isBonusNumberCorrect);
    }

    private int compareWinningNumberWithLotto(Lotto userLotto, List<Integer> winningNumbers) {
        return (int) userLotto.getLottoNumbers().stream() //숫자의 범위가 0~6이므로 (int)로 형 변환 가능
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean compareBonusNumberWithLotto(Lotto userLotto, int bonusNumber) {
        return userLotto.getLottoNumbers().stream().anyMatch(number -> number == bonusNumber);
    }
}
