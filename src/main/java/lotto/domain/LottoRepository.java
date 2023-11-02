package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class LottoRepository {
	
	private static final String DELIMITER = System.lineSeparator();
	
	private static final List<Lotto> lottos = new ArrayList<>();
	
	private LottoRepository() {
		throw new AssertionError();
	}
	
	public static List<Lotto> getLottos(){
		return Collections.unmodifiableList(lottos);
	}
	
	public String printLottoNumbers() {
		StringJoiner strJoiner = new StringJoiner(DELIMITER);
		
		for(Lotto lotto : lottos) {
			strJoiner.add(lotto.printNumbers());
		}
		
		return strJoiner.toString();
	}
	
	public static void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}
	
    public static void deleteAll() {
    	lottos.clear();
    }
}
