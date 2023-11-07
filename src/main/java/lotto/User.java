//User.java
package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Money pay;
	private List<Lotto> lottos;

	public User(Money pay, List<Lotto> lottos){
		this.pay = pay;
		this.lottos = lottos;
	}

	public List<Lotto> getLottos(){
		return this.lottos;
	}
}
