package lotto;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static lotto.Input.*;


public class Output {
    public static Map<Winner_Rank,Integer> total_winner = new LinkedHashMap<>();

    public static void init_map(){
        total_winner.put(Winner_Rank.ONE, 0);
        total_winner.put(Winner_Rank.TWO, 0);
        total_winner.put(Winner_Rank.THREE, 0);
        total_winner.put(Winner_Rank.FOUR, 0);
        total_winner.put(Winner_Rank.FIVE, 0);
    }

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

    public static void numbers_list_count(){//numbers_list를 돌며 Rank_Is()를 실행시킨다.
        init_map();
        for(int i = 0; i<numbers_list.size(); i++){
            int win_count = winning_count(i);
            int bonus_count = bonus_count(i);
            Winner_Rank rank = Rank_Is(win_count, bonus_count);
            total_winner.put(rank, total_winner.getOrDefault(rank, 0) + 1);
        }
        System.out.println(total_winner.toString());
    }

    public static Winner_Rank Rank_Is(int win_count, int bonus_count){//win_count 수를 바탕으로 TwoOrThree()를 실행시키거나 랭크값을 반환
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

    public static Winner_Rank TwoOrThree(int win_count, int bonus_count, Winner_Rank rank){//보너스 숫자 맞힘 여부로 2등과 3등을 판별하는 함수
        if(bonus_count ==1){
            rank = Winner_Rank.TWO;
            return rank;
        }
        rank = Winner_Rank.THREE;
        return rank;
    }

    public static int winning_count(int i){//winning값을 체크하는 함수
        List<Integer> numbers_lotto = numbers_list.get(i);
        int win_count = 0;
        for(int j = 0; j<numbers_lotto.size(); j++){
            if(winner.contains(numbers_lotto.get(j))){
                win_count++;
            }
        }
        return win_count;
    }
    public static int bonus_count(int i){//bonus값을 체크하는 함수
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
