package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요: ");
        try {
            String input = Console.readLine();
            List<Integer> winningNumbers = parseNumbers(input);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요: ");
                int bonusNumber = Integer.parseInt(Console.readLine());
                Lotto.validateBonusNumber(bonusNumber);  // 유효성 검사를 수행
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> parseNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
