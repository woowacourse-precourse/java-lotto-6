package lotto.impl;

import lotto.RandomNumberProvider;
import lotto.domain.Lotto;
import lotto.type.Prize;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.impl.RandomNumberImpl.BONUS_NUMBER_INDEX;

public class LottoGame {
    private Lotto winningLotto;
    private int bonusNumber;
    private final RandomNumberProvider randomNumberProvider;

    public LottoGame(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    public void start(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Prize getPrize(Lotto consumerLotto) {
       List<Integer> lottoNumbers = consumerLotto.getNumbers();
       int winningResult = getWinningResult(lottoNumbers);
       if(isCheckSecond(winningResult)) {
           return Prize.valueOf(winningResult, true);
       }
        return Prize.valueOf(winningResult, false);
    }

    public List<Prize> getResult(List<Lotto> consumerLottos) {
        return consumerLottos.stream()
                 .map(this::getPrize)
                 .collect(Collectors.toList());
    }

    private boolean isCheckSecond(int correctNum) {
        return correctNum == BONUS_NUMBER_INDEX;
    }


    private int getWinningResult(List<Integer> lottoNumbers) {
        return winningLotto.getMatchingNumber(IntStream.range(0, BONUS_NUMBER_INDEX - 1)
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
