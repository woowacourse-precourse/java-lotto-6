package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.generate.RandomGenerator;

public class Application {
    public static void main(String[] args) {
    	System.out.println("구입금액을 입력해 주세요.");
    	int number = purchase();
    	
    	System.out.println("\n"+ number + "개를 구입했습니다.");
    	RandomGenerator generator = new RandomGenerator(number);
    	generator.print();
    	
    }
    
    public static int purchase() throws IllegalArgumentException {
    	int input;
    	while(true) {
    		try {
    			input = Integer.parseInt(Console.readLine());
    			if(input % 1000 != 0) {
    			throw new IllegalArgumentException();
    			}
    			break;
    		}catch(IllegalArgumentException e) {
    			System.out.println("[ERROR] 구입 금액은 1,000원의 배수여야 합니다.");
    		}
    	}
    	return input/1000; //발행할 로또 개수 반환
    }
    
    public static int inputNumbers() {
    	// 당첨 번호와 보너스 번호 입력받기
    	return 0;
    }
}
