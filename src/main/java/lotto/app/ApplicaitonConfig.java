package lotto.app;

import lotto.domain.LotteryMachine;
import lotto.domain.Merchant;

public class ApplicaitonConfig {

    public static Merchant getMerchant() {
        return Merchant.of();
    }

    public static LotteryMachine getMachine() {
        return LotteryMachine.of();
    }

}
