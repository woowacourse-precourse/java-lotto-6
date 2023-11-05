package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoPlay implements Play{
    private final Controller controller = new Controller();
    private final View view = new View();

    @Override
    public void start() {
        int purchaseQuantity = getPurchaseQuantity();
        List<Lotto> myLotto = getMyLottoNumber(purchaseQuantity);
        Lotto winningLotto = readWinningNumber();
        int bonusNumber = readBonusNumber(winningLotto);
        Rank[] ranks = getWinningStat(myLotto, winningLotto, bonusNumber);
        printWinningStat(ranks);
        printYieldRate();
    }

    private int getPurchaseQuantity() {
        int purchaseQuantity = 0;

        System.out.print(view.getAskPurchaseAmount());
        do {
            try {
                purchaseQuantity = controller.getPurchaseQuantity();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getErrorMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_SEPARATED_1000.getErrorMessage());
            }
        } while (purchaseQuantity == 0);

        return purchaseQuantity;
    }

    private List<Lotto> getMyLottoNumber(int purchaseQuantity) {
        List<Lotto> myLotto = new ArrayList<>();
        List<Integer> numbers;

        System.out.println();
        System.out.print(view.getPrintPurchaseAmount(purchaseQuantity));
        for (int i = 0; i < purchaseQuantity; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLotto.add(new Lotto(numbers));

            System.out.print(view.getPrintPurchaseNumber(myLotto.get(i)));
        }

        return myLotto;
    }

    private Lotto readWinningNumber() {
        Lotto lotto = null;

        System.out.println();
        System.out.print(view.getAskWinningNumber());
        do {
            try {
                lotto = new Lotto(controller.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_WINNING_NUMBER.getErrorMessage());
            }
        } while (lotto == null);

        return lotto;
    }

    private int readBonusNumber(Lotto winningLotto) {
        int bonusNumber;

        System.out.println();
        System.out.print(view.getAskBonusNumber());
        do {
            try {
                bonusNumber = controller.readBonusNumber();
                validateBonusNumber(bonusNumber, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_BONUS_NUMBER.getErrorMessage());
                bonusNumber = 0;
            }
        } while (bonusNumber == 0);

        return bonusNumber;
    }

    private Rank[] getWinningStat(List<Lotto> myLottos, Lotto winningLotto, int bonusNumber) {
        int hits;
        boolean isMatchBonusNumber = false;
        Rank[] ranks = Rank.values();
        for (Lotto myLotto : myLottos) {
            hits = getRank(myLotto, winningLotto);
            if (hits == 5) {
                isMatchBonusNumber = getMatchBonusNumber(winningLotto, bonusNumber);
            }
            ranks[Rank.findRank(hits, isMatchBonusNumber).ordinal()].increaseMatchCount();
        }

        return ranks;
    }

    private void printWinningStat(Rank[] ranks) {
        System.out.println();
        System.out.print(view.getPrintWinningStat());
        for (Rank rank : ranks) {
            if (rank.getHits() == -1) continue;
            System.out.print(view.getPrintMatches(rank));
        }
    }

    private void printYieldRate() {

    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.getLottoNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private int getRank(Lotto myLotto, Lotto winningLotto) {
        int hits = 0;

        for (int myLottoNumber : myLotto.getLottoNumber()) {
            if (winningLotto.getLottoNumber().contains(myLottoNumber)) {
                hits++;
            }
        }

        return hits;
    }

    private boolean getMatchBonusNumber(Lotto winningLotto, int bonusNumber) {
        return winningLotto.getLottoNumber().contains(bonusNumber);
    }
}
