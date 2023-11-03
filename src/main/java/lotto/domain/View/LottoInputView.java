package lotto.domain.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Utility.Validator;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class LottoInputView {

    public int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputValue = Console.readLine();
            int cash = Integer.parseInt(inputValue);
            Validator.validateInputCash(cash);
            return cash;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputCash();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCash();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        try {
            String inputValue = Console.readLine();

            List<Integer> winningNumbers = new ArrayList<>(Arrays.stream(inputValue.split(","))
                    .mapToInt(Integer::parseInt).boxed().toList());

            winningNumbers.sort(Integer::compareTo);

            Validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (PatternSyntaxException e) {
            System.out.println("[ERROR] 각 숫자의 구별은 쉼표(,)로 해주세요.");
            return inputWinningNumbers();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String inputValue = Console.readLine();
            int bonusNumber = Integer.parseInt(inputValue);
            Validator.validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            return inputBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

}
