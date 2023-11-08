package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputUser {
    private Validate validate;
    private String inputMoney;
    private Integer lottoMoney;
    private List<Integer> WinningNumbers;

    public InputUser() {
        this.validate = new Validate();
    }

    public Integer inputLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        inputMoney = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        validate.validateInputMoneyIsInteger(inputMoney);
        lottoMoney = Integer.parseInt(inputMoney);
        validate.validateMoneyIsMultipleOfThousand(lottoMoney);
        return Integer.parseInt(inputMoney);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputRawWinningNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        List<String> splitRawWinningNumbers = Arrays.asList(inputRawWinningNumber.split(","));
        validate.validateSplitInputRawWinningNumberByOverSize(splitRawWinningNumbers);
        validate.validateInputWinningNumberIsInteger(splitRawWinningNumbers);
        return convertStringToInteger(splitRawWinningNumbers);
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        validate.validateinputBonusNumberIsInteger(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private List<Integer> convertStringToInteger(List<String> splitRawWinningNumbers) {
        WinningNumbers = new ArrayList<>();
        for (String WinningNumber : splitRawWinningNumbers) {
            WinningNumbers.add(Integer.parseInt(WinningNumber));
        }
        return WinningNumbers;
    }
}
