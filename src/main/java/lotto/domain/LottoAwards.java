package lotto.domain;

public class LottoAwards {
    private Member member;
    private WinningNumber winningNumber;

    public LottoAwards(final Member member, final WinningNumber winningNumber) {
        this.member = member;
        this.winningNumber = winningNumber;
    }


}
