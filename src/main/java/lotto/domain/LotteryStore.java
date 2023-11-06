package lotto.domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

    private void checkCash(int cash) {
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
        if (winningNumber.size() != 6) {
            throw new InputMismatchException("[ERROR] 당첨 번호는 6개의 숫자로 구성 되어야 합니다.");
        }
    }

    private int checkNumbers(String number) {
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
    }
}
