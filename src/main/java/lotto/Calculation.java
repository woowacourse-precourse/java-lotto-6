package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Calculation {
    public int get_game_count(int money) {
        if(money/1000 == 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력하세요."); 
        }
        return money/1000;
    }

    public List<Integer> generate_lotto() {
        List<Integer> lotto_number = new ArrayList<>();
        
        lotto_number = Randoms.pickUniqueNumbersInRange(1,45,6);

        List<Integer> sortNumber = new ArrayList<>(lotto_number);
        Collections.sort(sortNumber);
        return sortNumber;
    }

    public void generate_all_lotto_numbers(List<List<Integer>> all_numbers, int count) {
        List<Integer> user_lotto = new ArrayList<>();
        for(int i=0;i<count;i++) {
            user_lotto = generate_lotto();
            all_numbers.add(user_lotto);
        }
    }

    public int compare_number(List<Integer> user_number, List<Integer> lotto_number) {
        int count = 0;
        for(int number: user_number) {
            if(lotto_number.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void get_score(List<Integer> user_number, List<Integer> lotto_number, int bonus_number, int[] scoreBoard) {
        int score = 0;
        score = compare_number(user_number, lotto_number);
        
        if(score !=5) {
            scoreBoard[score] = scoreBoard[score]+1;
        }
        if(score == 5 && user_number.contains(bonus_number)) {
            scoreBoard[7] = scoreBoard[7]+1;
        }
    }

    public void get_all_score(List<List<Integer>> all_user_numbers, List<Integer> lotto_number, int bonus_number, int[] scoreBoard) {
        for(List<Integer> user_number:all_user_numbers) {
            get_score(user_number, lotto_number, bonus_number, scoreBoard);
        }
    }

    public int getAllPrize(int[] scoreBoard) {
        int prize = 0;
        prize = prize + getFifthPrize(scoreBoard[3]);
        prize = prize + getFourthPrize(scoreBoard[4]);
        prize = prize + getThirdPrize(scoreBoard[5]);
        prize = prize + getSecondPrize(scoreBoard[7]);
        prize = prize + getFirstPrize(scoreBoard[6]);

        return prize;

    }
    public int getFifthPrize(int grade) {
        return Prize.FIFTH.prize*grade;
    }
    public int getFourthPrize(int grade) {
        return Prize.FOURTH.prize*grade;
    }
    public int getThirdPrize(int grade) {
        return Prize.THIRD.prize*grade;
    }
    public int getSecondPrize(int grade) {
        return Prize.SECOND.prize*grade;
    }
    public int getFirstPrize(int grade) {
        return Prize.FIRST.prize*grade;
    }
}
