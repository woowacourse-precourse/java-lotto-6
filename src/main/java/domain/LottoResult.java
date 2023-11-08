package domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoResult {

    private Lotto lottoResultNumber;

    private int bonusNumber;

    public LottoResult() { // 실제 사용하는  생성자
        setLottoResultNumber(inputLotteryResultNumber());
        setBonusNumber(inputBonusResultNumber());
    }

    public LottoResult(String[] userInputNumber) { // 테스트코드용 생성자
        setLottoResultNumber(userInputNumber);
    }

    public LottoResult(String userInputNumber) { // 테스트코드용 생성자
        setBonusNumber(userInputNumber);
    }


    private String[] inputLotteryResultNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoResultNumber = readLine();
        String[] lottoResult = inputLottoResultNumber.split(",");
        System.out.println();
        return lottoResult;
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

    private String inputBonusResultNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = readLine();
        System.out.println();
        return inputBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void setBonusNumber(String inputBonusNumber) {
        int number = Integer.parseInt(inputBonusNumber);
        this.bonusNumber = number;
    }


}
