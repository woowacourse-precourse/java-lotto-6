package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class LottoService {
    private final List<Lotto> lottos;
    private List<Integer> hit_number;
    private int bonus_number;
    private HashMap<Object, Object> resultMap = new HashMap<>();
    LottoService(List<Lotto> lottos){
        this.lottos = lottos;
        ReceiveHit();
        ReceiveBonus();
        this.resultMap = setResultMap();
    }

    void ReceiveHit(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> integerList = new ArrayList<>();
        try {
            integerList = Hitnumbers();
            checking_Error(integerList);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 당첨 번호가 중복되거나 45를 넘습니다.");
            ReceiveHit();
        }catch (IllegalStateException e){
            System.out.println("[ERROR] 당첨 번호는 6개여야합니다.");
            ReceiveHit();
        }
        this.hit_number = integerList;
    }

    void checking_Error(List<Integer> integerList){
        if(duplication(integerList))
            throw new IllegalArgumentException();
        if(rangeError(integerList))
            throw new IllegalArgumentException();
        if(lengthError(integerList))
            throw new IllegalStateException();
    }

    boolean lengthError(List<Integer> integerList){
        return integerList.size() != 6;
    }

    boolean duplication(List<Integer> integerList){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(integerList);
        return hashSet.size() != integerList.size();
    }

    boolean rangeError(List<Integer> integerList){
        for (Integer integer : integerList) {
            if (integer > 45)
                return true;
        }

        return false;
    }

    List<Integer> Hitnumbers(){
        String[] strings = Console.readLine().split(",");
        List<Integer> integerList = new ArrayList<>();
        for (String string : strings) {
            integerList.add(Integer.parseInt(string.trim()));
        }

        return integerList;
    }

    void ReceiveBonus(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int tmp = 0;
        try {
            tmp = bonus_number_input();
            if(hit_number_Error(tmp)) throw new IllegalArgumentException();
            if(rangeErrorBonus(tmp)) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호와 중복되거나 45를 넘습니다.");
            ReceiveBonus();
        }
        this.bonus_number = tmp;
    }

    boolean hit_number_Error(int num){
        return this.hit_number.contains(num);
    }

    boolean rangeErrorBonus(int num){
        return num > 45;
    }
    int bonus_number_input(){
        return Integer.parseInt(Console.readLine());
    }

    HashMap<Object, Object> setResultMap(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        for(int i = 0; i < 5; i++){
            hashMap.put(i + 1, 0);
        }
        return hashMap;
    }

    void Lotto_Result(){
        Lotto_Record();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultMap.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.get(4)+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.get(3)+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.get(2)+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.get(1)+ "개");
        String formattedTotalGain = String.format("%.1f", Gain_Cal()); // 소수 둘째 자리에서 반올림
        System.out.println("총 수익률은 " + formattedTotalGain + "%입니다.");
    }


    double Gain_Cal() {
        int gain = 0;
        for (int i = 1; i <= 5; i++) {
            gain += LottoPrice(i) * (int) resultMap.get(i);
        }
        int origin_cash = this.lottos.size() * 1000;
       // System.out.println(origin_cash);
       // System.out.println(gain);
        return 1.0 * gain / origin_cash * 100.0;
    }

    int LottoPrice(int grade){
        if(grade == 1) return LottoGrade.FIRST.getPrice();
        if(grade == 2) return LottoGrade.SECOND.getPrice();
        if(grade == 3) return LottoGrade.THIRD.getPrice();
        if(grade == 4) return LottoGrade.FOURTH.getPrice();
        return LottoGrade.FIFTH.getPrice();
    }
    void Lotto_Record(){
        for (Lotto lotto : this.lottos) {
            compare(lotto.getNumbers());
        }
    }
    void compare(List<Integer> nowLotto){
        int cnt = 0;
        for (Integer lotto : nowLotto) {            // 1 2 3 4 5 6
            if (this.hit_number.contains(lotto)) {  // 4 5 6 7 8 9
                cnt++;
            }
        }
        //System.out.println("log " + cnt);
        mapUpdate(cnt, nowLotto);
    }

    void mapUpdate(int cnt, List<Integer> lotto){
        if(cnt == 3) this.resultMap.put(5, (int) this.resultMap.get(5) + 1);
        if(cnt == 4) this.resultMap.put(4, (int) this.resultMap.get(4) + 1);
        if(cnt == 5) check_bonus(lotto);
        if(cnt == 6) this.resultMap.put(1, (int) this.resultMap.get(1) + 1);
    }

    void check_bonus(List<Integer> lotto){
        if(lotto.contains(this.bonus_number)){
            this.resultMap.put(2, (int)this.resultMap.get(2) + 1);
            return;
        }
        this.resultMap.put(3, (int)this.resultMap.get(3) + 1);
    }
}
