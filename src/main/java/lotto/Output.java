package lotto;
import java.util.List;
import static lotto.Input.*;


public class Output {

    public static void output_price(int lotto_count){
        System.out.println(lotto_count+"개를 구매했습니다.");
    }

    public static void output_lotto(List<List<Integer>> numbers_list){
        for(List<Integer> l : numbers_list){
            System.out.println(l.toString());
        }

    }

    public static void output_winning(){

    }

    public static void numbers_list_count(){
        for(int i = 0; i<numbers_list.size(); i++){
            int win_count = winning_count(i);
            int bonus_count = bonus_count(i);
            Winner_Rank rank = Rank_Is(win_count, bonus_count);
        }

    }
    public static Winner_Rank TwoOrThree(int win_count, int bonus_count, Winner_Rank rank){
        if(bonus_count ==1){
            rank = Winner_Rank.TWO;
            return rank;
        }
        rank = Winner_Rank.THREE;
        return rank;
    }

    public static Winner_Rank Rank_Is(int win_count, int bonus_count){
        Winner_Rank rank  = Winner_Rank.ZERO;
        if(win_count == 5){
            rank =  TwoOrThree(win_count, bonus_count, rank);
            return rank;
        }
        if(win_count<3){
            return rank;
        }
        rank = Winner_Rank.valueOfNumber(win_count);
        return rank;
    }

    public static int winning_count(int i){
        List<Integer> numbers_lotto = numbers_list.get(i);
        int win_count = 0;
        for(int j = 0; j<numbers_lotto.size(); j++){
            if(winner.contains(numbers_lotto.get(j))){
                win_count++;
            }
        }
        return win_count;
    }
    public static int bonus_count(int i){
        List<Integer> numbers_lotto = numbers_list.get(i);
        int bonus_count = 0;
        for(int j = 0; j<numbers_lotto.size(); j++){
            if(bonus_num == numbers_lotto.get(j)){
                bonus_count++;
            }
        }
        return bonus_count;
    }

}
