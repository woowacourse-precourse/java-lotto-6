package lotto.domain.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Utility.Validator;

import java.util.*;
import java.util.regex.PatternSyntaxException;

public class LottoInputView {

    public int inputCash() {
        int cash = 0;
        boolean validInputFlag = false;

        while (!validInputFlag) {
            System.out.println("\n구입금액을 입력해 주세요.");

            try {
                String inputValue = Console.readLine();
                cash = Integer.parseInt(inputValue);
                Validator.validateInputCash(cash);
                validInputFlag = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 값을 입력했거나 금액 제한을 넘었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return cash;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean validInputFlag = false;

        while (!validInputFlag) {
            System.out.println("\n당첨 번호를 입력해 주세요.");

            try {
                String inputValue = Console.readLine();
                winningNumbers = new ArrayList<>(Arrays.stream(inputValue.split(","))
                        .mapToInt(Integer::parseInt).boxed().toList());
                winningNumbers.sort(Integer::compareTo);
                Validator.validateLottoNumbers(winningNumbers);
                validInputFlag = true;
            } catch (PatternSyntaxException e) {
                System.out.println("[ERROR] 각 숫자의 구별은 쉼표(,)로 해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        boolean validInputFlag = false;

        while (!validInputFlag) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                String inputValue = Console.readLine();
                bonusNumber = Integer.parseInt(inputValue);
                Validator.validateBonusNumber(bonusNumber, winningNumbers);
                validInputFlag = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

}
