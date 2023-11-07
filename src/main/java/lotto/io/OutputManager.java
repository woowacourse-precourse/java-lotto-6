package lotto.io;

import lotto.game.Lotto;
import lotto.enums.CommonMessage;
import lotto.enums.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputManager {

    private OutputManager() {}

    private static class SingletonHelper{
        private final static OutputManager outputManager = new OutputManager();
    }

    public static OutputManager getInstance() {
        return SingletonHelper.outputManager;
    }

    public void printPurchaseMsg() {
        System.out.println(CommonMessage.READ_PURCHASE_MSG.message());
    }

    public void printWinningNumberMsg() {
        System.out.println(CommonMessage.READ_LOTTO_NUMBER_MSG.message());
    }

    public void printBonusNumberMsg() {
        System.out.println(CommonMessage.READ_BONUS_NUMBER_MSG.message());
    }

    public void printLottoListMsg(List<Lotto> lottos) {
        String msg = CommonMessage.generateLottoListMsg(lottos);
        System.out.println(msg);
    }

    public void printLottoResultMsg(Map<LottoRank, Integer> lottoRanks) {
        String msg = CommonMessage.generateLottoResultMsg(lottoRanks);
        System.out.println(msg);
    }

    public void printBenefitRateMsg(double benefitRate) {
        String msg = CommonMessage.generateBenefitRateMsg(benefitRate);
        System.out.println(msg);
    }
}
