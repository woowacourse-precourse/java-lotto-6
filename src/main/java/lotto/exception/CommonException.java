package lotto.exception;

import java.util.List;

public class CommonException {

    public static void commonException(List<Integer> WinningNumber, int bonusNumber){
        for (int number: WinningNumber) {
            if(bonusNumber == number){
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호에 중복이 있습니다.");
            }
        }
    }

}
