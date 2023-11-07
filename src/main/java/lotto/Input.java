package lotto;


import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Input {
    private final StringConverter stringConverter;
    private final InputView inputView;

    public Input() {
        this.stringConverter = new StringConverter();
        this.inputView = new InputView();
    }

    public int cost() {
        try {
            int cost = stringConverter.covertToInteger(inputView.inputBuyingCost());
            return new Cost(cost).getQuantity();
        } catch (IllegalArgumentException e) {
            return cost();
        }
    }

    public Lotto winningNumberWithoutBonus() {
        try {
            List<Integer> winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
            return makeWinningLotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            return winningNumberWithoutBonus();
        }
    }

    public WinningLotto bonusNumber(Lotto winningLottoWithoutBonus) {
        try {
            int bonusNumber = stringConverter.covertToInteger(inputView.inputBonusNumber());
            return new WinningLotto(winningLottoWithoutBonus, bonusNumber);
        } catch (IllegalArgumentException e) {
            return bonusNumber(winningLottoWithoutBonus);
        }
    }

    private Lotto makeWinningLotto(List<Integer> winningNumbers) {
        try {
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            return winningNumberWithoutBonus();
        }
    }

}
