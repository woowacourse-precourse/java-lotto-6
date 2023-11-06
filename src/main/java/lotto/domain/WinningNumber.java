package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumber {
    //상수(static final) 또는 클래스 변수
    private final List<Integer> winningNumbers;

    //인스턴스 변수

    //생성자
    public WinningNumber() {
        this.winningNumbers = getWinningNumber();
    }

    private List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = readLine();

        List<Integer> result = new ArrayList<>();
        for (String s : winningNumber.split(",")) {
            result.add(Integer.parseInt(s));
        }

        isDuplicate(result);
        return result;
    }

    private void validateCount() {
        // 입력받은 당첨번호의 개수 확인
    }

    private void isDuplicate(List<Integer> winningNumber) {
       // 입력받은 당첨번호의 중복체크
       // 예외던짐
    }
}
