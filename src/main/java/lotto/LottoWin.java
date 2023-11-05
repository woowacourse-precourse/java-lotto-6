package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoWin {
    private final Lotto winNumbers;
    private int bonusNumber;

    public LottoWin() {
        this.winNumbers = new Lotto();
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setLottoWinNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = splitNumbers(input);
                winNumbers.getNumbers().addAll(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setWinBonusNumber() {
        while (true) {
            try {
                int input = Integer.parseInt(Console.readLine().trim());
                validateNumberRange(input);
                validateUniqueBonusNumber(input);
                this.bonusNumber = input;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private List<Integer> splitNumbers(String input) {
        String[] numbersString = input.split(",\\s*"); // Split the input string by commas and optional whitespace
        if (numbersString.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersString) {
            int num = Integer.parseInt(number.trim());
            validateNumberRange(num);
            numbers.add(num);
        }
        return numbers;
    }
    
    private void validateNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
        }
    }
    
    private void validateUniqueBonusNumber(int input) {
        for (Integer number : winNumbers.getNumbers()) {
            if (number == input) {
                throw new IllegalArgumentException("[ERROR] 이미 선택한 번호입니다.");
            }
        }
    }
}
