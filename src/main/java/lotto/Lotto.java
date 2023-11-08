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

    // TODO: 추가 기능 구현
    public int checkPrize(List<Integer> winnerNumbers){
        int matchCount = 0;

        for (int number:numbers){
            for(int winner:winnerNumbers){
                if(number<winner){
                    break;
                }
                if(number==winner){
                    matchCount++;
                }
            }
        }

        return matchCount;
    }

    public boolean checkBonus(int bonus){
        for (int number:numbers){
            if(number==bonus){
                return true;
            }
        }
        return false;
    }

    public void printLottoNumbers(){
        System.out.println(numbers.toString());
    }
}
