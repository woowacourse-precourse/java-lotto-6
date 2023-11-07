package lotto.impl;

import lotto.RandomNumberProvider;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.type.Prize;

import java.io.PipedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoGame {
    private WinningLotto winningLotto;
    private final RandomNumberProvider randomNumberProvider;

    public LottoGame(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    public void start(WinningLotto inputLotto) {
        winningLotto = inputLotto;
    }

    public List<Lotto> purchase(int purchaseNum) {
        return IntStream.range(0, purchaseNum)
                .mapToObj(index -> new Lotto(randomNumberProvider.generateRandomNumber()))
                .toList();
    }

    public Prize getPrizeResult(Lotto inputLotto) {
        return winningLotto.matchLotto(inputLotto);
    }

    public List<Prize> getPrizeResults(List<Lotto> consumerLottos) {
        return consumerLottos.stream()
                 .map(this::getPrizeResult)
                 .collect(Collectors.toList());
    }


}
