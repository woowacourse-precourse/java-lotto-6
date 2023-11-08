package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.text.DecimalFormat;

public class Lotto_Wallet {
    private List<Lotto> Lottos = new ArrayList<>();
    ;
    private HashMap<String, Integer> winning_count = new HashMap<>();

    // 생성자 winning_count에 각 등수별로 횟수를 0으로 초기회
    public Lotto_Wallet() {
        for (Prize p : Prize.values()) {
            winning_count.put(p.name(), 0);
        }
    }

    // 로또를 지갑에 넣기
    public void setLottos(Lotto lotto) {
        Lottos.add(lotto);
    }


    // 지갑에 든 모든 로또를 확인 -> HashMap 값을 변경
    // Check_All_Lotto에 Check_One_Lotto사용
    public void Check_All_Lotto(Lotto winning, Integer bonus) {
        for (Lotto my_lotto : Lottos) {
            Prize rank = Check_One_Lotto(my_lotto, winning, bonus);
            String rank_name = rank.name();
            int temp = winning_count.get(rank_name);
            winning_count.put(rank_name, temp + 1);
        }
    }

    // 1개의 로또 확인 : 내로또, 당첨로또, 보너스 번호를 입력 받아 -> Prize 등수 반환
    // Check_One_Lotto에 bonus_check, numbers_check, find_Rank 쓰임
    private Prize Check_One_Lotto(Lotto lotto, Lotto winning, Integer bonus) {
        List<Integer> my_nums = lotto.getNumbers();
        List<Integer> winning_nums = winning.getNumbers();

        int bonus_cnt = bonus_check(my_nums, bonus);
        int lotto_cnt = numbers_check(my_nums, winning_nums);

        return find_Rank(lotto_cnt, bonus_cnt);
    }

    // 보너스 번호 있는지 체크
    private int bonus_check(List<Integer> my_nums, Integer bonus) {
        if (my_nums.contains(bonus)) {
            return 1;
        }
        return 0;
    }

    // 로또 숫자만 몇 개 맞는지 체크
    private int numbers_check(List<Integer> my_nums, List<Integer> winning_nums) {
        int lotto_cnt = 0;
        HashSet<Integer> interA = new HashSet<>(my_nums);
        HashSet<Integer> interB = new HashSet<>(winning_nums);
        interA.retainAll(interB);
        return interA.size();
    }

    // 로또 중복수와 보너스 수로 랭킹 반환
    private Prize find_Rank(int lotto_cnt, int bonus_cnt) {
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


    // 당첨 결과 개수 프린트
    // Result_Print
    public void Result_Print() {
        System.out.print("\n당첨 통계\n---\n");
        for (Prize prize : Prize.values()) {
            // 등수 이름, 등수 횟수, 등수 액수
            String name = prize.name();
            if (name.equals("None")) continue;
            int cnt = winning_count.get(name);
            int price_amount = prize.getPrize();

            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedNumber = decimalFormat.format(price_amount);

            String total = prize.getMessage() + " (" + formattedNumber + "원) - " + cnt + "개\n";
            System.out.print(total);
        }
    }

    // 수익률 출력
    // print_Return에 RateOfReturn 사용
    public void print_Return(int n) {
        float ret = RateOfReturn(n);
        float rounded_ret = Round(ret, 1);
        System.out.print("총 수익률은 " + rounded_ret + "%입니다.\n");
    }

    // 로또 산 금액 대비 수익률 구함
    // RateOfReturn에 Round사용
    private float RateOfReturn(int n) {
        float cost = 1000 * n;
        float total_prize = 0;
        for (Prize prize : Prize.values()) {
            String name = prize.name();
            int individual_cnt = winning_count.get(name);
            int individual_prize = prize.getPrize();
            total_prize += individual_prize * individual_cnt;
        }
        return total_prize / cost * 100;
    }

    private float Round(float num, int under_dot) {
        double location = Math.pow(10, under_dot);
        return Math.round(num * location) / (float) location;
    }
}
