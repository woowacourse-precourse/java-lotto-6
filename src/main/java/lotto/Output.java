package lotto;
import java.util.List;

public class Output {

    public static void output_price(int lotto_count){
        System.out.println(lotto_count+"개를 구매했습니다.");
    }

    public static void output_lotto(List<List<Integer>> numbers_list){
        for(List<Integer> l : numbers_list){
            System.out.println(l.toString());
        }

    }
}
