package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private List<Integer> numbers;

    public Winning() {
        numbers = new ArrayList<>();
    }

    public void inputNumbers() {
        while (true) {
            String input = Console.readLine();
            parseAndSetNumbers(input);
            if (isValidNumbers()) {
                break;
            }
        }
    }

    //사용자가 입력한 당첨 번호가 구매한 로또 번호 중에 있는지 확인하는 메서드
    private int getMatchedCount(Lotto lotto) {
        return ((int) lotto.getSortedNumbers().stream()
                .filter(numbers::contains)
                .count());
    }

    private void parseAndSetNumbers(String input) {
        numbers.clear();
        String[] split = input.split(",");

        for (String number : split) {
            int i = Integer.parseInt(number);
            numbers.add(i);
        }
    }

    private boolean isValidNumbers() {
        try {
            validateNumbers();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void validateNumbers() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        boolean isRange = numbers.stream().allMatch(number -> number >= 1 && number <= 45);
        if (!isRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        boolean isDuplicate = numbers.stream().distinct().count() < numbers.size();
        if (isDuplicate) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
}
