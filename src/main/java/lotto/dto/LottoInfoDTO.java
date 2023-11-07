package lotto.dto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class LottoInfoDTO {
    private final Lotto lotto;
    private Integer matchCount;
    private boolean matchBonus;
    public LottoInfoDTO(Lotto lotto) {
        this.lotto = lotto;
        this.matchCount = 0;
        this.matchBonus = false;
    }
    public Lotto getLotto() {
        return this.lotto;
    }
    public boolean isMatchBonus(BonusNumber bonusNumber) {
        this.matchBonus = this.contain(bonusNumber.bonusNumber());
        return this.matchBonus;
    }
    private boolean contain(Integer number) {
        return this.lotto.numbers().contains(number);
    }
    public Integer countMatch(Lotto winningLotto) {
        winningLotto.numbers().stream().filter(this::contain).forEach(number -> this.matchCount++);
        return this.matchCount;
    }
    public void resetMatchCount(){
        this.matchCount = 0;
    }
}
