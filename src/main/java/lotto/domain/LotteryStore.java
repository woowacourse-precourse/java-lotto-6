package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryStore {
    private static final int lotteryPrice = 1000;
    private static final List<Integer> winningNumber = new ArrayList<Integer>();
    private static int bonusNumber;

    public void buyLotto() {
        OutputView.print("BUY_CASH");
        int cash = Integer.parseInt(InputView.getInput("number"));
        checkCash(cash);
        int buyCount = cash / 1000;
        OutputView.print_value_front("GET_LOTTO", String.valueOf(buyCount));
        for (int i = 0; i < buyCount; i++) {
            Player.addLotto();
        }

    }

    public void checkCash(int cash) {
        if (cash % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
    }

    public void setWinningNumber() {
        OutputView.print("LOTTO_WINN");
        String winningNumbers = InputView.getInput("text");
        for (String number : winningNumbers.split(",")) {
            winningNumber.add(checkNumbers(number));
        }
        checkNumberSize(winningNumber.size());
    }
    public void checkNumberSize(int size){
        if (size != 6) {
            throw new InputMismatchException("[ERROR] 당첨 번호는 6개의 숫자로 구성 되어야 합니다.");
        }
    }

    public int checkNumbers(String number) {
        int returnNumber;
        try {
            returnNumber = Integer.parseInt(number);
            checkNumberRanges(returnNumber);
        } catch (NumberFormatException ex) {
            throw new InputMismatchException("[ERROR] 당첨 번호에는 숫자만 들어갈 수 있습니다.");
        }
        return returnNumber;
    }

    public void setBonusNumber() {
        OutputView.print("LOTTO_BOUNS");
        int inputBonusNumber = Integer.parseInt(InputView.getInput("number"));
        checkNumberRanges(inputBonusNumber);
        bonusNumber = inputBonusNumber;
    }

    public void checkNumberRanges(int number) {
        if (number < 0) {
            throw new InputMismatchException("[ERROR] 당첨 번호에는 음수가 들어갈 수 없습니다.");
        }
        if (number > 45) {
            throw new InputMismatchException("[ERROR] 당첨 번호의 최대값은 45입니다..");
        }
    }

    public void checkNumber() {
        List<Integer> winningNumber = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        OutputView.print("LOTTO_RETURN");
        for (Lotto lotto : Player.getLotto()) {
            int score = lottoScore(lotto);
            winningNumber.set(score, winningNumber.get(score) + 1);
        }
        OutputView.print_game_return(winningNumber);
        printReturn(winningNumber, Player.getLotto().size());
    }

    private void printReturn(List<Integer> winningNumber, int size) {
        int capital = size * 1000;
        int grossProfit = 0;
        for (int i = 0; i < winningNumber.size(); i++) {
            grossProfit = grossProfit + returnGrossProfit(i, winningNumber);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        double yield = (double) grossProfit / capital;
        OutputView.print_value_back("LOTTO_PROFIT", df.format(yield) + "%입니다.");
    }

    public int returnGrossProfit(int num, List<Integer> winningNumber) {
        if (num == 0) {
            return winningNumber.get(num) * 5000;
        }
        if (num == 1) {
            return winningNumber.get(num) * 50000;
        }
        if (num == 2) {
            return winningNumber.get(num) * 1500000;
        }
        if (num == 3) {
            return winningNumber.get(num) * 30000000;
        }
        if (num == 4) {
            return winningNumber.get(num) * 2000000000;
        }
        return 0;
    }

    private int lottoScore(Lotto lotto) {
        int score = 0;
        for (Integer num : lotto.getNumbers()) {
            if (winningNumber.contains(num)) {
                score++;
            }
        }
        if (score == 6) {
            return 5;
        }
        if (score == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return 4;
        }
        if (score == 5) {
            return 3;
        }
        if (score == 4) {
            return 2;
        }
        if (score == 3) {
            return 1;
        }
        return 0;
    }
}