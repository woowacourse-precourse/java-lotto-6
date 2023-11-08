package domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoResult {

    private Lotto lottoResultNumber;

    private int bonusNumber;

    public LottoResult(String[] lottoResultNumber, int bonusNumber) { // 실제 사용하는  생성자
        setLottoResultNumber(lottoResultNumber);
        setBonusNumber(bonusNumber);
    }

    public LottoResult(String[] userInputNumber) { // 테스트코드용 생성자
        setLottoResultNumber(userInputNumber);
    }

    public LottoResult(int userInputNumber) { // 테스트코드용 생성자
        setBonusNumber(userInputNumber);
    }

    public Lotto getLottoResultNumber() {
        return lottoResultNumber;
    }

    private void setLottoResultNumber(String[] lottoResult) {
        List<Integer> lottoResultNumber = new ArrayList<>();
        for (String lottoResults : lottoResult) {
            int number = Integer.parseInt(lottoResults.trim());
            lottoResultNumber.add(number);
        }
        this.lottoResultNumber = new Lotto(lottoResultNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(int inputBonusNumber) {
        int number = inputBonusNumber;
        this.bonusNumber = number;
    }


}
