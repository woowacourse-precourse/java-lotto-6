package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Ticket{
	
	private String win;
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
	
	public String getWin() {
		return this.win;
	}
	
	public int NonDuplicated_RandomNumber_Generator(List<Integer> Ticket_Number) {
		int PickNumber;
		do {
			PickNumber = Randoms.pickNumberInRange(Min_Number, Max_Number);
		} while(Ticket_Number.contains(PickNumber));
		return PickNumber;
	}
	
	public void winner(List<Integer> Lotto_Number, Integer Bonus_Number) {
		Integer Normal = 0;
		for(int o = 0 ; o < Len_Number; o++) {
			if(this.Ticket.contains(Lotto_Number.get(o))) {
				Normal ++;
			}
		}
		if(Normal == 6) {
			this.win="1등";
			return;
		}
		if(this.Ticket.contains(Bonus_Number)) {
			Normal ++;
		}
		this.win= Integer.toString(Normal) + "%d등";
	}
}

	

///