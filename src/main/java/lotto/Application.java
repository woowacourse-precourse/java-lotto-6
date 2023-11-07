package lotto;

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
    	
    	List<Integer> winningNumbers = InputNumbers.winningNumbers();
    	int bonus = InputBonus.bonusNumber(winningNumbers);
    	
    	Lotto lotto = new Lotto(winningNumbers);
    
    	List<Integer> result = lotto.compare(generator.myLotto, bonus);
    	lotto.printResult(result);
    	lotto.rateOfReturn(result, number);
    	
    }
}
