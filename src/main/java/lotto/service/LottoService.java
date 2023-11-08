package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningDetails;
import lotto.domain.WinningCriteria;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private WinningDetails winningDetails;
    private PurchaseLottos purchaseLottos;
    private Lotto winningLottoNumbers;
    private BonusNumber bonusNumber;


    public void repeatPurchase(int Quantity) {

        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < Quantity; count++) {
            lottos.add(purchaseLotto());
        }

        this.purchaseLottos = new PurchaseLottos(lottos);
    }

    private Lotto purchaseLotto() {
        return new Lotto(pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT));
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos.getPurchaseLottos();
    }

    public void setWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = new Lotto(winningLottoNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber, winningLottoNumbers.getLotto());
    }

    public WinningDetails calculateWinningDetails() {

        winningDetails = new WinningDetails();

        for (Lotto lotto : purchaseLottos.getPurchaseLottos()) {
            calculateWinningLotto(lotto);
        }

        return winningDetails;
    }

    private void calculateWinningLotto(Lotto lotto) {

        int winningNumberCount = calculateWinningNumberCount(lotto);
        boolean bonusNumber = calculateBonusNumber(lotto);

        calculateWinningCount(winningNumberCount, bonusNumber);
    }

    private int calculateWinningNumberCount(Lotto lotto) {

        int winningNumberCount = 0;

        for (int number : lotto.getLotto()) {
            if(winningLottoNumbers.getLotto().contains(number)) {
                winningNumberCount++;
            }
        }

        return winningNumberCount;
    }

    private boolean calculateBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }

    private void calculateWinningCount(int winningNumberCount, boolean bonusNumber) {

        for(WinningCriteria winningCriteria : WinningCriteria.values()){

            if(winningNumberCount != winningCriteria.getNumberMatch()) continue;
            if(bonusNumber != winningCriteria.getBonusNumberMatch()) continue;

            winningDetails.increaseCount(winningCriteria.getRank());
        }
    }

}
