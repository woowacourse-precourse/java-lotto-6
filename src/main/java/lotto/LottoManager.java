package lotto;

import java.util.List;

public class LottoManager {
    BuyLotto buyLotto;
    InputLotto inputLotto;
    Lotto lotto;
    Bonus bonus;
    Result result;
    CompareLotto compareLotto;
    LottoManager(){
        init();
    }

    void init(){
        buyLotto = new BuyLotto();
        inputLotto = new InputLotto();
    }

    public void inputCost(){
        boolean validInput = false;
        while (!validInput) {
            try {
                int cost = buyLotto.lottoCost();
                buyLotto.numberOfLotto(cost);
                validInput = true;
            }catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자만 입력해주세요");
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위로 입력해주세요");
            }
        }
        buyLotto.showCount(buyLotto.getLottoCounts());
        buyLotto.showLotto(buyLotto.getLottoCounts());
    }

    public void inputWinningNumber(){
        String num = inputLotto.winningNumber();
        inputLotto.inputWinningNumber(num);
    }

    public void inputBonusNumber(){
        inputLotto.inputBonus(inputLotto.inputBonus());
    }

    public void checkLotto(){
        boolean validInput = false;
        while (!validInput) {
            try {
                lotto = new Lotto(inputLotto.getWinningNumber());
                validInput = true;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                inputWinningNumber();
            }
        }
    }

    public void checkBonus(){
        boolean validInput = false;
        while (!validInput) {
            try {
                List<Integer> bonusNumber = inputLotto.getBonusNumber();
                List<Integer> lottoNumber = inputLotto.getWinningNumber();
                bonus = new Bonus(bonusNumber, lottoNumber);
                validInput = true;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                inputBonusNumber();
            }
        }
    }

    public void checkResult(){
        compareLotto = new CompareLotto(lottoNumber(), bonusNumber());
        compareLotto.compare(userLotto());
        int[] ranking = compareLotto.getRanking();
        result = new Result(userCost());
        result.printRanking(ranking);
        String percentage = result.calculateEarningRate(ranking);
        System.out.printf("%s%s%s", "총 수익률은 ", percentage, "입니다");
    }

    private int bonusNumber(){
        return bonus.getNumber();
    }

    private int userCost(){
        return buyLotto.getCost();
    }

    private List<Integer> lottoNumber() {
        return lotto.getNumbers();
    }

    private List<List<Integer>> userLotto(){
        return buyLotto.getLottoList();
    }

}
