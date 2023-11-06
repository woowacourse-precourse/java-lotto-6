package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import lotto.generate.RandomGenerator;

public class Application {
    public static void main(String[] args) {
 
    	int number = purchase();
    	
    	RandomGenerator generator = new RandomGenerator(number);
    	generator.print();
    	
    	inputNumbers();
    	inputBonus();
    	
    	
    	
    }
    
    public static int purchase() throws IllegalArgumentException {
    	System.out.println("구입금액을 입력해 주세요.");
    	int input = Integer.parseInt(Console.readLine());
    	try {
			if(input % 1000 != 0) {
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 구입 금액은 1,000원의 배수여야 합니다.");
			purchase();
		}
    	return input/1000; //발행할 로또 개수 반환
    }
    
    public static List<Integer> inputNumbers() {
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	String input = Console.readLine();
    	int[] newArr = Stream.of(input.split(",")).mapToInt(Integer::parseInt).toArray();
    	List<Integer> list = IntStream.of(newArr).boxed().collect(Collectors.toList());
    	return list;
    }
    
    public static int inputBonus() {
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	int bonus = Integer.parseInt(Console.readLine());
    	return bonus;
    }
}
