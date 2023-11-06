package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
	
	private List<Lotto> purchasedLotteries = new ArrayList<>();
	private int purchaseAmount;
	private long prizeAmount = 0;
	private double yieldRate = 0;
	
	public Buyer(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	public void buyLotto(Lotto lotto) {
		purchasedLotteries.add(lotto);
	}
	
	public List<Lotto> getPurchasedLotteries() {
		return purchasedLotteries;
	}
	
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	
	public long getPrizeAmount() {
		return prizeAmount;
	}
	
	public double getYieldRate() {
		return yieldRate;
	}

}
