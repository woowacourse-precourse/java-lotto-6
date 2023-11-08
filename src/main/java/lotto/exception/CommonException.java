package lotto.exception;

import java.util.List;

public class CommonException {

    /**
     * 공통 예외처리 - 보너스번호와 당첨 번호사이에 중복된 번호가 있는지 검증
     */
    public static void commonException(List<Integer> WinningNumber, int bonusNumber){
        for (int number: WinningNumber) {
            if(bonusNumber == number){
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호에 중복이 있습니다.");
            }
        }
    }

}
