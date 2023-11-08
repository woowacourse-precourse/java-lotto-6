package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    static final int prize1=2000000000;
    static final int prize2=30000000;
    static final int prize3=1500000;
    static final int prize4=50000;
    static final int prize5=5000;

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
        if(score==6) return prize1;
        if(score==5){
            if(bonusScore==1)return prize2;
            return prize3;
        }
        if(score==4) return prize4;
        if(score==3) return prize5;
        return 0;
    }

    // TODO: 추가 기능 구현
}
