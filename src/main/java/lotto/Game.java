package lotto;

import java.util.List;
import lotto.Validator.InputValidator;


public class Game {

    private Lotto winningLotto;
    private int bonusNumber;

    private int money;

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getMoney() {
        return this.money;
    }

    public void setWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setMoney(long money) {
        InputValidator.validateMoney(money);
        this.money = (int) money;
    }

    private void askWinningNumbers() {
        while (true) {
            try {
                String input = InputService.askUserWinningGame();
                InputValidator.validateBlankString(input);
                String[] inputs = InputValidator.seperateStrings(input);
                List<Integer> numbers = InputValidator.getListOfIntegerByStrings(inputs);

                this.setWinningLotto(numbers);
                break;
            } catch (Exception e) {
                OutputService.printErrorMessage(e.getMessage());
            }
        }
    }

    private void askBonusNumber() {
        while (true) {
            try {
                String input = InputService.askBonusNumber();
                InputValidator.validateBlankString(input);
                int bonusNumber = Integer.parseInt(input);
                this.setBonusNumber(bonusNumber);
                break;
            } catch (Exception e) {
                OutputService.printErrorMessage(e.getMessage());
            }
        }
    }

    private void askMoney() {
        while (true) {
            try {
                String input = InputService.askMoney();
                InputValidator.validateBlankString(input);

                long money = Long.parseLong((input));
                this.setMoney(money);
                break;
            } catch (Exception e) {
                OutputService.printErrorMessage(e.getMessage());
            }
        }

    }
    private int convertMoneyToLotto() {
        return this.money / 1000;
    }

    public void playGame(){
        this.askMoney();
        this.askWinningNumbers();
        this.askBonusNumber();

        Player player = new Player(this.money/1000);
    }
}
