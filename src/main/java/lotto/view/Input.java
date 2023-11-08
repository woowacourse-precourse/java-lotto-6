package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Input {

    public int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine().trim());
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValue = Console.readLine().trim();
        ensureCommaDelimiter(inputValue);
        String[] splitNumbers = inputValue.split(",");
        checkDuplicated(splitNumbers);
        checkNumbersLength(splitNumbers);
        isNumber(splitNumbers);
        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        checkNumbersRange(winningNumbers);
        return winningNumbers;
    }

    public void ensureCommaDelimiter(String input) {
        if (input.contains(",") == false) {
            throw new IllegalArgumentException("[ERROR] 번호는 쉼표(,)를 기준으로 구분해주세요. (ex.1,2,3,4,5,6)");
        }
    }

    public void checkDuplicated(String[] numbers) {
        Set<String> selectedNumbers = new HashSet<>();
        for (String number : numbers) {
            selectedNumbers.add(number);
        }
        if (selectedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력해주세요.");
        }
    }

    public void checkNumbersLength(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public void checkNumbersRange(List<Integer> numbers) {
        numbers.forEach((num) -> {
            checkLottoNumberRange(num);
        });
    }

    public void checkLottoNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 선택하세요.");
        }
    }

    public void isNumber(String[] numbers) {
        try {
            for (int i = 0; i < numbers.length; i++) {
                Integer.parseInt(numbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
        }

    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine().trim();
        checkIsBonusNumber(inputValue);
        int bonusNumber = Integer.parseInt(inputValue);
        checkLottoNumberRange(bonusNumber);
        return bonusNumber;

    }

    public void checkIsBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
        }
    }


}
