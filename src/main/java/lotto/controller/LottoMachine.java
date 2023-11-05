package lotto.controller;


import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.util.Computer;
import lotto.util.User;

public class LottoMachine {
    List<Lotto> lottoNumbers = new ArrayList<>();
    User user = new User();
    Computer computer = new Computer();

    public void buyLotto() {
        Message.AMOUNT_INPUT.getMessage();
        while (true) {
            try {
                user.inputPaymentAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void drawLotto() {
        for (int i = 0; i < user.getManyLottoTicket(); i++) {
            getLotto();
        }
    }

    public void getLotto() {
        while (true) {
            try {
                List<Integer> numbers = computer.getRandomNumber();
                Lotto lotto = new Lotto(numbers);
                lottoNumbers.add(lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
