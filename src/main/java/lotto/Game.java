package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    int money, count;
    List<Lotto> buy = new ArrayList<>();
    Lotto answer; int bonus;

    private void start(){
        System.out.println("구입 금액을 입력해 주세요.");
        this.money = Integer.parseInt(Console.readLine());
        this.count = this.money/1000;
    }

    private void generate(){
        System.out.println(this.count+"개를 구매했습니다.");
        for(int i=0;i<this.count;i++){
            //로또 생성
            buy.add(new Lotto(random()));
            buy.get(i).printInfo();
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
        answer = new Lotto(list);

    }

    private void userBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonus = Integer.parseInt(Console.readLine());
    }

    public void DoIt(){
        start();
        generate();
        userWinning();
        userBonus();
    }
}
