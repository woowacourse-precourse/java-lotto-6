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
        result.printWinningStatistics(winningCount);
        result.printTotalProfit();
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
        System.out.println();
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
        System.out.println();
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
        System.out.println();
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
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        if (matchCount != 5) {
            addLottoWinning(matchCount);
        }
        if (matchCount == 5) {
            addSecondWinning(lottoNumbers);
        }
    }

    public void addLottoWinning(int matchCount) {
        if (matchCount == 6) {
            winningCount.merge(1, 1, Integer::sum);
        }
        if (matchCount == 4) {
            winningCount.merge(4, 1, Integer::sum);
        }
        if (matchCount == 3) {
            winningCount.merge(5, 1, Integer::sum);
        }
    }

    public void addSecondWinning(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(user.getBonusNumber())) {
            winningCount.merge(2, 1, Integer::sum);
            return;
        }
        winningCount.merge(3, 1, Integer::sum);
    }
}
