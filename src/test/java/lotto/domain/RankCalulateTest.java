package lotto.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.service.RankCalculateService;

public class RankCalulateTest {

	RankCalculateService rankCalculateService = new RankCalculateService();
	LottoRepository lottoRepository = LottoRepository.getInstance();

	@BeforeEach
	void saveLottos() {
		WinningLotto winningLotto = WinningLotto.from(List.of("1", "2", "3", "4", "5", "6"), "7");
		lottoRepository.save(winningLotto);
		for (int i = 6; i < 8; i++) {
			lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, i)));
		}
		lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 11)));
		lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 10, 11)));
		lottoRepository.save(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
		lottoRepository.save(new Lotto(List.of(1, 2, 8, 9, 10, 11)));

	}


	@DisplayName("저장된 당첨로또와 로또들을 통해 당첨 등수를 잘 산출하는지 테스트")
	@Test
	void lottoRepository() {

		//when
		List<Rank> ranks = rankCalculateService.calculateRanks();
		//then
		Rank[] expectedRanks = Rank.values();
		for (Rank rank : expectedRanks) {
			Assertions.assertThat(ranks).contains(rank);
		}
	}

}
