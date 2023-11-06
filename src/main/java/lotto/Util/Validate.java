package lotto.Util;

import lotto.Factory.BonusNumberChecker;
import java.util.List;

public class Validate {

    public static void checkInteger(String number){ //사용자의 입력이 숫자형태인지 모두 이 함수를 통해 확인
        try {
            Integer.parseInt(number); // 숫자로 변환을 시도
        } catch (NumberFormatException e) { //만약 숫자가 아닌 값이 있다면 해당 예외 발생
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해주세요");
        }
    }

    public static void CashIsInteger(String Cash){
        int cash = Integer.parseInt(Cash);
        if(cash/1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 천원, 또는 만원 단위로 입력해주세요.");
        }
    }

    public static List<Integer> WinningLottoInput(String WinningLotto) {
        boolean hasInvalidDelimiter = WinningLotto.matches(".*[^\\d,].*"); //공백 및 ,외 다른 구분자 사용시 true 반환

        if (hasInvalidDelimiter) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 공백없이 ,를 이용하여 입력해주세요.");
        }

        List<Integer> lottoNumbers = Divide.Delimiter(WinningLotto);
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자로 입력해주세요.");
        }
        return lottoNumbers;
    }

    public static void isDuplicateBonus(BonusNumberChecker checker, int bonus){
       Boolean isDuplicate = checker.isDuplicateBonus(bonus);
       if(isDuplicate){
           throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨번호와 겹칠 수 없습니다.");
       }
    }

}
