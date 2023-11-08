package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private int money, count;
    private List<Lotto> buy = new ArrayList<>();
    private Lotto answer; private int bonus;
    private HashMap<String, Integer> correct = new HashMap<>();

    private void input_Count(int money){
        if(money%1000 !=0){
            throw new IllegalArgumentException();
        }
        this.count = money / 1000;
    }

    private void start(){
        try{
            System.out.println("구입 금액을 입력해 주세요.");
            this.money = Integer.parseInt(Console.readLine());
            input_Count(this.money);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
            start();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입 금액은 1000으로 나눠 져야 합니다.");
            start();
        }
    }

    private void generate(){
        System.out.println();
        System.out.println(this.count+"개를 구매했습니다.");
        for(int i=0;i<this.count;i++){
            //로또 생성
            this.buy.add(new Lotto(random()));
            this.buy.get(i).printInfo();
        }
    }

    private List<Integer> random(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    private void userWinning(){
        try{
            List<Integer> list = new ArrayList<>();
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            list = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            this.answer = new Lotto(list);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 서로 다른 6개로 구성된 숫자 여야 합니다." );
            userWinning();
        }
    }

    private void userBonus(){
        do{
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            this.bonus = Integer.parseInt(Console.readLine());
        }while(!checkRange());
    }

    private boolean checkRange(){
        return (this.bonus >0 ) &(this.bonus<46);
    }

    private void initHash(){
        corType[] arr = corType.values();

        for (corType rb : arr) {
            this.correct.put(rb.toString(),0);
        }
    }

    private void checkLottos(){
        initHash();
        for(int i=0;i<this.count;i++){
            // 중복 여부 확인
            checkLotto(this.buy.get(i).compareOther(this.answer), this.buy.get(i));
        }
    }
    private void checkLotto(int check_count, Lotto here){
        if(check_count ==3){this.correct.replace("THREE" , this.correct.get("THREE")+1); }
        if(check_count ==4){this.correct.replace("FOUR" , this.correct.get("FOUR")+1);}
        if(check_count ==5){
            this.correct.replace("FIVE_V1" , this.correct.get("FIVE_V1")+1);
            checkFive(here);
        }
        if(check_count ==6){this.correct.replace("SIX" , this.correct.get("SIX")+1); }

    }

    private void checkFive(Lotto here){
        if(here.containNum(this.bonus)){
            this.correct.replace("FIVE_V1" , this.correct.get("FIVE_V1")-1);
            this.correct.replace("FIVE_V2" , this.correct.get("FIVE_V2")+1);
        }
    }

    private double result(){
        double res_result=0;
        checkLottos();
        res_result = (this.correct.get("THREE")*5000)+(this.correct.get("FOUR")*50000)+(this.correct.get("FIVE_V1")*1500000)+(this.correct.get("FIVE_V2")*30000000)+(this.correct.get("SIX")*2000000000);
        return ((double)res_result/(double)this.money)*100;
    }

    private void printResult(){
        double res_result = result();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        corType[] arr = corType.values();

        for (corType rb : arr) {
            System.out.println( rb.getValue()+this.correct.get(rb.toString())+"개");
//            this.correct.put(rb.toString(),0);
        }
        System.out.println("총 수익률은 "+String.format("%.1f", res_result) +"%입니다.");
    }

    public void DoIt(){
        start();
        generate();
        userWinning();
        userBonus();
        printResult();
    }

    public void Test_DoIt(){
        this.money = 8000;
        this.count = 8;
        this.buy.add( new Lotto( List.of(8, 21, 23, 41, 42, 43) ));
        this.buy.add( new Lotto(List.of(3, 5, 11, 16, 32, 38)) );
        this.buy.add( new Lotto( List.of(7, 11, 16, 35, 36, 44) ));
        this.buy.add( new Lotto( List.of(1, 8, 11, 31, 41, 42)) );
        this.buy.add( new Lotto( List.of(13, 14, 16, 38, 42, 45)) );
        this.buy.add( new Lotto( List.of(7, 11, 30, 40, 42, 43) ));
        this.buy.add( new Lotto( List.of(2, 13, 22, 32, 38, 45) ));
        this.buy.add( new Lotto( List.of(1, 3, 5, 14, 22, 45)) );


        userWinning();
        userBonus();

        try{
            printResult();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
