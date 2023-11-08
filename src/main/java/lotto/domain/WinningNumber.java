package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

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

    /**
     * 1. 입력받은 문자열 split 검증
     * 2. 이후, 문자열 배열 검증
     * 3. 최종적으로 리스트에 문자열 배열 저장
     */
    public WinningNumber(String inputWinningNumber) {
        try{
            validateSplitCheck(inputWinningNumber);
            this.inputWinningNumber = inputWinningNumber;
            validateIsNumber(numbers);
            validateRange(numbers);
            validateCount(numbers);
            validateSame(numbers);
            winningNumber = new ArrayList<>();
            setWinningNumberList(this.inputWinningNumber);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            new WinningNumber(Console.readLine());
        }
    }


    /**
     * 당첨번호 split 되는지 검증 -> 이때 정규식 사용
     */
    public void validateSplitCheck(String inputWinningNumber) {
        if (!inputWinningNumber.matches("\\d+(,\\d+){5}")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력 형식이 올바르지 않습니다.");
        }
        numbers = inputWinningNumber.split(",");
    }


    /**
     * 당첨번호가 숫자로 되어있는지 검증
     */
    public void validateIsNumber(String[] numbers){
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
            }
        }
    }


    /**
     * 당첨번호가 1~45 범위 내의 숫자인지 검증
     */
    public void validateRange(String[] numbers){
        for (String number : numbers) {
            if(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45){
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }


    /**
     * 당첨번호의 개수가 6개인지 검증
     */
    public void validateCount(String[] numbers){
        if(numbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 선택해야합니다.");
        }
    }

    /**
     * 당첨 번호에 중복된 숫자가 있는지 검증
     */
    public void validateSame(String[] numbers){
        Set<Integer> numberSet = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (!numberSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
        }
    }


    /**
     * split 검증 완료 후, 해당 문자열을 split해서 문자열 배열에 저장
     */
    public void setWinningNumberList(String inputWinningNumber) {
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
