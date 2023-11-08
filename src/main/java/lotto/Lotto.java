package lotto;

import lotto.exception.InputValidator;
import lotto.lottery.Bonus;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    Bonus bonus = new Bonus();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private enum MatchesForWin {
        MIN(3), MAX(6);
        private final int count;

        MatchesForWin(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    private void validate(List<Integer> numbers) {
        InputValidator inputValidator = new InputValidator();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개만 입력 가능합니다.");
        }
        inputValidator.checkWinningNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public Map<Integer, Integer> winningStatistics(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = matchNumbers(ticketNumbers, bonusNumber);
        Map<Integer, Integer> winningStatistics = addWinningStatistics(matchedNumberCount);
        return winningStatistics;
    }

    //일치하는 번호 개수 반환
    private List<Integer> matchNumbers(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = new ArrayList<>();
        int bonusCount = 0;
        for (List<Integer> ticket : ticketNumbers) {
            Set<Integer> matchedNumbers = new HashSet<>(ticket);
            matchedNumbers.retainAll(numbers);
            //일치하는 개수가 5개일 경우
            if (matchedNumbers.size() == 5) {
                //보너스 번호 체크
                if (matchedBonus(ticket, bonusNumber)) bonusCount++;
                else if (!matchedBonus(ticket, bonusNumber)) matchedNumberCount.add(matchedNumbers.size());
            } else if (matchedNumbers.size() != 5) matchedNumberCount.add(matchedNumbers.size());
        }
        bonus.setBonusCount(bonusCount);
        return matchedNumberCount;
    }

    //일치하는 번호 개수를 맵형식으로 반환
    private Map<Integer, Integer> addWinningStatistics(List<Integer> matchedNumberCount) {
        Map<Integer, Integer> winningStatistics = new HashMap<>();
        for (int count : matchedNumberCount) {
            winningStatistics.put(count, winningStatistics.getOrDefault(count, 0) + 1);
        }
        for (int i = MatchesForWin.MIN.getCount(); i <= MatchesForWin.MAX.getCount(); i++) {
            winningStatistics.putIfAbsent(i, 0);
        }
        // key값에 원래는 일치한 개수를 넣었지만 보너스는 key값에 2를 넣음
        winningStatistics.put(2, bonus.getBonusCount());
        return winningStatistics;
    }

    private boolean matchedBonus(List<Integer> ticketNumbers, int bonusNumber) {
        return ticketNumbers.contains(bonusNumber);
    }
}
