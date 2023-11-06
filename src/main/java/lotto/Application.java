package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {


    }

    public static List<Lotto> makeRandomLotto(int number){
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            randomLottos.add(new Lotto(numbers));
        }
        return randomLottos;
    }

    public static int[] compareRandomLottosAndInputLotto(List<Lotto> randomLottos, int[] inputNumbers, int bonusNumber){
        int[] results=new int[6];
        for (int i = 0; i < randomLottos.size(); i++) results[compareOneLottoAndInputLotto(randomLottos.get(i), inputNumbers, bonusNumber)]++;
        return results;
    }
    public static int compareOneLottoAndInputLotto(Lotto lotto, int[] inputNumbers, int bonusNumber){
        List<Integer> numbers = lotto.getNumbers();
        int cnt=0;
        int result=0;
        for (int inputNumber : inputNumbers) if(numbers.contains(inputNumber)) cnt++;
        if(cnt==6) result=1;
        if (cnt==5&&numbers.contains(bonusNumber)) result=2;
        if(cnt==5)result=3;
        if(cnt==4)result=4;
        if(cnt==3)result=5;
        return result;
    }
}
