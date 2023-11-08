package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Random {
    private int lottoNumber;
    private List<Integer> lottoNumbers;

    public int generateLottoNumber(int startNumber, int endNumber) {
        lottoNumber = pickNumberInRange(startNumber, endNumber);
        return lottoNumber;
    }

    public List<Integer> generateLottoNumbers() {
        int lottoNumberCount = 6;
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        while (lottoNumbers.size() < lottoNumberCount) {
            int lottoNumber = generateLottoNumber(1,45);
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        return lottoNumbers;
    }
}
