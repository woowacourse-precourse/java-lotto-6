package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class OutputData {


    static int[] tickets_count=new int[5];

    //amount만큼의 배열 출력
    public static void printTickets(long amount){
        System.out.println("\n"+amount+"개를 구매했습니다.");

        for(int i=0;i<amount;i++){
            getTicketAndCount();
        }
    }

    //새로운 티켓을 발급하고 출력함수를 사용해 출력 후 일치비교함수 사용
    public static void getTicketAndCount(){
        List<Integer> random_numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        printTicket(random_numbers);
        //compareNumbers(Lotto.numbers,random_numbers,InputData.bonus_number);
    }

    //랜덤으로 뽑힌 티켓 오름차순 후 출력
    public static void printTicket(List<Integer> random_numbers){
        Collections.sort(random_numbers);
        System.out.println(random_numbers);
    }

    //일치 비교 함수
    public static void compareNumbers(List<Integer> numbers,List<Integer> random_numbers,int bonus_number){
        int count=0;
        for(int i=0;i<6;i++){
            if(random_numbers.contains(numbers.get(i)))
                count++;
        }
        if(count==5||random_numbers.contains(bonus_number))
            tickets_count[3]++;
        count-=3;
        if(count>=0)
            tickets_count[count]++;
    }


    //당첨 통계 출력
    public static void winStats(int[] tickets_count){
        System.out.println(Rank.FIFTH.getMent()+tickets_count[0]+Rank.FIFTH.getLastMent());
        System.out.println(Rank.FOURTH.getMent()+tickets_count[1]+Rank.FOURTH.getLastMent());
        System.out.println(Rank.THIRD.getMent()+tickets_count[2]+Rank.THIRD.getLastMent());
        System.out.println(Rank.SECOND.getMent()+tickets_count[3]+Rank.SECOND.getLastMent());
        System.out.println(Rank.FIRST.getMent()+tickets_count[4]+Rank.FIRST.getLastMent());

        System.out.printf("총 수익률은 %f%%입니다.",profitRate(tickets_count));
    }

    public static double profitRate(int[] tickets_count){
        //수익률 계산
        long sum=5000*tickets_count[0]+50000*tickets_count[1]+1500000*tickets_count[2]+30000000*tickets_count[3]+2000000000*tickets_count[4];

        return Math.round(sum/(InputData.amount*1000));
    }
}
