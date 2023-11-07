package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import lotto.generate.RandomGenerator;

public class Application {
	static int money;
	static int bonus;
	
    public static void main(String[] args) {
    	int number = purchase();
    	
    	RandomGenerator generator = new RandomGenerator(number);
    	generator.print();
    	
    	Lotto lotto = new Lotto(inputNumbers());
    	bonus = inputBonus();
    	lotto.validateBonus(bonus);
    	
    	List<Integer> result = lotto.compare(generator.myLotto, bonus);
    	lotto.printResult(result);
    	lotto.rateOfReturn(result, number*1000);
    	
    }
    
    public static int purchase() throws IllegalArgumentException {
    	System.out.println("구입금액을 입력해 주세요.");
    	money = Integer.parseInt(Console.readLine());
    	try {
			if(money % 1000 != 0) {
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 구입 금액은 1,000원의 배수여야 합니다.");
			purchase();
		}
    	return money/1000;
    }
    
    public static List<Integer> inputNumbers() {
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	List<Integer> list = null;
    	String input = Console.readLine();
    	try { //숫자인지 예외처리
    		int[] newArr = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
        	list = IntStream.of(newArr).boxed().collect(Collectors.toList());
    	}catch(NumberFormatException e) {
    		System.out.println("[ERROR] 숫자를 입력해 주세요.");
    		inputNumbers();
    	}
    	return list;
    }
    
    public static int inputBonus() {
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	try {
    		bonus = Integer.parseInt(Console.readLine());
    	}catch(NumberFormatException e) {
    		System.out.println("[ERROR] 숫자를 입력해 주세요.");
    		inputBonus();
    	}
    	return bonus;
    }
}
