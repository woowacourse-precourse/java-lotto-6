package lotto.controller.validation.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberWithCharChecker {
	public void checkLottoNumberWithCharChecker(List<String> lottoNumberStringList) {
		try {
			lottoNumberStringList.stream().map(lottoNumberString -> Integer.parseInt(lottoNumberString)).collect(Collectors.toList());
		}
		catch (Exception exception){
			System.out.println(lottoNumberStringList.stream().map(lottoNumberString -> Integer.parseInt(lottoNumberString)).collect(Collectors.toList()));
			throw new IllegalArgumentException();
		}

	}
}
