package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Winner;
import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int lottoNumberCount = 6;
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private List<Lotto> purchaseLotto = new ArrayList<>();
    private Winner winners;
    private Lotto winLotto;
    private Integer bonusNumber;

    public void repeatPurchase(int lottoCount) {
        for (int count = 0; count < lottoCount; count++) {
            generateLotto();
        }
    }

    public List<Lotto> getPurchaseLotto() {
        return this.purchaseLotto;
    }

    private void generateLotto() {

        Lotto lotto = new Lotto(pickUniqueNumbersInRange(startNumber, endNumber, lottoNumberCount));

        purchaseLotto.add(lotto);
    }

    public void setWinLotto(List<Integer> winLottoNumbers) {
        winLotto = new Lotto(winLottoNumbers);
    }

    public void setBonusNumber(int bonusNumber) {

        bonusNumberDuplicateCheck(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void bonusNumberDuplicateCheck(int bonusNumber) {
        if (winLotto.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    public void winStatistics() {

        winners = new Winner();

        for (Lotto lotto : purchaseLotto) {

            List<Integer> notMatchNumbers = lotto.getLotto();
            notMatchNumbers.removeAll(winLotto.getLotto());

            winFirstPlace(notMatchNumbers);
            winSecondOrThirdPlace(notMatchNumbers);
            winFourthPlace(notMatchNumbers);
            winFifthPlace(notMatchNumbers);
        }

    }

    private void winFirstPlace(List<Integer> notMatchNumbers) {
        if (notMatchNumbers.size() == lottoNumberCount - SIX_MATCH) {
            winners.increase1stPlace();
        }
    }

    private void winSecondOrThirdPlace(List<Integer> notMatchNumbers) {
        if (notMatchNumbers.size() == lottoNumberCount - FIVE_MATCH) {
            checkBonusNumber(notMatchNumbers);
        }
    }

    private void checkBonusNumber(List<Integer> notMatchNumbers) {

        if (notMatchNumbers.contains(bonusNumber)) {
            winners.increase2ndPlace();
            return;
        }

        winners.increase3rdPlace();
    }

    private void winFourthPlace(List<Integer> notMatchNumbers) {
        if (notMatchNumbers.size() == lottoNumberCount - FOUR_MATCH) {
            winners.increase4thPlace();
        }
    }

    private void winFifthPlace(List<Integer> notMatchNumbers) {
        if (notMatchNumbers.size() == lottoNumberCount - THREE_MATCH) {
            winners.increase5thPlace();
        }
    }
}
