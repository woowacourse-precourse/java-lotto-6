package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	
	private List<Lotto> lottos = new ArrayList<Lotto>();
	
	public Lottos(){}
	public void addLotto(Lotto lotto) {
		this.lottos.add(lotto);
	}
	
	public List<Lotto> getLottos(){
		return this.lottos;
	}
	
	public int getSize() {
		return lottos.size();
	}
}

