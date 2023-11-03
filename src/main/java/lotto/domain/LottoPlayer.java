package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Application;

public class LottoPlayer {
	public int ticketNumber;
	public void buyLotto() {
		System.out.println("구입 금액을 입력해 주세요.");
		Application.money = Console.readLine();
	}
	
	public void lottoTicket(String money) {
		ticketNumber = Integer.parseInt(money)/1000;
		System.out.println(ticketNumber + "개를 구매했습니다.");
	}
}
