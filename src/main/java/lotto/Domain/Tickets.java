package lotto.Domain;

import java.util.*;

import lotto.Domain.*;

import camp.nextstep.edu.missionutils.*;

public class Tickets{
	
	private List<Ticket> tickets = new ArrayList<>();
	
	private static final int Len_Number = 6;
	private static final int Min_Number = 1;
	private static final int Max_Number = 45;
	
	public Integer Purchase_Number;
	private Integer win_prize;
	
	public Tickets(Integer Purchase_Number) {
		this.Purchase_Number=Purchase_Number;
		for (int i = 0 ; i<Purchase_Number; i++) {
			Ticket ticket = new Ticket();
			tickets.add(ticket);
			System.out.println(tickets.get(i).getNumber());
		}
	}
}