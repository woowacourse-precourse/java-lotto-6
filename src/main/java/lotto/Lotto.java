package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.validation.ErrorMessage;

public class Lotto {
	private List<Integer> numbers = new ArrayList<>();

	public Lotto(List<Integer> numbers) throws IllegalArgumentException {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_SIZE.getMessage());
		}

		if (numbers.stream().distinct().count() != 6) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DUPLICATION.getMessage());
		}
	}

	public List<Integer> compare(List<List<Integer>> myLotto, int bonus) { // 당첨번호와 발행된 로또 비교하여 당첨내역 반환
		List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

		for (List<Integer> lotto : myLotto) {
			boolean b = lotto.contains(bonus);
			lotto.retainAll(numbers);
			int size = lotto.size();
			int index = 0;
			//수정
			if (size < 3) {
				continue;
			}else if (size == 5 && b) {
				index = 3;
			}else if (size == 5 && !b) {
				index = 2;
			}else if (size == 4) {
				index = 1;
			}else if (size == 3) {
				index = 0;
			}else if (size == 6) {
				index = 4;
			}
			int value = result.get(index);
			result.set(index, value + 1);
		}
		return result;
	}

	public void printResult(List<Integer> result) {
		System.out.println("\n당첨 통계" + "\n---" 
				+ "\n3개 일치 (5,000원) - " + result.get(0) + "개" 
				+ "\n4개 일치 (50,000원) - "+ result.get(1) + "개"
				+ "\n5개 일치 (1,500,000원) - " + result.get(2) + "개"
				+ "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(3) + "개"
				+ "\n6개 일치 (2,000,000,000원) - " + result.get(4) + "개");
	}

	public void rateOfReturn(List<Integer> result, int purchase) { // 수익률 계산해서 반환
		List<Integer> income = new ArrayList<Integer>(List.of(5000, 50000, 1500000, 30000000, 2000000000));

		double totalIncome = 0;
		for (int i = 0; i < income.size(); i++) {
			totalIncome = totalIncome + income.get(i) * result.get(i);
		}
		System.out.println("총 수익률은 " + String.format("%.1f", totalIncome / purchase * 100) + "%입니다.");
	}
}
