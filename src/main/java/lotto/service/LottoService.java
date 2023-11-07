package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public int createBonusNumber(List<LottoDto> lottoDtos, String commonInput) {
        for (LottoDto lottoDto : lottoDtos) {
            List<Integer> lottoNumbers = lottoDto.lottoRandomNumbers();
            validateBonusNumberCheck(lottoNumbers, commonInput);
        }
        return Integer.parseInt(commonInput);
    }

    public Map<Integer, Integer> findWinners(List<Integer> lottoWinningNumbers, int lottoBonusNumber,
            List<LottoDto> generateLottoNumbersDto) {
        List<Map<Integer, Integer>> lottoMatchCount = new ArrayList<>();
        for (LottoDto lottoDto : generateLottoNumbersDto) {
            Map<Integer, Integer> matchCount = lottoDto.matchCount(lottoWinningNumbers, lottoBonusNumber);
            lottoMatchCount.add(matchCount);
        }
        return topCount(lottoMatchCount);
    }

    public Map<Integer, Integer> topCount(List<Map<Integer, Integer>> lottoMatchCount) {
        return lottoMatchCount.stream()
                .max(Comparator.comparing(map -> map.keySet().stream().max(Integer::compareTo).orElse(0)))
                .orElse(Collections.emptyMap());
    }

    private void validateBonusNumberCheck(List<Integer> lottoNumbers, String commonInput) {
        if (lottoNumbers.contains(commonInput)) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    private void validateDuplicateWinningNumber(int originLength, int afterLength) {
        if (originLength != afterLength) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }
}
