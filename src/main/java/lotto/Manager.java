package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Manager {
    private final Input input = new Input();
    private final Output output = new Output();
    public static final int NUMBER_OF_LOTTO_NUMBER = 6;

    public void getAmountToPurchase() {
        output.printEnteringAmountPrompt();
        int purchasedAmount = input.readTotalPurchasedAmount();
    }

    public Lotto generateLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, NUMBER_OF_LOTTO_NUMBER);
        return new Lotto(numbers);
    }
}
