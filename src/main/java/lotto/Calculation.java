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
        Collections.sort(lotto_number);
        return lotto_number;
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
}
