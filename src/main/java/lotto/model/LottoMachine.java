package lotto.model;

public final class LottoMachine {
    private final WinningCombination winningCombination;
    private final LottoGroup lottoGroup;

    private LottoMachine(LottoGroup lottoGroup, WinningCombination winningCombination) {
        this.lottoGroup = lottoGroup;
        this.winningCombination = winningCombination;
    }

    public static LottoMachine of(LottoGroup lottoGroup, WinningCombination winningCombination) {
        return new LottoMachine(lottoGroup, winningCombination);
    }

    public PrizeSummary generatePrizeSummary() {
        return lottoGroup.generatePrizeSummary(winningCombination);
    }
}
