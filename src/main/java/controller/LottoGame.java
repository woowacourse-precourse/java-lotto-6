package controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoGame {
    static int numOfMatchNum(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List<Integer> matchNumbers = lottoNumbers.stream().filter(l -> winningNumbers.stream()
                .anyMatch(Predicate.isEqual(l))).toList();

        return matchNumbers.size();
    }

    static boolean ifBonusNumEqual(List<Integer> lottoNumbers, int bonusNum) {
        for (int lottoNum : lottoNumbers) {
            if (lottoNum == bonusNum)
                return true;
        }
        return false;
    }

}
