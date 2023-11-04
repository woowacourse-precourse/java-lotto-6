package lotto.domain;


import java.util.List;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private Lottos purchasedLottos;
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void purchaseLottoNumbersOf(int availableCounts) {
        this.purchasedLottos = lottoGenerator.generate(availableCounts);
    }

    public void determineWinningNumbers(List<Integer> inputWinningNumbers) {
        this.winningNumbers = new Lotto(inputWinningNumbers);
    }

    public void determineBonusNumber(int inputBonusNumber) {
        winningNumbers.hasSameNumber(inputBonusNumber);
        this.bonusNumber = new LottoNumber(inputBonusNumber);
    }

    public RankResult calculateRank() {
        return this.purchasedLottos.determineRank(this.winningNumbers, this.bonusNumber);
    }
}
