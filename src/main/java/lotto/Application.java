package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.generate.RandomGenerator;
import lotto.readInput.InputBonus;
import lotto.readInput.InputNumbers;
import lotto.readInput.InputPurchase;

public class Application {
	static int money;
	static int bonus;
	
    public static void main(String[] args) {//throws IllegalArgumentException {
    	
    	int number = InputPurchase.purchaseAmount();
    	RandomGenerator generator = new RandomGenerator(number/1000);
    	generator.print();
    	
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	List<Integer> winningNumbers = new ArrayList<>();
    	winningNumbers = InputNumbers.winningNumbers();
    	
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	int bonus = InputBonus.bonusNumber(winningNumbers);
    	
    	Lotto lotto = new Lotto(winningNumbers);
    
    	List<Integer> result = lotto.compare(generator.myLotto, bonus);
    	lotto.printResult(result);
    	lotto.rateOfReturn(result, number);
    	
    }
}
