package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;
import lotto.constant.ViewMessage;

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
        printYieldRate(purchaseQuantity, ranks);
    }

    private int getPurchaseQuantity() {
        int purchaseQuantity = 0;

        view.print(ViewMessage.ASK_PURCHASE_AMOUNT.getMessage());
        do {
            try {
                purchaseQuantity = controller.getPurchaseQuantity();
            } catch (NumberFormatException e) {
                view.print(ErrorMessage.NOT_A_NUMBER.getErrorMessage());
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.NOT_SEPARATED_1000.getErrorMessage());
            }
        } while (purchaseQuantity == 0);

        return purchaseQuantity;
    }

    private List<Lotto> getMyLottoNumber(int purchaseQuantity) {
        List<Lotto> myLotto = new ArrayList<>();
        List<Integer> numbers;
        List<Integer> sortedNumbers;

        view.printLine();
        view.print(view.getPrintPurchaseAmount(purchaseQuantity));
        for (int i = 0; i < purchaseQuantity; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortedNumbers = sortedByAsc(numbers);
            myLotto.add(new Lotto(sortedNumbers));

            view.print(view.getPrintPurchaseNumber(myLotto.get(i)));
        }

        return myLotto;
    }

    private Lotto readWinningNumber() {
        Lotto lotto = null;

        view.printLine();
        view.print(ViewMessage.ASK_WINNING_NUMBER.getMessage());
        do {
            try {
                lotto = new Lotto(controller.readWinningNumber());
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.INVALID_WINNING_NUMBER.getErrorMessage());
            }
        } while (lotto == null);

        return lotto;
    }

    private int readBonusNumber(Lotto winningLotto) {
        int bonusNumber;

        view.printLine();
        view.print(ViewMessage.ASK_BONUS_NUMBER.getMessage());
        do {
            try {
                bonusNumber = controller.readBonusNumber();
                validateBonusNumber(bonusNumber, winningLotto);
            } catch (IllegalArgumentException e) {
                view.print(ErrorMessage.INVALID_BONUS_NUMBER.getErrorMessage());
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
        view.printLine();
        view.print(ViewMessage.PRINT_WINNING_STAT.getMessage());
        for (Rank rank : ranks) {
            if (rank.getHits() == -1) continue;
            view.print(view.getPrintMatches(rank));
        }
    }

    private void printYieldRate(int purchaseQuantity, Rank[] ranks) {
        double sum = 0;
        double yieldRate;

        for (Rank rank : ranks) {
            sum += rank.getPrize() * (double)rank.getMatchCount();
        }
        yieldRate = sum / ((double)purchaseQuantity * 10);
        view.print(view.getPrintYieldRate(yieldRate));
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

    private List<Integer> sortedByAsc(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
