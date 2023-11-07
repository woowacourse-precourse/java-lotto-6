package lotto.view.input;

import lotto.exception.GameExceptionMessage;
import lotto.exception.NotValidDepthException;
import lotto.exception.NotValidInputException;
import lotto.util.InputValueChecker;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.GameExceptionMessage.*;

// 사용자에게 값을 입력받기 위한 메세지를 출력하고, 유효하지 않은 값을 입력받을 경우 오류를 반환하는 클래스
public class InputView {
    private final int RECURSION_MAX_DEPTH = 50; // 재귀가 반복되는 경우 StackOverflowError가 발생하는 것을 막기 위하여 재귀 호출 횟수 제한
    private final String SPLIT_PATTERN = ","; // 사용자가 입력하는 당첨 번호를 분류하기 위한 문자

    private final String ERROR_MESSAGE = "[ERROR] ";

    private final String REQUEST_COST_MESSAGE = "구입금액을 입력해 주세요.";
    private final String REQUEST_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final Input input;
    private final InputValueChecker inputValueChecker;

    public InputView(Input input, InputValueChecker inputValueChecker) {
        this.input = input;
        this.inputValueChecker = inputValueChecker;
    }

    // 사용자로부터 로또 구매 금액을 입력받고, 유효하지 않은 값을 입력 받는 경우 오류를 반환한다.
    public int getCost(int depth) {
        checkDepthValidation(depth);

        String cost;
        System.out.println(REQUEST_COST_MESSAGE);

        try {
            cost = input.readCost();
            inputValueChecker.checkCostValidation(cost);
        } catch (NotValidInputException e) {
            handleExceptionMessage(e);
            return getCost(++depth);
        }

        return Integer.parseInt(cost);
    }

    // 사용자로부터 당첨 번호를 입력받고, 유효하지 않은 값을 입력 받는 경우 오류를 반환한다.
    public List<Integer> getWinnerNumber(int depth) {
        checkDepthValidation(depth);

        List<String> winnerNumber;
        System.out.println(REQUEST_WINNER_NUMBER_MESSAGE);

        try {
            winnerNumber = Arrays.stream(input.readWinnerNumber().split(SPLIT_PATTERN)).toList();
            inputValueChecker.checkWinnerNumberValidation(winnerNumber);
        } catch (NotValidInputException e) {
            handleExceptionMessage(e);
            return getWinnerNumber(++depth);
        }

        return winnerNumber.stream().map(Integer::parseInt).toList();
    }

    // 사용자로부터 보너스 번호를 입력 받고, 유효하지 않은 값을 입력 받는 경우, 오류를 반환한다.
    public int getBonusNumber(int depth, List<Integer> winnerNumber) {
        checkDepthValidation(depth);

        String bonusNumber;
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);

        try {
            bonusNumber = input.readBonusNumber();
            inputValueChecker.checkLottoNumberValidation(bonusNumber);
            inputValueChecker.checkBonusNumberValidation(bonusNumber, winnerNumber);
        } catch(NotValidInputException e) {
            handleExceptionMessage(e);
            return getBonusNumber(++depth, winnerNumber);
        }

        return Integer.parseInt(bonusNumber);
    }

    // 재귀 함수의 호출이 일정 횟수를 초과하는 경우, 오류를 반환하여 프로그램을 완전히 종료
    private void checkDepthValidation(int depth) {
        if(depth >= RECURSION_MAX_DEPTH) {
            throw new NotValidDepthException(RECURSION_MAX_DEPTH + RECURSION_EXCEED_THE_LIMIT.getMessage());
        }
    }

    private void handleExceptionMessage(NotValidInputException exception) {
        System.out.println(ERROR_MESSAGE + exception.getMessage());
    }
}
