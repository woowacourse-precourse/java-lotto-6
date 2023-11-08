package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Result {
    static List<Integer> hit_list;
    static int bonus_ball;
    static int[] total_count;
    List<Integer>[] lotto_list;

    public Result(List<Integer>[] lotto_lis){
        lotto_list = lotto_lis;
    }
    void Play_Result(){
        //malloc_arr();
        total_count= new int[6];
        for(int i=0; i<6; i++)
            total_count[i]=0;

        receive_hit_num();
        System.out.println("당첨 통계\n---");
        //List<Integer>[] lotto_list = Application.return_lotto_list();
        for(int i=0; i< lotto_list.length ; i++){
            int hit_count = check_hit_count(lotto_list[i]);
           // hit_print(hit_count, lotto_list[i]);
        }
        print_result();
        double result = cal_result(lotto_list.length);
        System.out.println("총 수익률은 "+String.format("%.1f",result)+"%입니다.");
    }
    void receive_hit_num(){
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                int new_hit =Integer.parseInt(st.nextToken());
                if(hit_list.contains(new_hit))
                    throw new IllegalArgumentException();
                hit_list.add(new_hit);
            }
            System.out.println("보너스 번호를 입력해 주세요.");
            bonus_ball = Integer.parseInt(br.readLine());
        } catch(IOException e){

        }
    }

    int check_hit_count(List<Integer> list) {
        int hit_cnt = 0;
        for (int j = 0; j < hit_list.size(); j++) {
            if (list.contains(hit_list.get(j)))
                hit_cnt++;
        }
        if (hit_cnt < 5) {
            total_count[hit_cnt - 3]++;
            return hit_cnt;
        }
        if (hit_cnt == 6) {
            total_count[hit_cnt - 2]++;
            return hit_cnt;

        }
        if (IsBonusHit(list)){
            total_count[hit_cnt - 2]++;
            return hit_cnt;
        }
        total_count[hit_cnt -3]++;

       return 1;
    }

    Boolean IsBonusHit(List<Integer> list){
        Boolean bonus_hit=false;
        if(list.contains(bonus_ball))
            bonus_hit=true;
        return bonus_hit;
    }
    void malloc_arr(){
        total_count= new int[6];
        for(int i=0; i<6; i++)
            total_count[i]=0;
    }

    void print_result(){
        System.out.println("3개 일치 (5,000원) - "+"개");
        System.out.println("4개 일치 (50,000원) - "+"개");
        System.out.println("5개 일치 (1,500,000원) - "+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+"개");


    }
    double cal_result(int lotto_count){
        double result=0.0;
        result += 5000* total_count[0];
        result += 50000* total_count[1];
        result+= 1500000 * total_count[2];
        result += 30000000*total_count[3];
        result += 2000000000*total_count[4];
        return result;
    }

}
