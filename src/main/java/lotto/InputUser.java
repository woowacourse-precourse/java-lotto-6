package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputUser {
    private String inputMoney;
    private Integer lottoMoney;
    private List<Integer> WinningNumbers;

    public Integer inputLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        inputMoney = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        validateInputMoneyIsInteger(inputMoney);
        lottoMoney = Integer.parseInt(inputMoney);
        validateMoneyIsMultipleOfThousand(lottoMoney);
        return Integer.parseInt(inputMoney);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputRawWinningNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        List<String> splitRawWinningNumbers = Arrays.asList(inputRawWinningNumber.split(","));
        validateSplitInputRawWinningNumberByOverSize(splitRawWinningNumbers);
        validateInputWinningNumberIsInteger(splitRawWinningNumbers);
        return convertStringToInteger(splitRawWinningNumbers);
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        validateinputBonusNumberIsInteger(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private List<Integer> convertStringToInteger(List<String> splitRawWinningNumbers) {
        WinningNumbers = new ArrayList<>();
        for (String WinningNumber : splitRawWinningNumbers) {
            WinningNumbers.add(Integer.parseInt(WinningNumber));
        }
        return WinningNumbers;
    }

    private void validateInputMoneyIsInteger(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
        }
    }

    private void validateMoneyIsMultipleOfThousand(Integer lottoMoney) {
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateSplitInputRawWinningNumberByOverSize(List<String> splitRawWinningNumber) {
        if (splitRawWinningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }

    private void validateInputWinningNumberIsInteger(List<String> splitRawWinningNumbers) {
        try {
            for (String WinningNumber : splitRawWinningNumbers) {
                Integer.parseInt(WinningNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
        }
    }

    private void validateinputBonusNumberIsInteger(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }

    protected void validateDistinctWinningAndBonusNumbers(List<Integer> winningNumbers, Integer inputBonusNumber) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
