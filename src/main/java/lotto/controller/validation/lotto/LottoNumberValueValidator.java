package lotto.controller.validation.lotto;

import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_FOCUS_NUMBER;
import static lotto.model.constant.StringSymbolicConstantEnum.SPLIT_POINT;

import java.util.Arrays;
import java.util.List;
import lotto.view.ErrorOutputView;

public class LottoNumberValueValidator {
	ErrorOutputView errorOutputView = new ErrorOutputView();
	LottoNumberStringEndChecker lottoNumberStringEndChecker = new LottoNumberStringEndChecker();
	LottoNumberWithCharChecker lottoNumberWithCharChecker = new LottoNumberWithCharChecker();
	LottoNumberCountChecker lottoNumberCountChecker = new LottoNumberCountChecker();
	LottoNumberRangeChecker lottoNumberRangeChecker = new LottoNumberRangeChecker();
	LottoNumberDuplicationChecker lottoNumberDuplicationChecker = new LottoNumberDuplicationChecker();

	public void checkStringValidationOfLottoNumber(String scannedLottoNumberListString) {
		checkLottoNumberListStringEndsWithNumber(scannedLottoNumberListString);
	}
	public void checkValidationOfLottoNumber(List<Integer> scannedLottoNumberListString) {
		checkLottoNumberCount(scannedLottoNumberListString);
	}

	private void checkLottoNumberListStringEndsWithNumber(String scannedLottoNumberListString) {
		try{
			char lastChar = scannedLottoNumberListString.charAt(scannedLottoNumberListString.length() - INDEX_FOCUS_NUMBER.getValue());
			lottoNumberStringEndChecker.checkLottoNumberStringEnd(lastChar);
		}
		catch (IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoNumberWithChar();
			throw illegalArgumentException;
		}
		checkLottoNumberWithChar(scannedLottoNumberListString);
	}

	private void checkLottoNumberWithChar(String scannedLottoNumberListString) {
		try{
			List<String> lottoNumberStringList = Arrays.asList(scannedLottoNumberListString.split(SPLIT_POINT.getValue()));
			lottoNumberWithCharChecker.checkLottoNumberWithCharChecker(lottoNumberStringList);
		}
		catch (IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoNumberWithChar();
			throw illegalArgumentException;
		}
	}


	private void checkLottoNumberCount(List<Integer> scannedLottoNumber) {
		try{
			lottoNumberCountChecker.checkLottoNumberCount(scannedLottoNumber);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoNumberCount();
			throw illegalArgumentException;
		}
		checkLottoNumberRange(scannedLottoNumber);
	}

	private void checkLottoNumberRange(List<Integer> scannedLottoNumberList) {
		try{
			Integer indexFocus = INDEX_FOCUS_NUMBER.getValue();
			lottoNumberRangeChecker.checkLottoNumberRange(scannedLottoNumberList, scannedLottoNumberList.size() - indexFocus);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoNumberRange();
			throw illegalArgumentException;
		}
		checkLottoNumberDuplication(scannedLottoNumberList);
	}


	private void checkLottoNumberDuplication(List<Integer> scannedLottoNumberList) {
		try{
			Integer indexFocus = INDEX_FOCUS_NUMBER.getValue();
			lottoNumberDuplicationChecker.checkLottoNumberDuplication(scannedLottoNumberList, scannedLottoNumberList.size() - indexFocus);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoNumberDuplication();
			throw illegalArgumentException;
		}
	}


}
