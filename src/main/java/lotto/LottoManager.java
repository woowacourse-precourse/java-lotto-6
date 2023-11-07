package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.WinningCondition;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;

import static lotto.util.Repeater.tryOnceMoreIfException;
import static lotto.util.Validator.validateBonusNumberDuplicate;
import static lotto.util.Validator.validateRangeOfNumbers;

public class LottoManager {
    public static final int NUMBER_OF_LOTTO_NUMBER = 6;
    public static final int THOUSAND = 1000;
    private final Output output = new Output();

    public List<Lotto> purchaseLottoTickets() {
        output.printEnteringAmountPrompt();
        int purchasedAmount = tryOnceMoreIfException(Input::readTotalPurchasedAmount);
        int purchasedQuantity = purchasedAmount / THOUSAND;

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchasedQuantity; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    public Lotto generateLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, NUMBER_OF_LOTTO_NUMBER);
        return new Lotto(numbers.stream().sorted().toList());
    }

    public void printLottoTickets(List<Lotto> tickets) {
        output.printPurchasedLottoTickets(tickets);
    }

    public void checkMyWinning(List<Lotto> myTickets) {
        List<Integer> winningNumbers = this.getWinningNumbers();
        int bonusNumber = this.getBonusNumber();
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
        validateRangeOfNumbers(winningNumbers, bonusNumber);

        Map<WinningCondition, Integer> result = new HashMap<>();
        for (Lotto ticket : myTickets) {
            WinningCondition tmpResult = checkWinningResult(ticket, winningNumbers, bonusNumber);
            result.put(tmpResult, result.getOrDefault(tmpResult, 0) + 1);
        }
        output.printWinningStatistics(result);
        output.printWinningRoR(calculateRoR(result, myTickets.size() * THOUSAND));
    }

    private List<Integer> getWinningNumbers() {
        output.printLottoWinningNumbersPrompt();
        return tryOnceMoreIfException(Input::readWinningNumbers);
    }

    public int getBonusNumber() {
        output.printLottoBonusNumberPrompt();
        return tryOnceMoreIfException(Input::readBonusNumber);
    }

    public WinningCondition checkWinningResult(Lotto myLotto, List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> mySet = new HashSet<>(myLotto.getNumbers());
        Set<Integer> lottoSet = new HashSet<>(winningNumbers);

        mySet.retainAll(lottoSet);
        int matchedCount = mySet.size();

        if (matchedCount == 6) {
            return WinningCondition.SIX_MATCH;
        }
        if (matchedCount == 5 && myLotto.getNumbers().contains(bonusNumber)) {
            return WinningCondition.FIVE_MATCH_WITH_BONUS;
        }
        if (matchedCount == 5) {
            return WinningCondition.FIVE_MATCH;
        }
        if (matchedCount == 3) {
            return WinningCondition.THREE_MATCH;
        }
        if (matchedCount == 4) {
            return WinningCondition.FOUR_MATCH;
        }
        return WinningCondition.NOTHING;
    }

    public double calculateRoR(Map<WinningCondition, Integer> result, int purchasedAmount) {
        int totalAmount = 0;
        for (WinningCondition condition : WinningCondition.values()) {
            totalAmount += condition.getPrize() * result.getOrDefault(condition, 0);
        }
        double RoR = ((double) totalAmount / purchasedAmount) * 100;
        return RoR;
    }
}
