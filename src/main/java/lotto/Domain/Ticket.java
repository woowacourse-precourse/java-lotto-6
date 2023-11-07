package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Ticket{
	
	private Integer correct;
	private boolean bonuscorrect; 
	private List<Integer> Ticket = new ArrayList<>();
	private static final int Len_Number = 6;
	private static final int Min_Number = 1;
	private static final int Max_Number = 45;	
	
	public Ticket() {
			
			for(int i =0; i< Len_Number; i++) {
				this.Ticket.add(NonDuplicated_RandomNumber_Generator(this.Ticket));
			}
			Collections.sort(Ticket);
	}
	public List<Integer> getNumber(){
		return this.Ticket;
	}
	
	public int getWin() {
		if(this.correct==6) {
			return 7;
		}
		if(this.bonuscorrect) {
			return correct+1;
		}
		return this.correct;
	}
	
	public int NonDuplicated_RandomNumber_Generator(List<Integer> Ticket_Number) {
		int PickNumber;
		do {
			PickNumber = Randoms.pickNumberInRange(Min_Number, Max_Number);
		} while(Ticket_Number.contains(PickNumber));
		return PickNumber;
	}
	
	public void winner(List<Integer> Lotto_Number, Integer Bonus_Number) {
		Integer correct = 0;
		for(int o = 0 ; o < Len_Number; o++) {
			if(this.Ticket.contains(Lotto_Number.get(o))) {
				correct ++;
			}
		}
		
		if(this.Ticket.contains(Bonus_Number)) {
			this.bonuscorrect = true;
		}
		this.correct = correct;
	}
}

	

///