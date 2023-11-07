package creator;

import java.util.List;

import features.InputMoney;
import features.InputNumbers;
import features.RunGame;
import features.Statistics;
import lotto.Lotto;
import model.Data;
import validator.Validator_Lotto;
import validator.Validator_Money;
import validator.Provider;
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
	
	public Validator_Lotto validator_lotto(List<Integer> numbers) {
		return new Validator_Lotto(numbers);
	}
	
	public Validator_Money validator_money(String purchase_amount) {
		return new Validator_Money(purchase_amount);
	}
	
	public Validator_Lotto convertor() {
		return new Validator_Lotto();
	}
	
	public Validator_Lotto warning() {
		return new Validator_Lotto();
	}
}
