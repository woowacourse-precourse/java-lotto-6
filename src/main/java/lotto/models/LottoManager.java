package lotto.models;

import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final int lottoAmount;
    private final List<Lotto> lottos = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final WinningNumber winningNumber;

    public LottoManager(int lottoAmount, WinningNumber winningNumber) {
        this.lottoAmount = lottoAmount;
        this.winningNumber = winningNumber;

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(randomNumberGenerator.generateRandomLottoNumbers()));
        }
    }

}
