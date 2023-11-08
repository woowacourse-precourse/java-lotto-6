package lotto;

public class earning {

	public static int calculateWholeEarning(int[] tickets){
		int wholeEarning = 0;

		int[] earningMoney = {5000, 50000, 1500000, 30000000, 2000000000};
		for (int i = 0; i < earningMoney.length; i++) {
			if (tickets[i] != 0){
				wholeEarning += tickets[i] * earningMoney[i];
			}
		}

		return wholeEarning;
	}

	public static String caculateRateOfReturn(int lottoWholeEarning, int convertedUserPurchaseAmount) {
		float rateOfReturn = (float) lottoWholeEarning / convertedUserPurchaseAmount * 100;
		String resultRateOfReturn = String.format("%.1f", rateOfReturn);
		return resultRateOfReturn;
	}

	public static void displayResultRateOfReturn(String resultRateOfReturn){
		System.out.println("총 수익률은 "+resultRateOfReturn+ "%입니다.");
	}
}
