package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    rank ranking;
    int same = 0;
    int bonus = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    void printLotto(){ // 로또 출력
        System.out.print(numbers.get(0));
        for(int i = 1; i < numbers.size(); i++){
            System.out.print(", " + numbers.get(i));
        }
    }

    void checking(int checkValue){ //당첨번호와 일치하면 same증가 보너스 번호와 일치하면 bonus증가
        if(checkValue == 1){
            same++;
        }
        if(checkValue == 2){
            bonus++;
        }
    }

    rank rankLotto(int same, int bonus){ //로또 등수 매기기
        if(same == 3){
            return rank.FIRST;
        }
        if(same == 4){
            return rank.FOURTH;
        }
        if(same == 5 && bonus != 1){
            return rank.THIRD;
        }
        if(same == 5 && bonus == 1){
            return rank.SECOND;
        }
        if(same == 6){
            return rank.FIFTH;
        }
        return rank.OUT;
    }

    void checkLotto(int[] prizeWin){ // 로또 비교
        for(int i = 0; i < numbers.size(); i++) {
            checking(prizeWin[numbers.get(i)]);
        }

        ranking = rankLotto(same, bonus);
    }
}
