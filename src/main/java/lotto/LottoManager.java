package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.WinningCondition;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;

public class LottoManager {
    public static final int NUMBER_OF_LOTTO_NUMBER = 6;
    public static final int THOUSAND = 1000;
    private final Input input = new Input();
    private final Output output = new Output();

    public List<Lotto> purchaseLottoTickets() {
        output.printEnteringAmountPrompt();
        int purchasedAmount = input.readTotalPurchasedAmount();
        int purchasedQuantity = purchasedAmount / 1000;

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchasedQuantity; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    public Lotto generateLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, NUMBER_OF_LOTTO_NUMBER);
        return new Lotto(numbers);
    }

    public void printLottoTickets(List<Lotto> tickets) {
        output.printPurchasedLottoTickets(tickets);
    }

    public void checkMyWinning() {
        List<Integer> winningNumbers = this.getWinningNumbers();
        int bonusNumber = this.getBonusNumber();
    }

    private List<Integer> getWinningNumbers() {
        output.printLottoWinningNumbersPrompt();
        return input.readWinningNumbers();
    }

    public int getBonusNumber() {
        output.printLottoBonusNumberPrompt();
        return input.readBonusNumber();
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
}
