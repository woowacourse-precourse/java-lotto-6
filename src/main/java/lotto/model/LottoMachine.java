package lotto.model;

public final class LottoMachine {
    private final WinningTicket winningTicket;
    private final LottoGroup lottoGroup;

    private LottoMachine(LottoGroup lottoGroup, WinningTicket winningTicket) {
        this.lottoGroup = lottoGroup;
        this.winningTicket = winningTicket;
    }

    public static LottoMachine of(LottoGroup lottoGroup, WinningTicket winningTicket) {
        return new LottoMachine(lottoGroup, winningTicket);
    }

    public TotalPrize calculateTotalPrize() {
        return lottoGroup.calculateTotalPrize(winningTicket);
    }
}
