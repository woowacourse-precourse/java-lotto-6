package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
	private final int minimumInclusive;
	private final int maximumInclusive;
	private final int randomAmount;

	public RandomNumberGenerator(int minimumInclusive, int maximumInclusive, int randomAmount) {
		this.minimumInclusive = minimumInclusive;
		this.maximumInclusive = maximumInclusive;
		this.randomAmount = randomAmount;
	}

	@Override
	public List<Integer> generate() {
		return Randoms.pickUniqueNumbersInRange(minimumInclusive, maximumInclusive, randomAmount);
	}

}
