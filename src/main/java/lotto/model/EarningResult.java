package lotto.model;

import static lotto.util.Constants.*;
import static lotto.util.PrintPhrase.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarningResult {
	private int totalThreeHit;
	private int totalFourHit;
	private int totalFiveHit;
	private int totalFiveWithBonusHit;
	private int totalSixHit;
	private int totalPrize;
	private double earningRate;
	private int budget;

	public EarningResult(int budget) {
		this.totalThreeHit = 0;
		this.totalFourHit = 0;
		this.totalFiveHit = 0;
		this.totalFiveWithBonusHit = 0;
		this.totalSixHit = 0;
		this.totalPrize = 0;
		this.earningRate = 0;
		this.budget = budget;
	}

	public void calculateEarningRate() {
		DecimalFormat decimalFormat = new DecimalFormat(FORMAT_ONE_DICIMAL);
		this.earningRate = Double.parseDouble(decimalFormat.format((double) totalPrize / budget * 100));
	}

	public void addHitThree() {
		this.totalThreeHit++;
		this.totalPrize += HIT_THREE_PRIZE;
	}

	public void addHitFour() {
		this.totalFourHit++;
		this.totalPrize += HIT_FOUR_PRIZE;
	}

	public void addHitFive() {
		this.totalFiveHit++;
		this.totalPrize += HIT_FIVE_PRIZE;
	}

	public void addHitFiveWithBonus() {
		this.totalFiveWithBonusHit++;
		this.totalPrize += HIT_FIVE_WITH_BONUS_PRIZE;
	}

	public void addHitSix() {
		this.totalSixHit++;
		this.totalPrize += HIT_SIX_PRIZE;
	}

	public int getTotalThreeHit() {
		return totalThreeHit;
	}

	public int getTotalFourHit() {
		return totalFourHit;
	}

	public int getTotalFiveHit() {
		return totalFiveHit;
	}

	public int getTotalFiveWithBonusHit() {
		return totalFiveWithBonusHit;
	}

	public int getTotalSixHit() {
		return totalSixHit;
	}

	public double getEarningRate() {
		return earningRate;
	}
}
