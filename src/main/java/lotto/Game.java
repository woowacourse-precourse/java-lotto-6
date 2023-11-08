package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    int money, count;
    List<Lotto> buy = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();

    private void start(){
        System.out.println("구입 금액을 입력해 주세요.");
        this.money = Integer.parseInt(Console.readLine());
        this.count = this.money/1000;
    }

    private void generate(){
        System.out.println(this.count+"개를 구매했습니다.");
        for(int i=0;i<this.count;i++){
            //로또 생성
        }
    }

    private List<Integer> random(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public void DoIt(){
        start();
        generate();
    }
}
