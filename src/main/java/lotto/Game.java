package lotto;

import java.util.List;
import lotto.Validator.InputValidator;


public class Game {

    private Lotto winningLotto;

    public void askWinningNumbers() {
        while (true) {
            try {
                String input = InputService.askUserWinningGame();
                InputValidator.validateBlankString(input);
                String[] inputs = InputValidator.seperateStrings(input);
                List<Integer> numbers = InputValidator.getListOfIntegerByStrings(inputs);

                this.setWinningLotto(numbers);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }
}
