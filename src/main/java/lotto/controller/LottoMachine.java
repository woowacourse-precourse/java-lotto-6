package lotto.controller;


import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.print.Result;
import lotto.util.Computer;
import lotto.util.User;

public class LottoMachine {
    List<Lotto> lottoNumbers = new ArrayList<>();
    User user = new User();
    Computer computer = new Computer();

    public void startLottoGame() {
        System.out.println(Message.AMOUNT_INPUT.getMessage());
        buyLotto();
        drawLottoNumber();
        System.out.println("\n" + user.getManyLottoTicket() + Message.PURCHASE_LOTTO.getMessage());
        Result.printLottoNumber(lottoNumbers);
        drawWinningNumber();
    }

    public void buyLotto() {
        while (true) {
            try {
                user.inputPaymentAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void drawLottoNumber() {
        for (int i = 0; i < user.getManyLottoTicket(); i++) {
            getLottoNumber();
        }
    }

    public void getLottoNumber() {
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

    public void drawWinningNumber() {
        System.out.println("\n" + Message.WINNING_NUMBERS_INPUT.getMessage());
        while (true) {
            try {
                user.inputWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
