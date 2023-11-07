package lotto.validator;

import java.util.List;

import lotto.message.ErrorMessage;

public class Validator {
//	xDUPLICATED_NUMBER("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
//	EMPTY_INPUT("[ERROR] 입력값이 없습니다."),
//	xLACK_LOTTONUMBER("[ERROR] 당첨 번호는 6개여야 합니다."),
//	xCONTAIN_LETTER("[ERROR] 숫자가 아닌 값을 입력했습니다."),
//	xSHORT_OF_MONEY("[ERROR] 1000원부터 로또 구매가 가능합니다.");
	
	public void DuplicatedNumber(List<Integer> numbers) {
		for(int i = 0; i < numbers.size(); i++) {
			if(numbers.contains(numbers)) {
				System.out.println(ErrorMessage.DUPLICATED_NUMBER);
		throw new IllegalArgumentException();
			}
		}
	}
	
	
	public void LottoSizeFormat(List<Integer> numbers) {
		if(numbers.size() != 6) {
			System.out.println(ErrorMessage.LACK_LOTTONUMBER);
			throw new IllegalArgumentException();
		}
	}
	
	public void NumberFormat(String number) {
		if (!number.matches("[+-]?\\d*(\\.\\d+)?")) {
			System.out.println(ErrorMessage.CONTAIN_LETTER);
			throw new IllegalArgumentException();
		}
	}
	
	public void availableMoneyFormat(int purchaseAmount) {
		if (purchaseAmount < 1000) {
			System.out.println(ErrorMessage.SHORT_OF_MONEY);
			throw new IllegalArgumentException();
		}
	}
}
