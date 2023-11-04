package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이여야 합니다.");
        }
        if(duplicationCheck(numbers)){
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        if(!rangeCheck(numbers)){
            throw new IllegalArgumentException("1~45 범위를 넘어간 값이 있습니다.");
        }
    }

    // TODO: 추가 기능 구현

    private boolean duplicationCheck(List<Integer> numbers){
        HashSet<Integer> checkNumber = new HashSet<>(numbers);
        return checkNumber.size() != numbers.size();
    }

    private boolean rangeCheck(List<Integer> numbers){
        for(int rangeNumber : numbers){
            if(rangeNumber < 1 || rangeNumber > 45){
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int compareNumbers(List<Integer> winNumbers, int bonusNumber){
        int matchCount = 0;
        for(int number : numbers){
            if(winNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean bonusMatch(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoRank determineRank(int matchCount, boolean bonusMatch){
        switch (matchCount){
            case 6 : return LottoRank.FIRST;
            case 5 : return bonusMatch ? LottoRank.SECOND : LottoRank.THIRD;
            case 4 : return LottoRank.FOURTH;
            case 3 : return LottoRank.FIFTH;
            default : return LottoRank.NONE;
        }
    }

    enum LottoRank{
        FIRST(6,2_000_000_000),
        SECOND(5, 30_000_000),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000),
        NONE(0,0);

        private final int matchCount;
        private final int prize;

        LottoRank(int matchCount, int prize){
            this.matchCount = matchCount;
            this.prize = prize;
        }

        public int getMatchCount(){
            return matchCount;
        }

        public int getPrize(){
            return prize;
        }
    }
}
