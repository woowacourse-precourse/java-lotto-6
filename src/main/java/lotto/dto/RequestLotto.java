package lotto.dto;

import java.util.List;

public record RequestLotto(
	List<Integer> numbers
) {

	public static RequestLotto of(final List<Integer> numbers) {
		return new RequestLotto(numbers);
	}

}
