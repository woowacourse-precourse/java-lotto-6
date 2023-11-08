package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        long uniqueCount = numbers.stream().distinct().count();

        if(uniqueCount < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 있습니다.");
        }
    }

    public void printNumbers() {
        String result = numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    private int getMatchingCount(List<Integer>winningNumbers){
        Set<Integer> lotto = new HashSet<>(this.numbers);
        Set<Integer> winningNumber = new HashSet<>(winningNumbers);

        lotto.retainAll(winningNumber);
        return lotto.size();
    }

    private boolean isMatchingBonusNumber(int bonusNumber){
         return this.numbers.contains(bonusNumber);
    }

    public Rank checkRank(List<Integer>winningNumbers,int bonusNumber){
        int winningNumber = getMatchingCount(winningNumbers);
        boolean checkBonus = isMatchingBonusNumber(bonusNumber);

        return Rank.checkRank(winningNumber, checkBonus);
    }


}
