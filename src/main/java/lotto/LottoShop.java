package lotto;

public class LottoShop {

	private LottoMachine lottoMachine;

	public static LottoShop newInstance() {
		LottoMachine lottoMachine = new LottoMachine();
		return new LottoShop(lottoMachine);
	}

	public LottoShop(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}

	public void sellLotto(User user) {
		Integer money = user.payMoney();
		Lottos lottos = lottoMachine.buyLottos(money);
		lottos.print();
		user.receiveLottos(lottos);
	}
}
