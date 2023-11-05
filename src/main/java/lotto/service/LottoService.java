package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.service.view.InputViewService;
import lotto.service.view.OutputViewService;

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
        OutputViewService.outputAmount();
        try {
            return InputViewService.inputAmount(LOTTO_PRICE);
        } catch (IllegalArgumentException e) {
            OutputViewService.outPutErrorMessage(e);
            return getAmount();
        }
    }

    private List<Lotto> issueLottoTicket(int amount) {
        LottoMachine lottoMachine = new LottoMachine(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        OutputViewService.outputEa(lottoList.size());
        OutputViewService.outputLottoList(lottoList);
        return lottoList;
    }

    private Lotto getWinnigNumbers() {
        OutputViewService.outputWinnigNumbers();
        try {
            return InputViewService.inputWinnigNumbers(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        } catch (IllegalArgumentException e) {
            OutputViewService.outPutErrorMessage(e);
            return getWinnigNumbers();
        }
    }

    private int getBonusNumber() {
        return InputViewService.inputBonusNumber();
    }

    private void printResult(List<Lotto> purchasedLottoList, Lotto winnigLotto, int bonusNumber) {
        OutputViewService.outputStatistics();
        OutputViewService.outputRateOfReturn();
    }

}
