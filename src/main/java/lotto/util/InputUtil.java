package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoNumber;

public class InputUtil {

    private static final InputUtil instance = new InputUtil();
    private final InputValidator inputValidator = new InputValidator();
    private final LottoValidator lottoValidator = new LottoValidator();

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance;
    }

    //로또 금액 입력 메소드
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = "";
        do {
            moneyInput = Console.readLine();
        } while (!validateMoneyInput(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    private boolean validateMoneyInput(String moneyInput) {
        try {
            inputValidator.validateMoney(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 당첨번호 입력 메소드
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = "";
        do {
            winningNumbersInput = Console.readLine();
        } while (!validateWinningNumbers(winningNumbersInput));
        return convertToList(winningNumbersInput);
    }

    private boolean validateWinningNumbers(String winningNumberInput) {
        try {
            inputValidator.validateRawLottoNumbers(winningNumberInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 보너스 당첨번호 입력 메소드
    public int inputBonusNumber(List<LottoNumber> lottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = "";
        do {
            bonusNumberInput = Console.readLine();
        } while (!validateBonusNumber(lottoNumbers, bonusNumberInput));
        return Integer.parseInt(bonusNumberInput);
    }

    private boolean validateBonusNumber(List<LottoNumber> lottoNumbers, String bonusNumberInput) {
        try {
            inputValidator.validateRawLottoBonusNumber(bonusNumberInput);
            lottoValidator.validateLottoBonusNumber(lottoNumbers, Integer.parseInt(bonusNumberInput));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Integer> convertToList(String lottoNumberInput) {
        List<String> stringNumbers = Arrays.stream(lottoNumberInput.split(",")).toList();
        return stringNumbers.stream()
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }
}
