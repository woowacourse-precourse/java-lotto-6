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
    
    
    public static List<Integer>[] make_lotto(int num) { //로또 번호 받기
    	List<Integer>[] lottoArray = new List[num];
    	for(int i = 0; i<num; i++) {
    		lottoArray[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    		Collections.sort(lottoArray[i]);
    		System.out.println(lottoArray[i]);
    	}
    	return lottoArray;
    }
    
    public static int[] get_num() { //사용자 당첨 번호 입력값 받기 
    	System.out.println("당첨 번호를 입력해 주세요.");
    	String n = Console.readLine();
		String[] num = n.split(",");
		if (num.length != 6) { //6개 이외의 값을 넣었을 경우 
			throw new IllegalArgumentException();
		}
		int[] money = new int[6];
		for (int i = 0; i < 6; i++) {
			money[i] = Integer.parseInt(num[i]);
		}
		return money;
    }  
    
    public static int get_bonus() { //사용자 보너스번호 입력값 받기 
    	System.out.println("보너스 번호를 입력해 주세요.");
    	String n = Console.readLine();
		int bonus = Integer.parseInt(n);
		return bonus;
    }
    
    public static int[] compare_num(List<Integer>[] lotto, int[] num) { //로또확인 
    	int[] result = new int[lotto.length];
    	int[] boresult = new int[lotto.length];
    	for(int i=0; i<lotto.length; i++) {
    		for(int j=0; j<num.length; j++) {
    			if(lotto[i].contains(num[j])) {
    				result[i] ++; 
    			}
    		}
        	System.out.println(result[i]);
    	}
		return result;
    }
    
    public static int[] compare_bonus(List<Integer>[] lotto, int bonus) {
    	int[] boresult = new int[lotto.length];
    	for(int i=0; i<lotto.length; i++) {
    		for(int j=0; j<lotto.length; j++) {
    			if(lotto[i].contains(bonus)) {
    				boresult[i] = 1;
    			}
    		}
    	}
		return boresult;
    }
    
}
