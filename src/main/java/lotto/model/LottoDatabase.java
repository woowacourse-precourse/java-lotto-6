package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoDatabase {
	private List<Lotto> lottoDatabase = new ArrayList<>();

	public void add(Lotto lotto) {
		lottoDatabase.add(lotto);
	}

	public int size() {
		return lottoDatabase.size();
	}

	public Lotto getIndex(int index) {
		return lottoDatabase.get(index);
	}

	public void printLotto() {
		lottoDatabase.forEach(Lotto::printLotto);
	}

}
