package lotto.impl;

import lotto.Game;
import lotto.RandomNumberProvider;
import lotto.domain.Lotto;
import lotto.type.GameType;

import java.util.List;
import java.util.stream.IntStream;

public class oneTo45LottoGame implements Game {

    public static final int ONE_TO_45_NUMBER_COUNT = 6;
    public static final int BONUS_NUMBER_INDEX = 5;

    private final int LOTTO_ROUND;
    private Lotto winningNumber;
    private final RandomNumberProvider randomNumberProvider;

    public oneTo45LottoGame(int LOTTO_ROUND, RandomNumberProvider randomNumberProvider) {
        this.LOTTO_ROUND = LOTTO_ROUND;
        this.randomNumberProvider = randomNumberProvider;
    }

    @Override
    public void start() {
        generateWinningNumber();
    }

    @Override
    public boolean supports(GameType gameType) {
        return gameType == GameType.ONE_TO_FORTYFIVE_LOTTO_GAME;
    }

    public int getResult(Lotto consumerLotto) {
       List<Integer> lottoNumbers = consumerLotto.getNumbers();
       int fiveWinningNumberCount = winningNumber
               .getFiveNumberWinningResult(IntStream.range(0, BONUS_NUMBER_INDEX - 1)
               .mapToObj(lottoNumbers::get)
               .toList());

       int bonusWinningNumberCount = winningNumber
               .getBonusNumberWinningResult(consumerLotto.getBonusNumberWinningResult(lottoNumbers.get(BONUS_NUMBER_INDEX)));

       return fiveWinningNumberCount + bonusWinningNumberCount;
    }

    private void generateWinningNumber() {
        winningNumber = new Lotto(randomNumberProvider.generateRandomNumber());
    }
}
