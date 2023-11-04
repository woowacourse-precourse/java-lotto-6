package lotto.domain.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Utility.Validator;

import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class LottoInputView {

    public int inputCash() {
        int cash = 0;

        while (cash == 0) {
            System.out.println("\n구입금액을 입력해 주세요.");
            String inputValue = Console.readLine();
            cash = cashParser(inputValue);
        }

        return cash;
    }

    private int cashParser(String inputValue) {
        int cash;

        try {
            cash = Integer.parseInt(inputValue);
            Validator.validateInputCash(cash);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했거나 금액 제한을 넘었습니다.");
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return cash;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();

        while (winningNumbers.isEmpty()) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String inputValue = Console.readLine();
            winningNumbers = winningNumbersParser(inputValue);
        }

        return winningNumbers;
    }

    private List<Integer> winningNumbersParser(String inputValue) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumbers = Arrays.stream(inputValue.split(","))
                    .map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
            Validator.validateLottoNumbers(winningNumbers);
            winningNumbers.sort(Integer::compareTo);
        } catch (NumberFormatException | PatternSyntaxException e) {
            System.out.println("[ERROR] 숫자를 쉼표(,)로 구별하여 입력해주세요.");
            return Collections.emptyList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;

        while (bonusNumber == 0) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String inputValue = Console.readLine();
            bonusNumber = bonusNumberParser(inputValue, winningNumbers);
        }

        return bonusNumber;
    }

    private int bonusNumberParser(String inputValue, List<Integer> winningNumbers) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(inputValue);
            Validator.validateBonusNumber(bonusNumber, winningNumbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        return bonusNumber;
    }

}
