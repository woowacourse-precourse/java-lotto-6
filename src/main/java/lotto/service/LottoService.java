package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoMachine;

import java.util.List;

/**
 * @Class : 로또 관리 서비스 클래스
 */
public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_STAT_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;


    public void start() {
        int amount = getAmount();

        List<Lotto> purchasedLottoList = issueLottoTicket(amount);

        Lotto winnigLotto = getWinnigNumbers();

        int bonusNumber = getBonusNumber();

        printResult(purchasedLottoList, winnigLotto, bonusNumber);
    }

    private int getAmount() {
        LottoViewService.outputAmount();
        try {
            return LottoViewService.inputAmount(LOTTO_PRICE);
        } catch (IllegalArgumentException e) {
            LottoViewService.outPutErrorMessage(e);
            return getAmount();
        }
    }

    private List<Lotto> issueLottoTicket(int amount) {
        LottoMachine lottoMachine = new LottoMachine(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        LottoViewService.outputEa(lottoList.size());
        LottoViewService.outputLottoList(lottoList);
        return lottoList;
    }

    private Lotto getWinnigNumbers() {
        return LottoViewService.inputWinnigNumbers();
    }

    private int getBonusNumber() {
        return LottoViewService.inputBonusNumber();
    }

    private void printResult(List<Lotto> purchasedLottoList, Lotto winnigLotto, int bonusNumber) {
        LottoViewService.outputStatistics();
        LottoViewService.outputRateOfReturn();
    }

}
