package lotto.Domain;

import java.util.*;
import lotto.View.*;

import camp.nextstep.edu.missionutils.*;

public class Lotto_Number{
	
	private List<Integer> lotto_Number = new ArrayList<Integer>(); 
	private Integer Bonus_Number;
	private static final int Len_Number = 6;
	private static final int Min_Number = 1;
	private static final int Max_Number = 45;	
	
	public Lotto_Number() {
		this.lotto_Number = InputView.Lotto_Number();
	}
	public void Bonus_number() {
		this.Bonus_Number = InputView.Lotto_Bonus_Number();
	}
	
	public List<Integer> get_Lotto() {
		return this.lotto_Number;
	}
	public Integer get_Bonus() {
		return this.Bonus_Number;
	}
	

}