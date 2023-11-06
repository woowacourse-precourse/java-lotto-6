package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private List<Integer> winningNumber;
    private String inputWinningNumber;
    private String[] numbers;

    public WinningNumber(){

    }

    public WinningNumber(String inputWinningNumber) {
        validateSplitCheck(inputWinningNumber);
        validateIsNumber(inputWinningNumber);
        validateRange(inputWinningNumber);

        this.inputWinningNumber = inputWinningNumber;
        winningNumber = new ArrayList<>();
        setWinningNumberList(this.inputWinningNumber);
    }



    private void validateSplitCheck(String inputWinningNumber) {
        // 당첨번호가 ","로 구분되어지는가
        if (!inputWinningNumber.matches("\\d+(,\\d+){5}")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력 형식이 올바르지 않습니다.");
        }
    }

    private void validateIsNumber(String inputWinningNumber){
        // 당첨번호가 숫자로 되어있는가
        for (String number : numbers) {
            try {
                int num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
            }
        }
    }

    private void validateRange(String inputWinningNumber){
        // 당첨번호가 1~45사이의 숫자인가
        for (String number : numbers) {
            if(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateCount(String inputWinningNumber){
        // 당첨번호의 개수가 6개인가
        if(numbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 선택해야합니다.");
        }
    }

    // 당첨번호에 중복이 있는가
    private void validateSame(String inputWinningNumber){
        Set<Integer> numberSet = new HashSet<>();
        // 당첨번호에 중복이 있는지 확인
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (!numberSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
        }
    }


    private void setWinningNumberList(String inputWinningNumber) {
        numbers = inputWinningNumber.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            winningNumber.add(num);
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
