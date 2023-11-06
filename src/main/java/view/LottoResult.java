package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Integer> lottoResultNumber;

    private int bonusNumber;

    public LottoResult() {
        setLottoResultNumber(inputLotteryResultNumber());
    }

    public LottoResult(String[] userInputNumber) {
        setLottoResultNumber(userInputNumber);
    }

    public List<Integer> getLottoResultNumber() {
        return lottoResultNumber;
    }

    private String[] inputLotteryResultNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoResultNumber = readLine();
        String[] lottoResult = inputLottoResultNumber.split(",");
        return lottoResult;
    }

    private void setLottoResultNumber(String[] lottoResult) {
        this.lottoResultNumber = new ArrayList<>();
        for (String lottoResults : lottoResult) {
            int number = Integer.parseInt(lottoResults.trim());
            lottoResultNumber.add(number);
        }
    }


}
