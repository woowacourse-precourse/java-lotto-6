package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoNumber;

public class InputUtil {

    private static final InputUtil instance = new InputUtil();
    private final Validator validator = new Validator();

    private InputUtil() {
    }

    public static InputUtil getInstance() {
        return instance;
    }

    //로또 금액 입력 메소드
    public int inputMoney() {
        System.out.println("입력하세요");
        String moneyInput = "";
        do {
            moneyInput = Console.readLine();
        } while (!validateMoneyInput(moneyInput));
        return Integer.parseInt(moneyInput);
    }

    private boolean validateMoneyInput(String moneyInput) {
        try {
            validator.validateMoney(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 당첨번호 입력 메소드
    public List<Integer> inputWinningNumbers() {
        String winningNumbersInput = "";
        do {
            winningNumbersInput = Console.readLine();
        } while (!validateWinningNumbers(winningNumbersInput));
        return convertToList(winningNumbersInput);
    }

    private boolean validateWinningNumbers(String moneyInput) {
        try {
            validator.validateLottoNumbers(moneyInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //로또 보너스 당첨번호 입력 메소드
    public LottoNumber inputBonusNumber() {
        String bonusNumberInput = "";
        do {
            bonusNumberInput = Console.readLine();
        } while (!validateBonusNumber(bonusNumberInput));
        return new LottoNumber(Integer.parseInt(bonusNumberInput));
    }

    private boolean validateBonusNumber(String moneyInput) {
        try {
            validator.validateLottoBonusNumber(moneyInput);
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
                .toList();
    }
}
