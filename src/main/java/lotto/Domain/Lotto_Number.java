package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Lotto_Number{
	
	private List<Integer> Lotto_Number; 
	private static final int Len_Number = 6;
	private static final int Min_Number = 1;
	private static final int Max_Number = 45;	
	
	public Lotto_Number() {
		
		for(int i =0; i< Len_Number; i++) {
			this.Lotto_Number.add(NonDuplicated_RandomNumber_Generator(this.Lotto_Number));
		}
	}
	public List<Integer> getNumber(){
		return Lotto_Number;
	}
		
	public int NonDuplicated_RandomNumber_Generator(List<Integer> Ticket_Number) {
		int PickNumber;
		do {
			PickNumber = Randoms.pickNumberInRange(Min_Number, Max_Number);
		} while(Ticket_Number.contains(PickNumber));
		return PickNumber;
	}

}