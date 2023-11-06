package lotto;

import static java.util.Collections.emptyList;

import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class InputService {
    private final StringConverter stringConverter;
    private final InputView inputView;

    public InputService() {
        this.stringConverter = new StringConverter();
        this.inputView = new InputView();
    }

    public Lotto winningNumbers() {
        List<Integer> winningNumbers = emptyList();
        Lotto winningLottoWithoutBonus;

        do {
            if (winningNumbers.equals(emptyList())) {
                winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
            }
            winningLottoWithoutBonus = new Lotto(winningNumbers);
        } while (!winningLottoWithoutBonus.isValid());

        return winningLottoWithoutBonus;
    }

    public int payMoney() {
        Cost cost;
        do {
            cost = new Cost(inputView.inputBuyingCost());
        } while (!cost.isValid());

        return cost.getQuantity();
    }
}
