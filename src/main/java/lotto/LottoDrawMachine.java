package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoDrawMachine {
    private final String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    private final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    private List<Integer> winningNumbers = new ArrayList<>();
    private Integer bonusNumber;

    public WinningLotto drawWinningLotto() {
        System.out.println(inputWinningNumberMessage);
        inputWinningNumbers();

        System.out.println();
        System.out.println(inputBonusNumberMessage);
        inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void inputWinningNumbers() {
        while (true) {
            try {
                winningNumbers.clear();
                String userInput = Console.readLine();
                for (String number : userInput.split(",")) {
                    if (number.isBlank()) {
                        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                    }
                    winningNumbers.add(Integer.parseInt(number));
                }
                LottoValidator.sizeValidate(winningNumbers);
                LottoValidator.rangeValidateFromList(winningNumbers);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }

    private void inputBonusNumber() {
        while (true) {
            try {
                String userInput = Console.readLine();
                bonusNumber = Integer.parseInt(userInput);
                LottoValidator.rangeValidate(bonusNumber);
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 잘못된 입력입니다.");
            }
        }
    }
}
