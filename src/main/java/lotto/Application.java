package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    static List<Integer>[] lotto_list ;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("구입금액을 입력해 주세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int purchase = Integer.parseInt(st.nextToken());
            purchase = purchase_lotto_count(purchase);
            lotto_list = new List[purchase];
            print_purchase_lotto(purchase);
            Result r = new Result(lotto_list);
            r.Play_Result();

        } catch(IOException e){

        }
    }
    static int purchase_lotto_count(int num){
        if(num%1000 != 0)
            throw new IllegalArgumentException();
        return (num/1000);
    }
    static void print_purchase_lotto(int lotto_num){
        System.out.println(lotto_num+"개를 구매했습니다.");
        for(int i=0; i< lotto_num ; i++){
            lotto_list[i]=new ArrayList<Integer>();
            lotto_list[i]= Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto_list[i].sort(Comparator.naturalOrder());
            print_lotto(lotto_list[i]);
        }
        System.out.println("");
    }
    static void print_lotto(List<Integer> lotto){
        System.out.print("[");
        for(int i=0; i<lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if(i+1 != lotto.size())
                System.out.print(", ");
        }
        System.out.println("]");
    }
    static List<Integer>[] return_lotto_list(){
        return lotto_list;
    }


}
