package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 로또(Lotto) 클래스는 로또 번호를 나타내며, 로또 번호와 당첨 번호를 비교하여 등수를 확인하는 기능을 제공한다.
 */
public class Lotto {
    private final List<Integer> numbers; // 로또 번호 리스트

    /**
     * Lotto 클래스의 생성자. 주어진 숫자 리스트로 로또 번호를 초기화한다.
     * @param numbers 초기화할 로또 번호 리스트
     */
    public Lotto(List<Integer> numbers) {
        checkValidation(numbers);
        this.numbers = numbers;
    }

    /**
     * 로또 번호를 보여준다.
     * @return 로또 번호 리스트
     */
    public void showNumber(){
        System.out.println(numbers);
    }

    /**
     * 로또 번호를 오름차순으로 정렬한다.
     */
    public void sortNumber(){
        numbers.sort(Comparator.naturalOrder());
    }

    /**
     * 주어진 당첨 번호와 보너스 번호와 비교하여 로또 티켓의 등수를 확인한다.
     * @param winning 당첨 번호 리스트
     * @param bonus_num 보너스 번호
     * @return 로또 티켓의 등수 (Rank 객체)
     */
    public Rank checkPlace(List<Integer> winning, int bonus_num){
        int valid = 0;
        boolean bonus = numbers.contains(bonus_num);
        for(int i = 0; i < 6; ++i)
            if(numbers.contains(winning.get(i)))
                valid++;

        return determineRank(valid, bonus);
    }

    /**
     * 로또 티켓의 당첨 여부를 일치하는 당첨 번호의 수를 기반으로 등수(Rank)를 결정한다.
     * @param valid 일치하는 당첨 번호의 수
     * @param bonus_num 보너스 번호 여부
     * @return 로또 티켓의 등수 (Rank 객체)
     */
    private Rank determineRank(int valid, boolean bonus_num){
        if(valid == 6)
            return Rank.FIRST;
        if(valid == 5){
            if(bonus_num)
                return Rank.SECOND;
            return Rank.THIRD;
        }
        if(valid == 4)
            return Rank.FOURTH;
        if(valid == 3)
            return Rank.FIFTH;
        return Rank.NEXT;
    }

    /**
     * 로또 번호 리스트의 유효성을 검사합니다. 범위, 중복, 개수 등의 조건을 검사한다.
     * @param numbers 로또 번호 리스트
     */
    private void checkValidation(List<Integer> numbers){
        validate(numbers);
        duplicate(numbers);
        Range(numbers);
    }

    /**
     * 로또 번호 리스트의 각 숫자가 유효한 범위(1부터 45 사이)에 속하는지 확인한다.
     * @param numbers 로또 번호 리스트
     */
    private void Range(List<Integer> numbers){
        for(int number : numbers)
            if(number > 45 || number < 1)
                throw new IllegalArgumentException();
    }

    /**
     * 로또 번호 리스트에 중복된 숫자가 있는지 확인한다.
     * @param numbers 로또 번호 리스트
     */
    private void duplicate(List<Integer> numbers){
        List<Integer> tmp = new ArrayList<>();
        for(int number : numbers) {
            if (tmp.contains(number))
                throw new IllegalArgumentException();
            tmp.add(number);
        }
    }

    /**
     * 로또 번호 리스트의 길이가 6인지 확인한다.
     * @param numbers 로또 번호 리스트
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
