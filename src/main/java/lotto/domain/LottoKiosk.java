package lotto.domain;

import lotto.domain.vo.Money;
import lotto.validation.Validator;
import lotto.validation.validators.InvalidAmount;
import lotto.validation.validators.LottoGameValidator;

public class LottoKiosk {
	private static final int LOTTO_PRICE = 1000;
	private final Money inputAmount;

	public LottoKiosk(int money) {
		Validator.of(new LottoGameValidator[]{
				new InvalidAmount()
		}).validate(money);
		this.inputAmount = new Money(money);
	}

	public Lotto perchaseLotto() {
		return new Lotto(lottoAmount());
	}

	public Money getInputAmount() {
		return this.inputAmount;
	}

	private int lottoAmount() {
		return inputAmount.money() / LOTTO_PRICE;
	}
}
