package lotto.dto;

import lotto.domain.BonusLotto;
import lotto.domain.GenerateLotteries;
import lotto.domain.Lotto;

public class AllLotteriesNumbersInfoDTO {
    private Lotto lotto;
    private BonusLotto bonusLotto;
    private GenerateLotteries generateLotteries;

    public AllLotteriesNumbersInfoDTO(Lotto lotto, BonusLotto bonusLotto, GenerateLotteries generateLotteries) {
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
        this.generateLotteries = generateLotteries;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusLotto getBonusLotto() {
        return bonusLotto;
    }

    public GenerateLotteries generateLotteries() {
        return generateLotteries;
    }
}
