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
        String input = Console.readLine();
        String[] numbersString = input.split(",\\s*"); // Split the input string by commas and optional whitespace
        if (numbersString.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersString) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
            }
            numbers.add(num);
        }
    
        winNumbers.getNumbers().addAll(numbers);
    }
    
    

    public void setWinBonusNumber() {
        int input = Integer.parseInt(Console.readLine().trim());
    
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
        }
    
        for (Integer number : winNumbers.getNumbers()) {
            if (number == input) {
                throw new IllegalArgumentException("[ERROR] 이미 선택한 번호입니다.");
            }
        }
        this.bonusNumber = input;
    }    
}
