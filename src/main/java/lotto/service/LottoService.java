package lotto.service;

import static lotto.constants.LottoConstants.COMMA;
import static lotto.exception.Validator.validateBonusNumberCheck;
import static lotto.exception.Validator.validateDuplicateWinningNumber;
import static lotto.exception.Validator.validateWinningNumberLength;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class LottoService {

    public List<Integer> createWinningNumbers(String winningInputNumbers) {
        List<Integer> winningNumbers = winningNumberSplitter(winningInputNumbers);
        List<Integer> validateCheckOfWinningNumber = duplicatesWinningNumbers(winningNumbers);
        return new ArrayList<>(validateCheckOfWinningNumber);
    }

    public int createBonusNumber(List<Integer> generateLottoNumbers, String commonInput) {
        while (true) {
            try {
                validateBonusNumberCheck(generateLottoNumbers, Integer.parseInt(commonInput));
                return Integer.parseInt(commonInput);
            } catch (UserInputException e) {
                System.out.println(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMsg.ERROR_INPUT_NOT_NUMBER.getMsg());
            }
            commonInput = Console.readLine();
        }
    }

    public List<Map<Integer, Integer>> findWinners(List<Integer> lottoWinnerNumbers, int lottoBonusNumber,
            List<LottoDto> generateLottoNumbersDto) {
        System.out.println();
        List<Map<Integer, Integer>> lottoMatchCount = new ArrayList<>();
        for (LottoDto lottoDto : generateLottoNumbersDto) {
            Map<Integer, Integer> matchCount = lottoDto.matchCount(lottoWinnerNumbers, lottoBonusNumber);
            lottoMatchCount.add(matchCount);
        }
        return lottoMatchCount;
    }

    public List<Integer> duplicatesWinningNumbers(List<Integer> winningNumbers) {
        while (true) {
            Set<Integer> winningNumberDuplicates = new HashSet<>(winningNumbers);
            try {
                validateDuplicateWinningNumber(winningNumbers.size(), winningNumberDuplicates.size());
                return winningNumbers;
            } catch (UserInputException e) {
                System.out.println(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
            }
            String userRetryInput = Console.readLine();
            List<Integer> retryNumberFormat = winningNumberSplitter(userRetryInput);
            winningNumbers = retryNumberFormat;
        }
    }

    public List<Integer> winningNumberSplitter(String winningInputNumbers) {
        while (true) {
            try {
                List<Integer> winningNumbers = Arrays.stream(winningInputNumbers.split(COMMA))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateWinningNumberLength(winningNumbers.size());
                return winningNumbers;
            } catch (UserInputException e) {
                System.out.println(ErrorMsg.ERROR_LOTTO_NUMBERS_SIZE_MAX.getMsg());
            }
            String retryUserInput = Console.readLine();
            winningInputNumbers = retryUserInput;
        }
    }
}
