package lotto.domain;

import lotto.util.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.LottoConfig.LOTTO_NUMBER_SPLIT_COMMA;

public class LottoWinningNumber {

    LottoValidation lottoValidation = new LottoValidation();

    public List<Integer> lottoWinningNumber(String winningNumber) {

        lottoWinningNumberValidation(winningNumber);

        String[] splitWinningNumber = winningNumber.split(LOTTO_NUMBER_SPLIT_COMMA.getContent());

        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : splitWinningNumber) {
            winningNumbers.add(Integer.parseInt(number));
        }

        lottoWinningNumberValidation(winningNumbers);

        return winningNumbers;
    }

    public int lottoBonusNumber(String bonusNumber, List<Integer> lottoNumbers) {

        lottoBonusNumberValidation(bonusNumber);
        lottoBonusNUmberValidation(bonusNumber, lottoNumbers);

        return Integer.parseInt(bonusNumber);
    }

    public void lottoWinningNumberValidation(List<Integer> lottoWinningNumbers) {

        lottoValidation.validatorDuplicatedNumber(lottoWinningNumbers);
        lottoValidation.validatorExceededRange(lottoWinningNumbers);

    }

    public void lottoWinningNumberValidation(String winningNumber) {

        lottoValidation.validatorWinningNumberCheck(winningNumber);

    }

    public void lottoBonusNumberValidation(String bonusNumber) {

        lottoValidation.validatorBonusOnlyNumber(bonusNumber);
        lottoValidation.validatorBonusExceedRange(bonusNumber);

    }

    public void lottoBonusNUmberValidation(String bonusNumber, List<Integer> lottoNumbers) {

        lottoValidation.validatorBonusDistinct(bonusNumber, lottoNumbers);

    }

}
