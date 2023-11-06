package lotto.dataObjects;

import java.util.List;

import lotto.enumContainer.ErrorOperation;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateDupliCate(numbers);
		validateSizeOfCollection(numbers);
		this.numbers = numbers;
	}

	private void validateDupliCate(List<Integer> numbers) {
		boolean isDuplicate = numbers.stream()
			.distinct()
			.toList()
			.size() != 6;
		if (isDuplicate) {
			ErrorOperation.DUPLICATE_ERROR.apply();
		}
	}

	private void validateSizeOfCollection(List<Integer> numbers) {
		if (numbers.size() != 6) {
			ErrorOperation.COLLECTION_SIZE_ERROR.apply();
		}
	}
	// TODO: 추가 기능 구현
}
