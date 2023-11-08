package lotto.utilTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    public static void validateStringMoney(String money) {
        if (money.matches(".*\\D+.*"))
            throw new IllegalArgumentException("금액에 정수가 아닌 값이 포함되어 있습니다");
    }

    public static void validateIntegerMoney(Integer money) {
        if (money <= 0)
            throw new IllegalArgumentException("금액은 0 이상의 정수가 되어야 합니다");
        if (money % 1000 != 0)
            throw new IllegalArgumentException("입력한 금액은 1000원으로 나누어 떨어져야 합니다");

    }
    public static void validateLottoNumbers(List<Integer> lottoNumberList) {
        if(lottoNumberList.size()!=6)
            throw new IllegalArgumentException("로또 번호는 6개 이어야 합니다");
        if(hasDuplicatedNumber(lottoNumberList))
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다");
        if (lottoNumberList.stream().anyMatch(a -> a > 45))
            throw new IllegalArgumentException("로또 번호는 45이하 이어야 합니다");
        if (lottoNumberList.stream().anyMatch(a -> a < 1))
            throw new IllegalArgumentException("로또 번호는 1이상 이어야 합니다");
    }

    public static Boolean hasDuplicatedNumber(List<Integer> lottoNumberList) {
        Set<Integer> numberSet = lottoNumberList.stream().collect(Collectors.toSet());
        if(numberSet.size() != lottoNumberList.size())
            return true;

        return false;
    }

    public static Integer validateBonusNumber(String stringBonusNumber) {
        if (stringBonusNumber.isBlank())
            throw new IllegalArgumentException("보너스 번호는 공백이 될 수 없습니다");

        if (stringBonusNumber.matches(".*\\D+.*"))
            throw new IllegalArgumentException("보너스 번호에 정수가 아닌 값이 포함되어 있습니다");

        Integer bonusNumber = Integer.parseInt(stringBonusNumber);
        if(bonusNumber>45)
            throw new IllegalArgumentException("보너스 번호는 45이하 이어야 합니다");
        if(bonusNumber<1)
            throw new IllegalArgumentException("보너스 번호는 1이상 이어야 합니다");

        return bonusNumber;
    }

    public static void checkDuplcate(List<Integer> lottoNumbers, Integer bonusNumber) {
        for (Integer number : lottoNumbers) {
            if (number.intValue() == bonusNumber.intValue())
                throw new IllegalArgumentException("보너스 번호와 입력한 로또 번호가 중복되면 안됩니다");
        }
    }
}


