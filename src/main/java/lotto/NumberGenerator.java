package lotto;

import java.util.List;

public class NumberGenerator {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    public void generateLottoNumbers() {
        lottoNumbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 7);
        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 6);
        bonusNumber = lottoNumbers.get(randomNumber); //보너스 번호를 추출
        lottoNumbers.remove(randomNumber); // 리스트에서 보너스 번호를 제거
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
