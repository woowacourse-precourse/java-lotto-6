package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
	
	// indent를 2까지만 허용하고 메서드의 길이가 15를 넘지 않아야함 -> 수정 필요!, 예외처리 메서드 분리하기
	public int getMoney() {
		int userMoney = 0;
		while (true) {
			try {
				String strUserMoney = Console.readLine();
				userMoney = Integer.parseInt(strUserMoney);
				
				if (userMoney % 1000 != 0) {
					throw new IllegalArgumentException("구입금액을 1,000원 단위로 다시 입력해 주세요.");
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] " + e.getMessage() + "\n");
			}
		}
		return userMoney;
	}
	// 예외처리 메서드 분리하기
	public List<Integer> getWinnersNumbers() {
		while (true) {
			try {
				String getWinNumbers = Console.readLine();
				String[] userWinnersNumbers = getWinNumbers.split(",");
				List<Integer> winNumbers = changeType(userWinnersNumbers);
				//쉼표 유무 및 6개의 숫자 예외처리
				if (winNumbers.size() != 6) {
					throw new IllegalArgumentException("6개의 숫자를 쉼표를 사용해서 다시 입력해주세요.");
				}
				// 중복 숫자 기입 예외처리(정렬후 인접한 값만 중복 확인하기)
				Collections.sort(winNumbers);
				for (int i = 0; i < winNumbers.size() - 1; i++) {
					if (winNumbers.get(i) == winNumbers.get(i + 1)) {
						throw new IllegalArgumentException("중복숫자는 피해서 다시 입력해주세요.");
		            }
				}
				// 1~45가 아닌 숫자 입력 예외처리
				for (int i = 0; i < winNumbers.size(); i++) {
					if (winNumbers.get(i) < 1 || winNumbers.get(i) > 45) {
						throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
					}
				}
				
				
				return winNumbers;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}
		}
	}
	
	public List<Integer> changeType(String[] numbers) {
		List<Integer> winnersNumbers = new ArrayList<Integer>();
		for (String wordNumbers : numbers) {
			int number = Integer.parseInt(wordNumbers);
			winnersNumbers.add(number);
		}
		return winnersNumbers;
	}
	
	// 예외처리 메서드 분리하기
	public int getBonusNumber(List<Integer> winnerNumber) {
		while (true) {
			try {
				String number = Console.readLine();
				int bonusNumber = Integer.parseInt(number);
				
				// 1~45가 아닌 숫자 입력 예외처리
				if (bonusNumber < 1 || bonusNumber > 45) {
					throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
				}
				// 당첨 번호와 중복되는 숫자 입력 예외처리
				for (Integer integer : winnerNumber) {
					if (integer == bonusNumber) {
						throw new IllegalArgumentException("당첨번호와 다른 번호를 다시 입력해주세요.");
					}
				}
				return bonusNumber;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] " + e.getMessage());
			}
		}
	}
	

}
