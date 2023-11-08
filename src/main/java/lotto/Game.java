package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private int money, count;
    private List<Lotto> buy = new ArrayList<>();
    private Lotto answer; private int bonus;
    private int[] correct = new int[5];

    private void start(){
        System.out.println("구입 금액을 입력해 주세요.");
        this.money = Integer.parseInt(Console.readLine());
        this.count = this.money/1000;
    }

    private void generate(){
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
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> list = Arrays.stream(Console.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        this.answer = new Lotto(list);

    }

    private void userBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonus = Integer.parseInt(Console.readLine());
    }

    private void checkLottos(){
        for(int i=0;i<this.count;i++){
            // 중복 여부 확인
            checkLotto(this.buy.get(i).compareOther(this.answer), this.buy.get(i));
        }
    }
    private void checkLotto(int check_count, Lotto here){
        if(check_count ==3){this.correct[0] = this.correct[0]+1; }
        if(check_count ==4){this.correct[1] = this.correct[1]+1; }
        if(check_count ==5){
            this.correct[2] = this.correct[2]+1;
            checkFive(here);
        }
        if(check_count ==6){this.correct[4] = this.correct[4]+1; }

    }

    private void checkFive(Lotto here){
        if(here.containNum(this.bonus)){
            this.correct[2] = this.correct[2]-1;
            this.correct[3] = this.correct[3]+1;
        }
    }

    private double result(){
        double res_result=0;
        checkLottos();
        res_result = (this.correct[0]*5000)+(this.correct[1]*50000)+(this.correct[2]*1500000)+(correct[3]*30000000)+(correct[4]*2000000000);
        return ((double)res_result/(double)this.money)*100;
    }

    public void DoIt(){
        start();
        generate();
        userWinning();
        userBonus();
        System.out.println(result());
    }
}
