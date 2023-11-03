package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandNumber {
    public static List<Integer> makeRandNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public static List<Integer> makeBonusNumber() {
        List<Integer> bonusNumber = Randoms.pickUniqueNumbersInRange(1, 45, 1);
        return bonusNumber;
    }

    public static boolean checkDuplicate(List<Integer> lottoNumbers, List<Integer> bonusNumber) {
        Set<Integer> lottoNumbersWithNoDuplicate = new HashSet<>(lottoNumbers);
        if (lottoNumbersWithNoDuplicate.contains(bonusNumber.get(0))) {
            return false;
        }
        return true;
    }

    public static List<Integer> reMakeBonusNumber(List<Integer> lottoNumbers, List<Integer> bonusNumber) {
        if (!checkDuplicate(lottoNumbers, bonusNumber)) {
            List<Integer> newBonusNumber = makeBonusNumber();
            bonusNumber.set(0, newBonusNumber.get(0));
            reMakeBonusNumber(lottoNumbers, bonusNumber);
        }
        return bonusNumber;
    }


}
