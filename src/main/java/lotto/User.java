package lotto;

import lotto.utils.Prompt;
import lotto.utils.Error;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public int inputValidatedPurchaseAmount() {
        while (true) {
            try {
                System.out.println(Prompt.INPUT_PURCHASE_AMOUNT.getMessage());
                int amount = Integer.parseInt(Console.readLine().trim());
                // LottoManager 클래스 내의 검증 로직을 호출해야 함
                return amount; // 검증에 성공하면 반환
            } catch (NumberFormatException e) {
                System.out.println(Error.INVALID_PURCHASE_AMOUNT.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputValidatedWinningNumbers() {
        while (true) {
            try {
                System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
                String input = Console.readLine();
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                new Lotto(winningNumbers); // Lotto 생성자에서 검증
                return winningNumbers; // 검증에 성공하면 반환
            } catch (NumberFormatException e) {
                System.out.println(Error.INVALID_WINNING_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumber inputValidatedWinningNumber(Lotto lotto) {
        while (true) {
            try {
                System.out.println(Prompt.INPUT_BONUS_NUMBER.getMessage());
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                return new WinningNumber(lotto, bonusNumber); // WinningNumber 객체 생성 시 검증
            } catch (NumberFormatException e) {
                System.out.println(Error.INVALID_BONUS_NUMBER.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
