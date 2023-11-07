package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lotto.InputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
   /* public static Lotto buyLotto(Integer money, Customer customer) {
        if((money % 1000) != 0){
            throw new IllegalArgumentException("[ERROR] 천원 단위의 금액을 입력해 주세요");
        }
        System.out.println(money + "개를 구입했습니다.");
        Integer[] tmp = new Integer[6];
        for(int i=0; i< money/1000; i++){
            customer.addPocket(customer,makingLotto());
        }
        return lotto;
    }*/
    public static Lotto makingSingleLotto(){
        List<Integer> lottoList = new ArrayList<>(6);
        for(int i=0; i<6; i++){
            Integer rndnumber = Randoms.pickNumberInRange(1,45);
            lottoList.add(rndnumber);
        }
        Lotto singleLotto = new Lotto(lottoList);
        return singleLotto;
    }
}
