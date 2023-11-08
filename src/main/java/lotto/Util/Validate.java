package lotto.Util;

import lotto.LottoFactory.LottoChecker;
import java.util.List;
import java.util.NoSuchElementException;

public class Validate {


    public static void CashForm(String Cash){

        try {
            Integer.parseInt(Cash); // 숫자로 변환을 시도
        } catch (NumberFormatException e) { //만약 숫자가 아닌 값이 있다면 해당 예외 발생
            throw new NoSuchElementException("[ERROR] 숫자만을 입력해주세요");
        }

        int cash = Integer.parseInt(Cash);
        if(cash%1000!=0){
            throw new NoSuchElementException("[ERROR] 구입금액은 천원, 또는 만원 단위로 입력해주세요.");
        }
    }

    public static List<Integer> WinningLottoInput(String WinningLotto) {
        boolean hasInvalidDelimiter = WinningLotto.matches(".*[^\\d,].*"); //공백 및 ,외 다른 구분자 사용시 true 반환

        if (hasInvalidDelimiter) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 공백없이 ,와 숫자만을 이용하여 입력해주세요.");
        }

        List<Integer> lottoNumbers = Divide.Delimiter(WinningLotto);
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자로 입력해주세요.");
        }

        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다.");
        }

        return lottoNumbers;
    }

    public static void isDuplicateBonus(LottoChecker checker, int bonus){
       Boolean isDuplicate = checker.isDuplicateBonus(bonus);
       if(isDuplicate){
           throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨번호와 겹칠 수 없습니다.");
       }
    }

}
