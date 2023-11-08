package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 입니다.");
        }
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
        }
    }

    public static void showTicketCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void showTicketInfo(int index, Lotto[] lottoTicket) {
        System.out.println(lottoTicket[index].numbers);
    }

    public int compareNumbers(List<Integer> winningNumbers, int bonusNumber) {// 로또 1장의 숫자와 당첨번호 비교
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (winningNumbers.get(i).equals(numbers.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean equalBonus(int bonusNumber) {
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i).equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }


}
