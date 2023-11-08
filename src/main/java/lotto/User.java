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

	//User의 getMoney와 중복됨. 어떻게 하는것이 좋을까
	public Money getMoney(){return this.pay;}
	public List<Lotto> getLottos(){
		return this.lottos;
	}
}
