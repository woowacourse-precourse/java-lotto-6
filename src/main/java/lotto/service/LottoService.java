package lotto.service;

import lotto.model.Lotto;
import java.util.List;

/**
 * @Class : 로또 관리 서비스 클래스
 */
public class LottoService {

    public void start() {
        int amount = getAmount();

        List<Lotto> purchasedLottoList = buyLottos(amount);

        Lotto winnigLotto = getWinnigNumbers();

        int bonusNumber = getBonusNumber();

        printResult(purchasedLottoList, winnigLotto, bonusNumber);
    }

    private int getAmount() {
        LottoViewService.outputAmount();
        return LottoViewService.inputAmount();
    }

    private List<Lotto> buyLottos(int amount) {
        int lottoEa = getLottoEa(amount);
        List<Lotto> lottoList = createLotttos(lottoEa);
        LottoViewService.outputLottoList(lottoList);
        return lottoList;
    }

    private List<Lotto> createLotttos(int ea) {
        return null;
    }

    private int getLottoEa(int amount) {
        int ea = 0;
        LottoViewService.outputEa(ea);
        return ea;
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
