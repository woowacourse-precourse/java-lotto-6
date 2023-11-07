package lotto.Controller;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import lotto.*;
import lotto.Domain.Budget;
import lotto.Domain.Lotto_Number;
import lotto.View.InputView;


public class Game{
	
	//private Lotto lotto;
	
	public void run() {
		start();
	}

	
	

	
	
	public static void start() {
		Budget budget = new Budget(InputView.Input_Budget());
		Lotto_Number Lotto = new Lotto_Number();
		System.out.println(Lotto.getNumber());
		List<Integer> Win_Lotto = InputView.Lotto_Number();
		Integer Lotto_Bonus = InputView.Lotto_Bonus_Number();
		
	}
}

