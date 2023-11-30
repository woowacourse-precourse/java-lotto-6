package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningDto;
import lotto.repository.LottoRepository;
import lotto.repository.WinningRepository;
import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final WinningRepository winningRepository;
    private final Validation validation;

    public LottoService(LottoRepository lottoRepository, WinningRepository winningRepository, Validation validation) {
        this.lottoRepository = lottoRepository;
        this.winningRepository = winningRepository;
        this.validation = validation;
    }

    public void issueLotto(String price) throws IllegalArgumentException {
        Integer number = validation.validatePriceAndReturnNumber(price);
        for (int i = 0; i < number; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoRepository.save(new Lotto(numbers));
        }
    }

    public List<Lotto> findAllLotto() {
        return lottoRepository.findAll();
    }

    public void issueWinning(String winningNumber, String bonusNumber) throws IllegalArgumentException {
        List<Integer> validatedWinning = validation.validateWinning(winningNumber);
        Integer validatedBonus = validation.validateBonus(bonusNumber, validatedWinning);
        Winning winning = new Winning(validatedWinning, validatedBonus);
        winningRepository.save(winning);
    }

    public WinningDto setWinningStatistics() {
        List<Lotto> lottos = lottoRepository.findAll();
        Winning winning = winningRepository.find();
        List<Integer> winningNumbers = winning.getWinningNumbers();
        Integer bonusNumber = winning.getBonusNumber();
        WinningDto winningDto = new WinningDto();

        calculateCoincidenceAndAddToWinningDto(lottos, winningNumbers, bonusNumber, winningDto);
        calculateAndSetEarningRate(lottos, winningDto);
        
        return winningDto;
    }

    
    private static void calculateCoincidenceAndAddToWinningDto(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber, WinningDto winningDto) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int coincidenceCount = calculateCoincidenceCount(winningNumbers, lottoNumbers);
            addCountToWinningDto(bonusNumber, winningDto, lottoNumbers, coincidenceCount);
        }
    }

    private static int calculateCoincidenceCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int coincidenceCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                coincidenceCount++;
            }
        }
        return coincidenceCount;
    }

    private static void addCountToWinningDto(Integer bonusNumber, WinningDto winningDto, List<Integer> lottoNumbers, int coincidenceCount) {
        if (coincidenceCount == 3) {
            winningDto.addCountThree();
        } else if (coincidenceCount == 4) {
            winningDto.addCountFour();
        } else if (coincidenceCount == 5) {
            if (lottoNumbers.contains(bonusNumber)) {
                winningDto.addCountFivePlusBonus();
            } else if (!lottoNumbers.contains(bonusNumber)) {
                winningDto.addCountFive();
            }
        } else if (coincidenceCount == 6) {
            winningDto.addCountSix();
        }
    }

    private static void calculateAndSetEarningRate(List<Lotto> lottos, WinningDto winningDto) {
        double totalPrize = winningDto.calculateTotalPrize();
        double earningRate = totalPrize / (lottos.size() * 1000) * 100;
        earningRate = Math.round(earningRate * 10) / 10.0; //소수점 둘째 자리에서 반올림한다
        winningDto.setEarningRate(earningRate);
    }
}
