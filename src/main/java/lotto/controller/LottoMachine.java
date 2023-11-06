package lotto.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.enums.Message;
import lotto.print.Result;
import lotto.util.Computer;
import lotto.util.User;

public class LottoMachine {
    HashMap<Integer, Integer> winningCount = new HashMap<>();
    List<Lotto> lottoNumbers = new ArrayList<>();
    User user = new User();
    Computer computer = new Computer();
    Result result = new Result();

    public void startLottoGame() {
        buyLotto();
        drawLottoNumber();
        result.printLottoNumber(lottoNumbers);
        drawWinningNumber();
        drawBonusNumber();
        getWinningStatistics();
    }

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
        Message.WINNING_NUMBERS_INPUT.getMessage();
        while (true) {
            try {
                user.inputWinningNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void drawBonusNumber() {
        Message.BONUS_INPUT.getMessage();
        while (true) {
            try {
                user.inputBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getWinningStatistics() {
        Message.WINNING_STATISTICS.getMessage();
        System.out.println("---");
        compareLottoTicket();
    }

    public void compareLottoTicket() {
        for (Lotto lotto : lottoNumbers) {
            compareNumber(lotto.getNumbers(), user.getWinningNumber().getNumbers());
        }
    }

    public void compareNumber(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                count++;
            }
        }
        addLottoWinning(count);
    }

    public void addLottoWinning(int count) {
        winningCount.merge(count, 1, Integer::sum);
    }
}
