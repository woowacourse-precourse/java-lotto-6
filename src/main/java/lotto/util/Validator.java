package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public void validateInputMoneyIsNumber(String inputMoney) {
        try{
            Long.parseLong(inputMoney);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력이 되어져야 합니다!");
        }
    }

    public void validateNumberUnitIsThousand(Long money) {
        if(money % 1000 !=0)
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다!");
    }

    public void validateNumberNegativeOrZero(Long money) {
        if(money <= 0)
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 아니라 양수여야 합니다!");
    }


        public void validateRightCommaCount(String inputWinnerNumbers,
        List<String> splitedInputWinnerNumbers) {
        long count = inputWinnerNumbers.chars().filter(c -> c == ',').count();
        if(count != splitedInputWinnerNumbers.size()-1)
            throw new IllegalArgumentException("[ERROR] 1,2,3,4,5,6 과 같은 형태로 ,로 구분을 해주세요!");
    }

    public void validateOnlyNumber(List<String> inputWinnerNumbers) {
        try {
            List<Integer> collect = inputWinnerNumbers.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자 와 구분자 , 만을 허용합니다!");
        }
    }

    public void validateRangeNumber(List<Integer> winnerNumbers) {
        for (Integer winnerNumber : winnerNumbers) {
            if(winnerNumber <1 || winnerNumber >45){
                throw new IllegalArgumentException("[ERROR] 당첨 번호의 숫자는 1-45 사이여야 합니다!");
            }
        }
    }



}
