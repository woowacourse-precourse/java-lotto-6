package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class Lottos { // 발행된 로또들의 모임
	
	private final List<Lotto> lottos;
	
	public Lottos(int amount){
		LottoGenerator lottoGenerator = new LottoGenerator();
		List<Lotto> lottos = new ArrayList<Lotto>();
		OutputView outputView = new OutputView();
		outputView.printLottoAmount(amount);
		while(amount-- > 0) {
			Lotto lotto = new Lotto(lottoGenerator.randomNumbers()); //로또 객체의 랜덤로또 생성
			outputView.printLotto(lotto.getnumbers());
			lottos.add(lotto);
		}
		this.lottos = lottos;
	}
	
	public List<Lotto> getLottos(){
		return this.lottos;
	}
}
