package lotto;

import java.util.*;
import java.util.function.Predicate;


public class Lotto {

    static final int lotteryCost = 1000;
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
        Set<Integer> removeDuplicatedNum = new HashSet<>(numbers);
        if (removeDuplicatedNum.size() != numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호엔 중복된 숫자가 있으면 안됩니다.");
    }

    public int numOfMatchNum(List<Integer> winningNumbers) {
        //연산
        List<Integer> matchNumbers = this.numbers.stream().filter(n -> winningNumbers.stream()
                .anyMatch(Predicate.isEqual(n))).toList();

        return matchNumbers.size();
    }

    public boolean ifBonusNumEqual(int bonusNum) {
        return this.numbers.contains(bonusNum);
    }

    static int lottoAmount(int userMoneyAmount) {
        return userMoneyAmount / lotteryCost;
    }

    public void printLottoNumber() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
    }

}
