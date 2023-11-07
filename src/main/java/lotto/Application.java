package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = Integer.parseInt(Console.readLine());
        int count = countLotto(money);
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0;i<count;i++){
            lottos.add(new Lotto(makeRandom()));
        }
    }

    //랜던값 만들기
    public static List<Integer>  makeRandom(){
        List<Integer> resRand = new ArrayList<>();
        while (resRand.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!resRand.contains(randomNumber)) {
                resRand.add(randomNumber);
            }
        }
        return resRand;
    }

    //해당 돈으로 얼마의 로또를 살 수 있는가
    public static int countLotto(int money){
        return money/1000;
    }
}
