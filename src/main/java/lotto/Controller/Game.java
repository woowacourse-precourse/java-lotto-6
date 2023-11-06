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
		Lotto_Number Lotto = new Lotto_Number();
		Budget budget = budget.
				Budget(InputView.Input_Budget());
		System.out.println(Lotto.getNumber());
	}
}

