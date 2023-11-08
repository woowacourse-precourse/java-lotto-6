package lotto.setting;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	int MIN = 1;
	int MAX = 45;
	private final List<Integer> numbers;
	List<Integer> autoNum;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.");
		}
		System.out.println(numbers);
	}

	// TODO: 추가 기능 구현
//	public List<Integer> lottoNumber() {
//		
//		List<Integer> num = numbers;
//		for(int i = 0 ; i < num.size() ; i++) {
//			System.out.println(num);
//			
//		}
//		return numbers;
//	}

	public List<Integer> lottoNum(int countMoney) {
		for (int i = 0; i < countMoney; i++) {
			autoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			System.out.println(autoNum);
		}
		return autoNum;
	}

}
