package lotto.model.service;

import static lotto.model.validator.AmountOfInvestmentValidator.checkAmountWithinLottoPriceRange;
import static lotto.model.validator.AmountOfInvestmentValidator.checkDivideByLottoPrice;
import static lotto.model.validator.AmountOfInvestmentValidator.checkType;
import static lotto.model.validator.BonusNumberValidator.checkDuplicateWithWinningNumbers;
import static lotto.model.validator.BonusNumberValidator.checkInRange;
import static lotto.model.validator.WinningNumberValidator.checkBlankOfWinningNumbers;
import static lotto.model.validator.WinningNumberValidator.checkDuplicateWinningNumbers;
import static lotto.model.validator.WinningNumberValidator.checkInRangeOfWinningNumbers;
import static lotto.model.validator.WinningNumberValidator.checkNumberOfWinningNumbers;

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

/**
 * Model과 Controller 사이에서 기능을 연결하고 Controller에서 입력한 입력값의 유효성을 검증하는 책임이 있다.
 * 입력값의 유효성을 검증하고 로또를 생성, 비교하여 당첨 내역을 계산하는 기능과 연결하는 유틸을 제공한다.
 */
public class LottoService {
    private GameNumberFactory gameNumberFactory;
    private LottoPortfolio lottoPortfolio;

    /**
     * GameNumberFactory, LottoPortfolio의 객체를 생성한다.
     */
    public LottoService() {
        gameNumberFactory = new GameNumberFactory();
        lottoPortfolio = new LottoPortfolio();
    }

    /**
     * 투자금의 유효성을 검증하고 Integer로 변환하여 제공한다.
     *
     * @param amountOfInvestment 유효성이 검증되지 않은 String의 투자금
     * @return 유효성이 검증된 Integer의 투자금
     */
    public Integer validateAndConvertInvestmentAmount(String amountOfInvestment) {
        checkType(amountOfInvestment);
        Long convertedAmountOfInvestment = new LongConverter().toType(amountOfInvestment);
        checkAmountWithinLottoPriceRange(convertedAmountOfInvestment);
        checkDivideByLottoPrice(convertedAmountOfInvestment);
        
        return convertedAmountOfInvestment.intValue();
    }

    /**
     * 투자금을 기반으로 구입할 수 있는 로또의 개수를 계산한다.
     *
     * @param amountOfInvestment 투자금
     * @return 구입할 수 있는 로또의 개수
     */
    public Integer calculateNumberOfLottos(int amountOfInvestment) {
        return lottoPortfolio.createPayRecipe(amountOfInvestment);
    }

    /**
     * 구입한 로또의 개수만큼 로또를 만든다.
     *
     * @param numberOfLotto 구입한 로또의 개수
     * @param lottoNumberGenerator 로또 번호 생성기
     * @param order 로또 번호 생성 시 정렬 기준
     * @return 구입한 로또들
     */
    public List<Lotto> purchaseLottos(Integer numberOfLotto, LottoNumberGenerator lottoNumberGenerator, Comparator<Integer> order) {
        return gameNumberFactory.quickPickOrSlip(numberOfLotto, lottoNumberGenerator, order);
    }

    /**
     * 당첨 번호의 유효성을 검증하고 Integer의 리스트로 형변환하여 제공한다.
     *
     * @param winningNumbers 유효성이 검증되지 않은 String List 자료형의 당첨 번호
     * @return 유효성이 검증된 Integer List 자료형의 당첨 번호
     */
    public List<Integer> validateAndConvertWinningNumbers(List<String> winningNumbers) {
        checkNumberOfWinningNumbers(winningNumbers);
        checkBlankOfWinningNumbers(winningNumbers);
        List<Integer> convertedWinningNumbers = new IntegerConverter().toTypeList(winningNumbers);
        checkInRangeOfWinningNumbers(convertedWinningNumbers);
        checkDuplicateWinningNumbers(convertedWinningNumbers);

        return convertedWinningNumbers;
    }

    /**
     * 보너스 번호의 유효성을 검증하고 Integer로 형변환하여 제공한다.
     *
     * @param bonusNumber 유효성이 검증되지 않은 String 자료형의 보너스 번호
     * @param winningNumbers 보너스 번호와 중복 체크할 때 이용할 당첨 번호
     * @return 유효성이 검증된 Integer 자료형의 보너스 번호
     */
    public Integer validateAndConvertBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        Integer convertedBonusNumber = new IntegerConverter().toType(bonusNumber);
        checkInRange(convertedBonusNumber);
        checkDuplicateWithWinningNumbers(winningNumbers, convertedBonusNumber);

        return convertedBonusNumber;
    }

    /**
     * 당첨 번호와 보너스 번호를 이용하여 정답 번호를 저장한다.
     *
     * @param winningNumbers 당첨 번호
     * @param bonusNumber 보너스 번호
     */
    public void createAnswerNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        gameNumberFactory.saveAnswerNumbers(winningNumbers, bonusNumber);
    }

    /**
     * 당첨 내역을 계산하고 수익률이 업데이트 된 WinningPortfolio를 반환한다.
     *
     * @return 당첨 내역과 수익률이 업데이트 된 WinningPortfolio
     */
    public WinningPortfolio evaluateWinnings() {
        WinningStatus winningStatus = gameNumberFactory.calculateWinningStatus();
        return lottoPortfolio.saveWinningStatus(winningStatus);
    }
}
