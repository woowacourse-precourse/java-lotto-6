package lotto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto_Wallet {
    private List<Lotto> Lottos =  new ArrayList<>();;
    private HashMap<String, Integer> winning_count = new HashMap<>();

    public Lotto_Wallet(){
        for(Prize p : Prize.values()){
            winning_count.put(p.name(),0);
        }
    }
    public void setLottos(Lotto lotto) { // 로토를 지갑에 넣기
        Lottos.add(lotto);
    }

    // 지갑에 든 모든 로또를 확인 -> HashMap 값을 변경
    public void Check_All_Lotto(Lotto winning, Integer bonus){
        for(Lotto my_lotto : Lottos){
            Prize rank = Check_One_Lotto(my_lotto, winning, bonus);
            String rank_name = rank.name();
            int temp = winning_count.get(rank_name);
            winning_count.put(rank_name,temp+1);
        }
    }
    // 1개의 로또 확인 : 내로또, 당첨로또, 보너스 번호를 입력 받아 -> Prize 등수 반환
    public Prize Check_One_Lotto(Lotto lotto, Lotto winning, Integer bonus){
        List<Integer> my_nums = lotto.getNumbers();
        List<Integer> winning_nums = winning.getNumbers();

        int bonus_cnt = bonus_check(my_nums, bonus);
        int lotto_cnt = numbers_check(my_nums, winning_nums);

        return find_Rank(lotto_cnt, bonus_cnt);
    }
    private int bonus_check(List<Integer> my_nums, Integer bonus){ // 보너스 번호가 있는지 체크
        if (my_nums.contains(bonus)){ return 1;}
        return 0;
    }
    private int numbers_check(List<Integer> my_nums, List<Integer> winning_nums){ // 로또(보너스X) 당첨 개수 체크
        int lotto_cnt = 0;
        HashSet<Integer> interA = new HashSet<>(my_nums);
        HashSet<Integer> interB = new HashSet<>(winning_nums);
        interA.retainAll(interB);
        return interA.size();
    }
    private Prize find_Rank(int lotto_cnt,int bonus_cnt){      // 로또 중복수와 보너스 수로 랭킹 반환
        if (lotto_cnt == 6)
            return Prize.First;
        if (lotto_cnt == 5 && bonus_cnt == 1)
            return Prize.Second;
        if (lotto_cnt == 5)
            return Prize.Third;
        if (lotto_cnt == 4)
            return Prize.Fourth;
        if (lotto_cnt == 3)
            return Prize.Fifth;
        return Prize.None;
    }

    public void Result_Print(){
        System.out.print("\n당첨 통계\n---\n");
        System.out.print("3개 일치 (5,000원) - " + winning_count.get(Prize.Fifth.getPrize())+"\n");
        System.out.print("4개 일치 (50,000원) - " + winning_count.get(Prize.Fourth.getPrize())+"\n");
        System.out.print("5개 일치 (1,500,000원) - " + winning_count.get(Prize.Third.getPrize())+"\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winning_count.get(Prize.Second.getPrize())+"\n");
        System.out.print("6개 일치 (2,000,000,000원) - " + winning_count.get(Prize.First.getPrize())+"\n");
    }
}
