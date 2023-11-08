package lotto.validator;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public int validateAndGetLotteryPrice(String inputString) {
        int price = Integer.parseInt(inputString);
        if (price == 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 이루어져야 합니다.");
        }
        return price;
    }

    public Lotto validateAndGetWinnerLottery(String inputString) {
        boolean[] added = new boolean[46];
        List<Integer> numbers = new ArrayList<>();
        int[] lotteryNumbers = getLotteryNumbers(inputString);
        for (int lotteryNumber : lotteryNumbers) {
            if (1 > lotteryNumber || lotteryNumber > 45 || added[lotteryNumber]) {
                throw new IllegalArgumentException("입력한 로또 번호들이 잘못되었습니다.");
            }
            numbers.add(lotteryNumber);
            added[lotteryNumber] = true;

        }
        return new Lotto(numbers);
    }

    private int[] getLotteryNumbers(String inputString) {
        String[] lotteryStrings = inputString.split(",");
        if (lotteryStrings.length != 6) {
            throw new IllegalArgumentException("입력한 숫자의 수가 6개가 아닙니다");
        }
        int[] lotteryNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            lotteryNumbers[i] = Integer.parseInt(lotteryStrings[i]);
        }
        return lotteryNumbers;
    }

    public int validateAndGetBonusNumber(String inputString) {
        int bonusNumber = Integer.parseInt(inputString);
        if (1 > bonusNumber || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자의 범위는 1 ~ 45 이여야합니다.");
        }
        return bonusNumber;
    }
}
