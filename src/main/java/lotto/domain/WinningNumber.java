package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    //상수(static final) 또는 클래스 변수
    private final List<Integer> winningNumbers;

    //인스턴스 변수

    //생성자
    public WinningNumber(String winningNumbersInput) {
        List<Integer> winningNumber = new ArrayList<>();
        // String을 List<Integer>형태로 반환함
        isDuplicate(winningNumber);
        this.winningNumbers = winningNumber;
    }

    private void isDuplicate(List<Integer> winningNumber) {
       // 입력받은 당첨번호의 중복체크
       // 예외던짐
    }
}
