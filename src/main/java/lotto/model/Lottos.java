package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private int numberOfLotto;
	private List<Lotto> lottos = new ArrayList<Lotto>();
	
	Lottos(){
		numberOfLotto = 0;
	}
	public void addLotto(Lotto lotto) {
		this.lottos.add(lotto);
		numberOfLotto++;
	}
	
	public int getNumberOfLotto() {
		return this.numberOfLotto;
	}
	
	public List<Lotto> getLottos(){
		return this.lottos;
	}
	
}

