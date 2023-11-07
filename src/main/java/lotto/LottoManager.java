package lotto;

import lotto.exception.ExceptionInfo;
import lotto.receiver.ConsoleLottoReceiver;
import lotto.receiver.LottoReceiver;

public class LottoManager {
	private static final int LOTTO_MINIMUM_PRICE = 1000;
	private static final int ZERO_CHANGE = 0;

	private final LottoReceiver lottoReceiver = new ConsoleLottoReceiver();

	private int purchasePrice;

	public void run() {
		// 가격 입력
		receivePurchasePrice();
		// 생성

		// 당첨 번호 입력

		// 보너스 번호 입력

		// 계산
		// 출력

	}

	private void receivePurchasePrice() {
		// 입력 요청문 출력
		boolean isReceived = Boolean.FALSE;
		while (!isReceived) {
			try {
				isReceived = validatePurchasePrice(lottoReceiver.receive());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private boolean validatePurchasePrice(String purchasePrice) {
		int validatedPurchasePrice = validatePurchasePriceIsIntegerType(purchasePrice);

		this.purchasePrice = validatePurchasePriceIsRightPrice(validatedPurchasePrice);

		return true;
	}

	private int validatePurchasePriceIsIntegerType(String purchasePrice) {
		try {
			return Integer.parseInt(purchasePrice);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionInfo.PURCHASE_PRICE_IS_NOT_INTEGER.getMessage());
		}
	}
	
	private int validatePurchasePriceIsRightPrice(int purchasePrice) {
		if (purchasePrice % LOTTO_MINIMUM_PRICE != ZERO_CHANGE) {
			throw new IllegalArgumentException(ExceptionInfo.PURCHASE_PRICE_IS_NOT_RIGHT_PRICE.getMessage());
		}

		return purchasePrice;
	}
}
