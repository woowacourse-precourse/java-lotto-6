package lotto.controller.lotto;

import static lotto.model.constant.StringSymbolicConstantEnum.SPLIT_POINT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.input.InputController;
import lotto.controller.validation.lotto.LottoNumberValueValidator;
import lotto.model.lotto.Lotto;
import lotto.view.MessageOutputView;

public class LottoNumberScanController {
	MessageOutputView messageOutputView = new MessageOutputView();
	InputController inputController = new InputController();
	LottoNumberValueValidator lottoNumberValueValidator = new LottoNumberValueValidator();
	public Lotto scanLottoNumber() {
		try{
			messageOutputView.printScanningLottoNumberMessage();
			String scannedLottoNumberListString = inputController.scanLottoNumberListString();
			lottoNumberValueValidator.checkStringValidationOfLottoNumber(scannedLottoNumberListString);
			List<String> lottoNumberStringList = Arrays.asList(scannedLottoNumberListString.split(SPLIT_POINT.getValue()));
			List<Integer> number = lottoNumberStringList.stream().map(string -> Integer.parseInt(string)).collect(Collectors.toList());
			return new Lotto(number);
		}
		catch(IllegalArgumentException illegalArgumentException){
			return scanLottoNumber();
		}
	}
}
