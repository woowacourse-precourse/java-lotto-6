package lotto;

import java.util.List;

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
    }

    public int lottoScore(List<Integer>winningLottoNumbers, int bonusNumber){
        int score=0;
        int bonusScore=0;
        for (int number:numbers){
            if(winningLottoNumbers.contains(number)) score++;
            if(number==bonusNumber)bonusScore++;
        }
        return calculateReward(score,bonusScore);
    }

    public int calculateReward(int score,int bonusScore){
        if(score==6) return 2000000000;
        if(score==5){
            if(bonusScore==1)return 30000000;
            return 1500000;
        }
        if(score==4) return 50000;
        if(score==3) return 5000;
        return 0;
    }

    // TODO: 추가 기능 구현
}
