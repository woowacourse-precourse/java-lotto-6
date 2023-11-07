package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("로또 번호의 범위가 1~45 사이가 아니면 예외가 발생한다.")
	@Test
	void createLottoByInvalidRange() {
		assertThatThrownBy(()-> new Lotto(List.of(1,2,3,4,5,46)))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@DisplayName("당첨 번호 일치 갯수에 따른 등수를 리턴한다.")
	@Test
	void matchRank() {
		// given
		final int matchCount = 5;
		final boolean matchOfBonus = true;
		final Ranking rank = Ranking.SECOND; 
		
		// then
		 assertThat(Ranking.valueOf(matchCount, matchOfBonus)) // when
         .isEqualTo(rank);
	}
	
}