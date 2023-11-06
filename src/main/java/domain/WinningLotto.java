package domain;

import domain.enums.LottoRank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public void validateBonusNumber(){
        if (winningNumbers.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public LottoRank match(Lotto ticket){
        long matchCount = ticket.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();

        boolean matchBonus = ticket.getNumbers().contains(bonusNumber);

        return LottoRank.valueOf((int) matchCount, matchBonus);
    }
}
