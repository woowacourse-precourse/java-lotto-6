package lotto.domain;

import java.util.Arrays;
import lotto.constant.LottoGameConstant;

public class UserInputCheck {
    String errorMessage = "";

    public boolean validBuyAmount(String input){
        if (!checkBuyAmountNumberRange(input)){
            throw new IllegalArgumentException(errorMessage);
        }
        if (!checkBuyAmountDivide(input)){
            throw new IllegalArgumentException(errorMessage);
        }
        return true;
    }

    public boolean validWinNumbers(String input){
        String[] splitInput = input.split(",");
        if (!checkLottoNumber(splitInput)){
            throw new IllegalArgumentException(errorMessage);
        }
        int [] splitInputNumbers = Arrays.stream(splitInput).mapToInt(Integer::parseInt).toArray();
        if (!checkLottoRange(splitInputNumbers) || !checkLottoUniqueLength(splitInputNumbers)){
            throw new IllegalArgumentException(errorMessage);
        }
        return true;
    }

    public boolean validBonusNumber(String input, Lotto winLotto){
        if (!checkBonusNumberRange(input)){
            throw new IllegalArgumentException(errorMessage);
        }
        if (!checkBonusDuplicate(input, winLotto)){
            throw new IllegalArgumentException(errorMessage);
        }
        return true;
    }

    public boolean checkBuyAmountNumberRange(String input){
        try {
            int number = Integer.parseInt(input);
            if (number<0){
                errorMessage = "[ERROR] 구입금액은 음수가 될 수 없습니다.";
                return false;
            }
        } catch (NumberFormatException e){
            errorMessage = "[ERROR] 구입금액은 문자가 될 수 없습니다.";
            return false;
        }
        return true;
    }

    public boolean checkBuyAmountDivide(String input){
        int number = Integer.parseInt(input);

        if (number%1000 != 0){
            errorMessage = "[ERROR] 구입금액은 1000원 단위여야 합니다.";
            return false;
        }
        return true;
    }

    public boolean checkLottoNumber(String[] splitInput){
        try {
            for (String s : splitInput){
                int number = Integer.parseInt(s);
            }
        } catch (NumberFormatException e){
            errorMessage = "[ERROR] 로또 번호는 문자가 될 수 없습니다.";
            return false;
        }
        return true;
    }

    public boolean checkLottoRange(int[] splitInputNumbers){
        for (int number : splitInputNumbers){
            if (number<LottoGameConstant.GENERATE_MIN_VALUE || number>LottoGameConstant.GENERATE_MAX_VALUE){
                errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
                return false;
            }
        }
        return true;
    }

    public boolean checkLottoUniqueLength(int[] splitInputNumbers){
        splitInputNumbers = Arrays.stream(splitInputNumbers).distinct().toArray();
        if (splitInputNumbers.length != LottoGameConstant.GENERATE_NUM_SIZE){
            errorMessage = "[ERROR] 로또 번호는 중복 없이 6개 입력하여야 합니다.";
            return false;
        }
        return true;
    }

    public boolean checkBonusNumberRange(String input){
        try {
            int number = Integer.parseInt(input);
            if (number<LottoGameConstant.GENERATE_MIN_VALUE || number>LottoGameConstant.GENERATE_MAX_VALUE){
                errorMessage = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
                return false;
            }
        } catch (NumberFormatException e){
            errorMessage = "[ERROR] 보너스 번호는 문자가 될 수 없습니다.";
            return false;
        }
        return true;
    }

    public boolean checkBonusDuplicate(String input, Lotto winLotto){
        int number = Integer.parseInt(input);
        if (winLotto.getNumbers().contains(number)){
            errorMessage = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
            return false;
        }
        return true;
    }
}
