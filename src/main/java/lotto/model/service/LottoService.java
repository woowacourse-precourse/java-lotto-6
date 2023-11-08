package lotto.model.service;

import java.util.List;
import lotto.model.converter.IntegerConverter;
import lotto.model.converter.LongConverter;
import lotto.model.data.AnswerNumbers;
import lotto.model.data.GameNumberFactory;
import lotto.model.data.Lotto;
import lotto.model.data.LottoPortfolio;
import lotto.model.data.WinningPortfolio;
import lotto.model.data.WinningStatus;
import lotto.model.generator.QuickPick;
import lotto.model.validator.AmountOfInvestmentValidator;
import lotto.model.validator.BonusNumberValidator;
import lotto.model.validator.WinningNumberValidator;

public class LottoService {
    private GameNumberFactory gameNumberFactory;
    private LottoPortfolio lottoPortfolio;

    public LottoService() {
        gameNumberFactory = new GameNumberFactory();
        lottoPortfolio = new LottoPortfolio();
    }

    public Integer convertAmountOfInvestment(String amountOfInvestment) {
        AmountOfInvestmentValidator.checkType(amountOfInvestment);
        Long convertedAmountOfInvestment = new LongConverter().toType(amountOfInvestment);
        AmountOfInvestmentValidator.checkAmountWithinLottoPriceRange(convertedAmountOfInvestment);
        AmountOfInvestmentValidator.checkDivideByLottoPrice(convertedAmountOfInvestment);
        
        return convertedAmountOfInvestment.intValue();
    }
    
    public Integer makeRecipe(Integer amountOfInvestment) {
        return lottoPortfolio.save(amountOfInvestment);
    }

    public List<Lotto> generateLottos(Integer amountOfLotto) {
        return gameNumberFactory.quickPickOrSlip(amountOfLotto, new QuickPick());
    }

    public List<Integer> convertWinningNumbers(List<String> winningNumbers) {
        WinningNumberValidator.checkNumberOfLottoNumbers(winningNumbers);
        WinningNumberValidator.checkBlankOfLottoNumbers(winningNumbers);
        List<Integer> convertedWinningNumbers = new IntegerConverter().toTypeList(winningNumbers);
        WinningNumberValidator.checkInRangeOfLottoNumbers(convertedWinningNumbers);
        WinningNumberValidator.checkDuplicateLottoNumbers(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    public Integer convertBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        Integer convertedBonusNumber = new IntegerConverter().toType(bonusNumber);
        BonusNumberValidator.checkInRange(convertedBonusNumber);
        BonusNumberValidator.checkDuplicateWithWinningNumbers(winningNumbers, convertedBonusNumber);

        return convertedBonusNumber;
    }

    public AnswerNumbers createWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        return gameNumberFactory.createWinningNumbers(winningNumbers, bonusNumber);
    }

    public WinningPortfolio confirmWin() {
        WinningStatus winningStatus = gameNumberFactory.compareLottosAndAnswerNumbers();
        return lottoPortfolio.addWinning(winningStatus);
    }
}
