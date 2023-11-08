package lotto.model.service;

import static lotto.model.validator.AmountOfInvestmentValidator.checkAmountWithinLottoPriceRange;
import static lotto.model.validator.AmountOfInvestmentValidator.checkDivideByLottoPrice;
import static lotto.model.validator.AmountOfInvestmentValidator.checkType;
import static lotto.model.validator.BonusNumberValidator.checkDuplicateWithWinningNumbers;
import static lotto.model.validator.BonusNumberValidator.checkInRange;
import static lotto.model.validator.WinningNumberValidator.checkBlankOfLottoNumbers;
import static lotto.model.validator.WinningNumberValidator.checkDuplicateLottoNumbers;
import static lotto.model.validator.WinningNumberValidator.checkInRangeOfLottoNumbers;
import static lotto.model.validator.WinningNumberValidator.checkNumberOfLottoNumbers;

import java.util.Comparator;
import java.util.List;
import lotto.model.converter.IntegerConverter;
import lotto.model.converter.LongConverter;
import lotto.model.data.GameNumberFactory;
import lotto.model.data.Lotto;
import lotto.model.data.LottoPortfolio;
import lotto.model.data.WinningPortfolio;
import lotto.model.data.WinningStatus;
import lotto.model.generator.LottoNumberGenerator;

public class LottoService {
    private GameNumberFactory gameNumberFactory;
    private LottoPortfolio lottoPortfolio;

    public LottoService() {
        gameNumberFactory = new GameNumberFactory();
        lottoPortfolio = new LottoPortfolio();
    }

    public Integer validateAndConvertInvestmentAmount(String amountOfInvestment) {
        checkType(amountOfInvestment);
        Long convertedAmountOfInvestment = new LongConverter().toType(amountOfInvestment);
        checkAmountWithinLottoPriceRange(convertedAmountOfInvestment);
        checkDivideByLottoPrice(convertedAmountOfInvestment);
        
        return convertedAmountOfInvestment.intValue();
    }

    public Integer calculateNumberOfLottos(int amountOfInvestment) {
        return lottoPortfolio.createPayRecipe(amountOfInvestment);
    }

    public List<Lotto> purchaseLottos(Integer numberOfLotto, LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        return gameNumberFactory.quickPickOrSlip(numberOfLotto, lottoNumberGenerator, order);
    }

    public List<Integer> validateAndConvertWinningNumbers(List<String> winningNumbers) {
        checkNumberOfLottoNumbers(winningNumbers);
        checkBlankOfLottoNumbers(winningNumbers);
        List<Integer> convertedWinningNumbers = new IntegerConverter().toTypeList(winningNumbers);
        checkInRangeOfLottoNumbers(convertedWinningNumbers);
        checkDuplicateLottoNumbers(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    public Integer validateAndConvertBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        Integer convertedBonusNumber = new IntegerConverter().toType(bonusNumber);
        checkInRange(convertedBonusNumber);
        checkDuplicateWithWinningNumbers(winningNumbers, convertedBonusNumber);

        return convertedBonusNumber;
    }

    public void createWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        gameNumberFactory.saveWinningNumbers(winningNumbers, bonusNumber);
    }

    public WinningPortfolio evaluateWinnings() {
        WinningStatus winningStatus = gameNumberFactory.calculateWinningStatus();
        return lottoPortfolio.saveWinningStatus(winningStatus);
    }
}
