package lotto.Domain;

import java.util.*;

public class Roe{
	public enum Ranking{
		RankOne("6개 일치", 2000000000,7),
		RankTwo("5개 일치", 30000000,6),
		RankThree("5개 일치", 1500000,5),
		RankFour("4개 일치", 50000,4),
		RankFive("3개 일치", 5000,3),
		;
	
	private final String correctnumber;
	private final double prizecash;
	private final Integer index;
	
	Ranking(String correctnumber, Integer prizecash, Integer index) {
		this.correctnumber = correctnumber;
		this.prizecash = prizecash;
		this.index = index;
		}

	public String CorrectNumber() {
		return correctnumber;
		}
	public double PrizeCash() {
		return prizecash;
		}
	public Integer Index() {
		return index;
	}
	}
	int[] win_count = new int[8];
	double cash;
	String roe;
	
	public Roe(List<Integer> Ticket_result, Integer Purchase_Number) {
		for(int i = 0; i < Purchase_Number; i++) {
			this.win_count[Ticket_result.get(i)]++;
			
		}
		this.cash =  win_count[Ranking.RankOne.Index()]*Ranking.RankOne.PrizeCash()
					+win_count[Ranking.RankTwo.Index()]*Ranking.RankTwo.PrizeCash()
					+win_count[Ranking.RankThree.Index()]*Ranking.RankThree.PrizeCash()
					+win_count[Ranking.RankFour.Index()]*Ranking.RankFour.PrizeCash()
					+win_count[Ranking.RankFive.Index()]*Ranking.RankFive.PrizeCash()
					;
		this.roe = String.format("%.1f", this.cash/Purchase_Number/1000);
	}
	
	public Integer get_Win_Count(Integer index) {
		return win_count[index];
	}
	public String get_Roe() {
		return roe;
	}
}

