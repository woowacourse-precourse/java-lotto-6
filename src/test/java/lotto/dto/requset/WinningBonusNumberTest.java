package lotto.dto.requset;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningBonusNumberTest {

	WinningBonusNumber winningBonusNumber = new WinningBonusNumber();

	@DisplayName("빈값이면 예외가 발생한다.")
	@Test
	void createWinningNumByEmpty() {
		assertThatThrownBy(() -> winningBonusNumber.setWinningNumber(""))
			.isInstanceOf(NullPointerException.class);
	}

	@DisplayName("숫자가 6개가 아니면 예외가 발생한다.")
	@Test
	void createWinningNumByCount() {
		assertThatThrownBy(() -> winningBonusNumber.setWinningNumber("1,2,3,4,5"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("중복값이 있으면 예외가 발생한다.")
	@Test
	void createWinningNumByDuplicate() {
		assertThatThrownBy(() -> winningBonusNumber.setWinningNumber("1,1,3,4,5,6"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("범위가 1과 45 사이가 아니면 예외가 발생한다.")
	@Test
	void createWinningNumByScope() {
		assertThatThrownBy(() -> winningBonusNumber.setWinningNumber("-1,1,3,4,5,46"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("성공 테스트")
	@Test
	void createWinningNumBySuccess() {
		assertThatCode(() -> winningBonusNumber.setWinningNumber("1,2,3,4,5,6"))
			.doesNotThrowAnyException();
	}

	@DisplayName("빈값이면 예외가 발생한다.")
	@Test
	void createBonusNumByEmpty() {
		assertThatThrownBy(() -> {
			winningBonusNumber.setWinningNumber("1,2,3,4,5,6");
			winningBonusNumber.setBonusNumber("");
		}).isInstanceOf(NullPointerException.class);
	}

	@DisplayName("범위가 1과 45 사이가 아니면 예외가 발생한다.")
	@Test
	void createBonusNumByScope() {
		assertThatThrownBy(() -> {
			winningBonusNumber.setWinningNumber("1,2,3,4,5,6");
			winningBonusNumber.setBonusNumber("46");
		}).isInstanceOf(IllegalArgumentException.class);
	}


	@DisplayName("승리번호와 보너스번호가 겹치면 오류가 발생한다.")
	@Test
	void createBonusNumByOverlap() {
		assertThatThrownBy(() -> {
			winningBonusNumber.setWinningNumber("1,2,3,4,5,6");
			winningBonusNumber.setBonusNumber("1");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("보너스번호 성공")
	@Test
	void createBonusNumBySuccess() {
		assertThatCode(() -> {
			winningBonusNumber.setWinningNumber("1,2,3,4,5,6");
			winningBonusNumber.setBonusNumber("7");
		}).doesNotThrowAnyException();
	}

	@DisplayName("승리숫자가 세팅이 안되면 예외")
	@Test
	void createBonusNumByWinningNumber() {
		assertThatThrownBy(() -> {
			winningBonusNumber.setBonusNumber("1");
		}).isInstanceOf(IllegalStateException.class);
	}



}