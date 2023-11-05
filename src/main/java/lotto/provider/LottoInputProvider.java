package lotto.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class LottoInputProvider {

	public LottoInputProvider() {
	}

	public int getInputPrice() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(Console.readLine());
	}

}