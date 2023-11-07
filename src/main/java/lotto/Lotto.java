package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private final List<Integer> lottoNumbers;
	private final int LOTTO_LENGTH = 6;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicateNumber(numbers);
		this.lottoNumbers = numbers;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

	public List<Integer> getNumbers() {
		return lottoNumbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != LOTTO_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	private void validateDuplicateNumber(List<Integer> numbers) {
		Set<Integer> duplicated = new HashSet<>(numbers);
		if (duplicated.size() != LOTTO_LENGTH) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 당첨 번호와 보너스 번호를 인자로 받아서, 필드로 가지고 있는 로또 번호와 비교하고,
	 * 번호가 같으면 count ++ 한 후에 count에 맞는 RankEnum 리턴
	 * @param winnerNumber
	 * @param bonus
	 * @return 매치 횟수에 해당하는 RankEnum. 매치 횟수에 해당하는 RankEnum이 없을 경우 RankEnum.NONE을 반환합니다.
	 */
	public RankEnum checkRank(List<Integer> winnerNumber, int bonus) {
		long count = lottoNumbers.stream().filter(winnerNumber::contains).count();
		if (count == 5){
			if (!lottoNumbers.contains(bonus)){
				return RankEnum.THIRD;
			}
			return RankEnum.SECOND;
		}
		return RankEnum.getRankByMatchCount((int)count);
	}


}
