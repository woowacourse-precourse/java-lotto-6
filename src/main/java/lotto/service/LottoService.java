package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoDto;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class LottoService {

    public List<Integer> createWinningNumbers(String winningInputNumbers) {
        String[] winningNumberSplit = winningInputNumbers.split(",");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String winning : winningNumberSplit) {
            int winningParser = Integer.parseInt(winning);
            winningNumbers.add(winningParser);
        }
        validateDuplicateWinningNumber(winningNumberSplit.length, winningNumbers.size());
        return new ArrayList<>(winningNumbers);
    }

    private void validateDuplicateWinningNumber(int originLength, int afterLength) {
        if (originLength != afterLength) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public int createBonusNumber(List<LottoDto> lottoDtos, String commonInput) {
        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> lottoNumbers = lottoDto.lottoRandomNumbers();
            validateBonusNumberCheck(lottoNumbers, commonInput);
        }
        return Integer.parseInt(commonInput);
    }

    public void validateBonusNumberCheck(List<Integer> lottoNumbers, String commonInput) {
        if (lottoNumbers.contains(commonInput)) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public void findWinners(List<Integer> lottoWinningNumbers, int lottoBonusNumber,
            List<LottoDto> generateLottoNumbersDto) {
    }
}
