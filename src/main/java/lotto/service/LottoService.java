package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseLottos;
import lotto.domain.Winner;
import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;
    private static final int FIRST_PLACE_PRIZE = 2000000000;
    private static final int SECOND_PLACE_PRIZE = 30000000;
    private static final int THIRD_PLACE_PRIZE = 1500000;
    private static final int FOURTH_PLACE_PRIZE = 50000;
    private static final int FIFTH_PLACE_PRIZE = 5000;

    private PurchaseLottos purchaseLottos;
    private Winner winners;
    private Lotto winLotto;
    private int bonusNumber;
    private float totalPrize = 0;

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

//    public void winStatistics() {
//
//        winners = new Winner();
//
//        for (Lotto lotto : purchaseLotto) {
//            int win = 0;
//            boolean bonus = false;
//            for (int number : lotto.getLotto()) {
//                if (winLotto.getLotto().contains(number)) {
//                    win++;
//                    continue;
//                }
//                if (number == bonusNumber) {
//                    bonus = true;
//                }
//            }
//
//            winFirstPlace(win);
//            winSecondOrThirdPlace(win, bonus);
//            winFourthPlace(win);
//            winFifthPlace(win);
//        }
//
//    }

    private void winFirstPlace(int win) {
        if (win == SIX_MATCH) {
            winners.increase1stPlace();
        }
    }

    private void winSecondOrThirdPlace(int win, boolean bonus) {
        if (win == FIVE_MATCH) {
            if (bonus) {
                winners.increase2ndPlace();
                return;
            }

            winners.increase3rdPlace();
        }
    }

    private void winFourthPlace(int win) {
        if (win == FOUR_MATCH) {
            winners.increase4thPlace();
        }
    }

    private void winFifthPlace(int win) {
        if (win == THREE_MATCH) {
            winners.increase5thPlace();
        }
    }

    public List<Integer> getWinStatistics() {
        List<Integer> placeCounts = new ArrayList<>();
        placeCounts.add(getFirstPlaceCount());
        placeCounts.add(getSecondPlaceCount());
        placeCounts.add(getThirdPlaceCount());
        placeCounts.add(getFourthPlaceCount());
        placeCounts.add(getFifthPlaceCount());

        return placeCounts;
    }

    private int getFirstPlaceCount() {
        totalPrize += winners.get1stPlace() * FIRST_PLACE_PRIZE;
        return winners.get1stPlace();
    }

    private int getSecondPlaceCount() {
        totalPrize += winners.get2ndPlace() * SECOND_PLACE_PRIZE;
        return winners.get2ndPlace();
    }

    private int getThirdPlaceCount() {
        totalPrize += winners.get3rdPlace() * THIRD_PLACE_PRIZE;
        return winners.get3rdPlace();
    }

    private int getFourthPlaceCount() {
        totalPrize += winners.get4thPlace() * FOURTH_PLACE_PRIZE;
        return winners.get4thPlace();
    }

    private int getFifthPlaceCount() {
        totalPrize += winners.get5thPlace() * FIFTH_PLACE_PRIZE;
        return winners.get5thPlace();
    }

    public float getRevenue(int purchasePrice) {
        return (totalPrize / purchasePrice) * 100;
    }
}
