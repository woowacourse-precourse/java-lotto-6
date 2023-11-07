package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!checkNumberInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private boolean hasDuplicates(List<Integer> numbers) { // 중복 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public boolean checkNumberInRange(List<Integer> numbers) { // 입력된 번호가 1~45 사이의 숫자인지 확인
        for (int  number : numbers) {
            if (number < 1 || number > 45)
                return false;
        }
        return true;
    }

    public int compareWinningNumbers(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (int number : numbers) {
            if (lottoTicket.getNumbers().contains(number))
                matchCount++;
        }
        return matchCount;
    }
    public void compareBonusNumber(LottoTicket lottoTicket, int bonusNumber) {
        // lottoTicket의 추첨번호들과 보너스 번호를 비교 후 결과 저장
    }
}
