package lotto.view;

import lotto.domain.LottoRole;

import java.util.ArrayList;
import java.util.List;

public class InputMaker {

    public int inputNum(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자입니다.");
        }
    }

    public void inputCoinValidate(int coin) {
        if (coin % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 허용합니다.");
        }
    }

    public void lottoNumRangeValidate(int num) {
        if (num < LottoRole.LOTTO_MIN_NUMBER.getNumber() ||
                num > LottoRole.LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는"+
                    LottoRole.LOTTO_MIN_NUMBER.getNumber()+"부터 "+
                    LottoRole.LOTTO_MAX_NUMBER.getNumber()+" 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> inputWinningNumber(String userInput) {
        List<Integer> result = new ArrayList<>();
        String[] inputNumber = userInput.split(",");
        for (int i = 0; i < inputNumber.length; i++) {
            int nowNum = inputNum(inputNumber[i].trim());
            lottoNumRangeValidate(nowNum);
            result.add(nowNum);
        }
        return result;
    }
}
