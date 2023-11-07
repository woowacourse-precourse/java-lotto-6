package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.generate.RandomGenerator;
import lotto.readInput.InputBonus;
import lotto.readInput.InputNumbers;
import lotto.readInput.InputPurchase;

public class Application {
    public static void main(String[] args) {
    	int number = InputPurchase.purchaseAmount();
    	RandomGenerator generator = new RandomGenerator(number/1000);
    	generator.print();
    	
    	List<Integer> winningNumbers = new ArrayList<>();
    	winningNumbers = InputNumbers.winningNumbers();
    	
    	int bonus = InputBonus.bonusNumber(winningNumbers);
    	
    	Lotto lotto = new Lotto(winningNumbers);
    
    	List<Integer> result = new ArrayList<>();
    	result = lotto.compare(generator.myLotto, bonus);
    	lotto.printResult(result);
    	lotto.rateOfReturn(result, number);
    	
    }
}
