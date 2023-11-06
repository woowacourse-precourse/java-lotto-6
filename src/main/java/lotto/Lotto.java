package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    
    public static int make_num() { //구매 수량 얻기
    	String n = Console.readLine();
    	int money = Integer.parseInt(n); //구매 금액
    	int num = money / 1000; //구매 수량
    	System.out.println();
    	System.out.println(num + "개를 구매했습니다.");
    	return num;
    }
    
    
    public static void make_lotto(int num) { //로또 번호 발
    	List<Integer>[] lottoArray = new List[num];
    	
    	for(int i = 0; i<num; i++) {
    		lottoArray[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    		Collections.sort(lottoArray[i]);
    		System.out.println(lottoArray[i]);
    	}

    }
    
}
