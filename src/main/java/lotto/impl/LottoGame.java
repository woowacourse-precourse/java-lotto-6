package lotto.impl;

import lotto.RandomNumberProvider;
import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.impl.OneTo45LottoNumberProvider.BONUS_NUMBER_INDEX;

public class LottoGame {
    private final Lotto winningNumber;
    private final int bonusNumber;
    private final RandomNumberProvider randomNumberProvider;

    public LottoGame(RandomNumberProvider randomNumberProvider, Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.randomNumberProvider = randomNumberProvider;
        this.bonusNumber = bonusNumber;
    }

    public int getResult(Lotto consumerLotto) {
       List<Integer> lottoNumbers = consumerLotto.getNumbers();
       int winningResult = getWinningResult(lottoNumbers);
       if(isCheckSecond(winningResult)) {
           if(getBonusNumberResult(lottoNumbers)) {
               return 6;
           }
       }
       return winningResult;
    }

    private boolean isCheckSecond(int correctNum) {
        return correctNum == BONUS_NUMBER_INDEX;
    }

    private int getWinningResult(List<Integer> lottoNumbers) {
        return winningNumber
                .getSixNumberWinningResult(IntStream.range(0, BONUS_NUMBER_INDEX - 1)
                        .mapToObj(lottoNumbers::get)
                        .toList());
    }

    private boolean getBonusNumberResult(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<Lotto> purchase(int purchaseNum) {
        return IntStream.range(0, purchaseNum)
                .mapToObj(index -> new Lotto(randomNumberProvider.generateRandomNumber()))
                .toList();
    }
}
