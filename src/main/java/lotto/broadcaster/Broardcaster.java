package lotto.broadcaster;

import lotto.utils.CustomScanner;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Broardcaster {
    public List<Integer> pickLotteryNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLotteryNumbers = CustomScanner.getReadLine();
        if (!Validator.validateLotteryNumbersAndSize(inputLotteryNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        String[] parseResult = inputLotteryNumbers.split(",");
        if (Validator.isDuplicateLotteryNumbers(parseResult)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }
        return getListFromArray(parseResult);
    }

    private List<Integer> getListFromArray(String[] parseResult) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(parseResult)
                .forEach(num -> result.add(Integer.parseInt(num)));
        return result;
    }

    public int pickBonusNumber(List<Integer> lotteryNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = CustomScanner.getReadLine();
        if (!Validator.validateBonusNumber(inputBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (Validator.isDuplicateAllNumbers(lotteryNumbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복된 번호가 존재합니다.");
        }
        return bonusNumber;
    }
}
