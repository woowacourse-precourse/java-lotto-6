package creator;

import java.util.List;

import controller.InputMoney;
import controller.InputNumbers;
import controller.RunGame;
import controller.Statistics;
import lotto.Lotto;
import model.Data;
import view.Announcer;

public class ObjectCreator {
	
	public Lotto lottoCreator(List<Integer> numbers) {
		return new Lotto(numbers);
	}
	
	public InputMoney moneyCreator() {
		return new InputMoney();
	}
	
	public InputNumbers numbersCreator() {
		return new InputNumbers();
	}
	
	public Data dataCreator() {
		return new Data();
	}
	
	public RunGame runningCreator() {
		return new RunGame();
	}
	
	public Statistics statCreator(Data data) {
		return new Statistics(data);
	}
	
	public Announcer announcerCreator() {
		return new Announcer();
	}
}
