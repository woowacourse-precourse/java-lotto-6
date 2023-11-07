package lotto.Controller;

import java.util.List;
import lotto.Model.Cpu;
import lotto.Model.Lotto;
import lotto.Model.Player;
import lotto.View.InputView;

public class UserInputHandler {
    private final InputView inputView;

    public UserInputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public Cpu getUserValidMoney() {
        while (true) {
            try {
                inputView.printInsertMoney();
                int money = inputView.insertMoney();
                return new Cpu(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto getUserValidLottoNumber() {
        while (true) {
            try {
                inputView.printInsertLottoNumbers();
                List<Integer> playerLottoNumbers = inputView.insertLottoNumbers();
                return new Lotto(playerLottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Player getUserValidBonusNumber(Lotto playerLotto) {
        while (true) {
            try {
                inputView.printInsertBonusNumber();
                int playerBonusNumber = inputView.insertBonusNumber();
                return new Player(playerLotto, playerBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
