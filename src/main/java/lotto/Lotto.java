package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateLotteryNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLotteryNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호 내에 중복된 숫자가 있습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6자리가 아닙니다.");
        }
    }

    public int countMatchingNumbers(List<Integer> winning_numbers){
        int result = 0;
        for (int nbr : winning_numbers){
            if (numbers.contains(nbr)){
                result += 1;
            }
        }
        if (result < 0 | result > 6){
            throw new IllegalStateException("[Error] compare_lottery_numbers의 결과값이 0-6사이가 아닙니다.");
        }
        return result;
    }
    public int isBonusNumberMatched(int nbr){
        if (numbers.contains(nbr)){
            return 1;
        }
        return 0;
    }
    public int determinePrizeRank(List<Integer> winning_numbers, int bonus_number){
        int lottery_count = countMatchingNumbers(winning_numbers);
        int bonus_count = isBonusNumberMatched(bonus_number);

        if (lottery_count == 6) return 1;
        if (lottery_count == 5 & bonus_count == 1) return 2;
        if (lottery_count == 5 & bonus_count == 0) return 3;
        if (lottery_count == 4) return 4;
        if (lottery_count == 3) return 5;
        return 0;
    }
    public void displayLotteryNumbers(){
        System.out.println(numbers);
    }
}