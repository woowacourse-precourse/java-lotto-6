package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoProcess {
    Validation validate = new Validation();
    private static final int numLottoNum = 6;
    private int quantityLotto;
    private Lotto[] lottos;
    private List<Integer> winningNumbers;
    private int bonusNum;

    private boolean checkValidBonusNum = true;
    private boolean checkValidWinningNum = true;
    
    public void setNumLotto() {
        quantityLotto = new BuyLotto().BuyLotto();
        printLotto();
        requestWinnigNumbers();
        requsetBonnusNum();
    }

    public void printLotto() {
        System.out.println("\n" + quantityLotto + "개를 구매했습니다.");
        issueLotto();
    }

    public void issueLotto() {
        lottos = new Lotto[numLottoNum];
        for (int i = 0; i < quantityLotto; i++) {
            List<Integer> lottoNumbers = generateLottoNum();
            System.out.println(lottoNumbers);
            lottos[i] = new Lotto(lottoNumbers);
        }
    }

    public List<Integer> generateLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public void requestWinnigNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        while (checkValidWinningNum) {
            try {
                String str = readLine();
                winningNumbers = transferWinningNumbers(str);
                checkValidWinningNum = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                checkValidWinningNum = true;
            }
        }
    }

    public List<Integer> transferWinningNumbers(String str){
        String[] strArr = str.split(",");
        List<Integer> winnigNumbers = new ArrayList<>();
        for (String s : strArr) {
            validate.validateIsNum(s);
            int winningNum = Integer.parseInt(s);
            validate.validateIsLottoNumRange(winningNum);
            winnigNumbers.add(winningNum);
        }
        validate.validateIsSIzeSix(winnigNumbers);
        return winnigNumbers;
    }

    public void requsetBonnusNum() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (checkValidBonusNum) {
            try{
                String str = readLine();
                validate.validateIsNum(str);
                bonusNum = Integer.parseInt(str);
                validate.validateIsLottoNumRange(bonusNum);
                checkValidBonusNum = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                checkValidBonusNum = true;
            }
        }
    }
}
