package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import Enum.Rank;

public class Lotto {
    private final List<Integer> numbers;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        //로또 번호의 범위 판단
        for (int number:numbers){
            if(number<1 ||number>45){
                throw new IllegalArgumentException();
            }
        }
        //로또 번호 중복 판단
        Set<Integer> uniquenumbers=new HashSet<>(numbers);
        if(uniquenumbers.size()!= numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public void print_lotto(){
        String result=numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", " ,"[","]"));
        System.out.println(result);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private boolean checkBonus(int bonus){
        if(numbers.contains(bonus)){
            return true;
        }
        return false;
    }
    public Rank checkRank(int count,int bonus){
        if(count==3){
            return Rank.FIFTH;
        }
        if(count==4){
            return Rank.FOURTH;
        }
        if(count==5){
            if(checkBonus(bonus)){
                return Rank.THIRD;
            }
            return Rank.SECOND;
        }
        if(count==6){
            return Rank.FIRST;
        }
        return Rank.SIXTH;
    }

}
