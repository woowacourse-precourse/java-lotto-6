package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validation.InputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int promptPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine().trim());
                InputValidation.validatePurchaseAmount(purchaseAmount);
                InputValidation.validatePurchaseThousand(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto promptWinningNumbers() {
        while(true){
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String[] input = Console.readLine().split(",");
                List<Integer> numbers = Arrays.stream(input)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                return new Lotto(numbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]숫자를 콤마로 구분지어 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int promptBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                InputValidation.validateBonusNumber(bonusNumber, winningLotto.getNumbers());
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


