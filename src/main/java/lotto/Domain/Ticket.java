package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Ticket{
	
	private String win;
	private Integer win_prize;
	private List<Integer> Ticket_Number; 
	private static final int Len_Number = 6;
	private static final int Min_Number = 1;
	private static final int Max_Number = 45;	
	
	private List<Integer> Ticket_Code_Generate() {
		List<Integer> Ticket_Code= new ArrayList<>();
		for(int i =0; i< Len_Number; i++) {
			Ticket_Code.add(NonDuplicated_RandomNumber_Generator(Ticket_Code));
		}
		return Ticket_Code;
	}
		
	public int NonDuplicated_RandomNumber_Generator(List<Integer> Ticket_Number) {
		int PickNumber;
		do {
			PickNumber = Randoms.pickNumberInRange(Min_Number, Max_Number);
		} while(Ticket_Number.contains(PickNumber));
		return PickNumber;
	}

}