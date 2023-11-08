package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Enum.Rank;
import java.util.Map;

public class LottoManage {
    //구입한 로또번호 저장
    private final int FIRSTREWARD=2000000000;
    private final int SECONDREWARD=30000000;
    private final int THIRDREWARD=1500000;
    private final int FOURTHREWARD=50000;
    private final int FIFTHREWARD=5000;
    private List<Lotto> lottos;

    //당첨번호
    private Lotto correct_lotto;
    private int bonus;
    private int money;

    private int prize=0;
    private double prize_percent=0;

    private Map<Rank,Integer> rankCounts=new HashMap<>() {{
        put(Rank.FIRST,0);
        put(Rank.SECOND,0);
        put(Rank.THIRD,0);
        put(Rank.FOURTH,0);
        put(Rank.FIFTH,0);
        put(Rank.SIXTH,0);
    }};

    public LottoManage(String input){
        //입력받은 돈 money에 저장
        try {
            this.money=Integer.parseInt(input);
            validate();
            int ticket= money/1000;

            //로또 번호 생성
            lottos=new ArrayList<>();
            for (int i=0;i<ticket;i++){
                buy_Lotto();
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    //사용자가 입력한 돈이 올바른지 판단하는함수
    private void validate(){
        if(money<0||money%1000!=0){
            throw new IllegalArgumentException();
        }
    }

    //correct_lotto와 bonus를 저장하는 함수
    public void setCorrect_lotto(List<Integer> input){
        this.correct_lotto=new Lotto(input);
    }
    public void setBonus(int input){
        this.bonus=input;
    }

    //money값에 따라 lotto를 생성하는 함수
    private void buy_Lotto(){
        List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
        lottos.add(new Lotto(numbers));
    }

    //보유한 로또의 수량과 내용을 출력하는 함수
    public void print_lottos(){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto:lottos){
            lotto.print_lotto();
        }
    }

    public void checkLottoNumbers(){
        for (Lotto lotto:lottos){
            List<Integer>numbers =lotto.getNumbers();
            int matched_number_count=0;

            for (int num:numbers){
                if(correct_lotto.getNumbers().contains(num))
                    matched_number_count+=1;
            }
            // 등수 구하기
            countRanks(lotto.checkRank(matched_number_count,bonus));
        }
        setPrize();
        calculatemoney();
        printRankcounts();
    }

    private void countRanks(Rank rank){
        rankCounts.put(rank,rankCounts.get(rank)+1);
    }

    private void calculatemoney(){
        prize_percent=(double) prize/(double) money*100.0;
    }
    private void setPrize(){
        prize+=rankCounts.get(Rank.FIRST)*FIRSTREWARD;
        prize+=rankCounts.get(Rank.SECOND)*SECONDREWARD;
        prize+=rankCounts.get(Rank.THIRD)*THIRDREWARD;
        prize+=rankCounts.get(Rank.FOURTH)*FOURTHREWARD;
        prize+=rankCounts.get(Rank.FIFTH)*FIFTHREWARD;
    }
    private void printRankcounts(){
        System.out.println("3개 일치 (5,000원) - "+rankCounts.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - "+rankCounts.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+rankCounts.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+rankCounts.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+rankCounts.get(Rank.FIRST)+"개");
        System.out.println("총 수익률은 "+prize_percent+"%입니다.");
    }



}
