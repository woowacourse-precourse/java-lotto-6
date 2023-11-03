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

    public void purchaseUserLottos(int availableCounts) {
        this.purchasedLottos = lottoGenerator.generate(availableCounts);
    }

    public void determineWinningNumbers(List<Integer> inputWinningNumbers) {
        this.winningNumbers = new Lotto(inputWinningNumbers);
    }

    public void determineBonusNumber(int inputBonusNumber) {
        this.winningNumbers.contains(inputBonusNumber);
        this.bonusNumber = new LottoNumber(inputBonusNumber);
    }
}
