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
        System.out.println(Message.AMOUNT_INPUT.getMessage());
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

    public void drawBonusNumber() {
        System.out.println("\n" + Message.BONUS_INPUT.getMessage());
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
        System.out.println("\n" + Message.WINNING_STATISTICS.getMessage());
        System.out.println("---");
        compareLottoTicket();
    }

    public void compareLottoTicket(){
        for(Lotto lotto : lottoNumbers){
            compareNumber(lotto.getNumbers(), user.getWinningNumber().getNumbers());
        }
    }

    public void compareNumber(List<Integer> lottoNumbers, List<Integer> winningLottoNumbers){
        int count = 0;
        for(int number : lottoNumbers){
            if(winningLottoNumbers.contains(number)){
                count++;
            }
        }
    }
}
