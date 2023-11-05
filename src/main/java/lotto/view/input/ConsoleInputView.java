package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NotValidInputException;
import lotto.util.InputValueChecker;

import java.util.Arrays;
import java.util.List;

// 사용자로부터 값을 입력 받기 위한 InputView
public class ConsoleInputView implements InputView {
    private final InputValueChecker inputValueChecker; // 사용자가 입력하는 값의 유효성을 판단하기 위한 클래스
    private final String SPLIT_PATTERN = ","; // 사용자가 입력하는 당첨 번호를 분류하기 위한 문자

    public ConsoleInputView(InputValueChecker inputValueChecker) {
        this.inputValueChecker = inputValueChecker;
    }

    // 사용자로부터 로또 구매 금액을 입력받는다. 유효하지 않는 값을 입력하는 경우, 오류를 발생시키며 다시 값을 입력받는다.
    @Override
    public int getCost() {
        String cost;

        try {
            cost = Console.readLine();
            inputValueChecker.checkCostValidation(cost);
        } catch (NotValidInputException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("구입금액을 입력해 주세요.");
            return getCost();
        }

        return Integer.parseInt(cost);
    }

    // 사용자로부터 당첨 번호를 입력받는다. 유효하지 않는 값을 입력하는 경우, 오류를 발생시키며 다시 값을 입력받는다.
    @Override
    public List<Integer> getWinnerNumber() {
        List<String> winnerNumber;

        try {
            winnerNumber = Arrays.stream(Console.readLine().split(SPLIT_PATTERN)).toList();
            inputValueChecker.checkWinnerNumberValidation(winnerNumber);

        } catch (NotValidInputException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("당첨 번호를 입력해 주세요.");
            return getWinnerNumber();
        }

        return winnerNumber.stream().map(Integer::parseInt).toList();
    }

    // 사용자로부터 보너스 번호를 입력받는다. 유효하지 않는 값을 입력하는 경우, 오류를 발생시키며 다시 값을 입력받는다.
    @Override
    public int getBonusNumber(List<Integer> winnerNumber) {
        String bonusNumber;

        try {
            bonusNumber = Console.readLine();
            inputValueChecker.checkLottoNumberValidation(bonusNumber);
            inputValueChecker.checkBonusNumberValidation(bonusNumber, winnerNumber);
        } catch(NotValidInputException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("보너스 번호를 입력해 주세요.");
            return getBonusNumber(winnerNumber);
        }

        return Integer.parseInt(bonusNumber);
    }
}
