package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
	
	// indent를 2까지만 허용하고 메서드의 길이가 15를 넘지 않아야함 -> 수정 필요!
	public int getMoney() {
		int userMoney = 0;
		while (true) {
			try {
				String strUserMoney = Console.readLine();
				userMoney = Integer.parseInt(strUserMoney);
				
				if (userMoney % 1000 != 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 구입금액을 1,000원 단위로 다시 입력해 주세요.\n");
			}
			
		}
		return userMoney;
	}
	

}
