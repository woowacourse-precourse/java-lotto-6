package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
	
	private static final List<Lotto> lottos = new ArrayList<>();
	
	public static List<Lotto> getLottos(){
		return Collections.unmodifiableList(lottos);
	}
	
	public static void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}
	
    public static void deleteAll() {
    	lottos.clear();
    }
}
