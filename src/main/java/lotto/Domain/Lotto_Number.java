package lotto.Domain;

import java.util.*;

import lotto.Exceptions.Exceptions;
import lotto.Utils.Parse;
import lotto.View.*;

public class Lotto_Number{
	
	private List<Integer> lotto_Number = new ArrayList<Integer>(); 
	private Integer Bonus_Number;
	
	public Lotto_Number() {
		this.lotto_Number = try_Number();
	}
	public void Bonus_number() {
		this.Bonus_Number = try_Bonus(this.lotto_Number);
	}
	
	public List<Integer> get_Lotto() {
		return this.lotto_Number;
	}
	public Integer get_Bonus() {
		return this.Bonus_Number;
	}
	
	public  List<Integer> try_Number() {
		String input= InputView.Lotto_Number();
		
		try {
			List<Integer> inputnumbers = Parse.List_Int(input);
			return inputnumbers;
		}catch(IllegalArgumentException e) {
			Exceptions.Number_Count_Valid(input,e);
			return try_Number();
		}
	}
	
	public  Integer try_Bonus(List<Integer> lotto_number) {
		try {
			String input = InputView.Lotto_Bonus_Number(lotto_number);
			Integer bonus = Integer.parseInt(input);
			return bonus;
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return try_Bonus(lotto_number);
		}
	}
}