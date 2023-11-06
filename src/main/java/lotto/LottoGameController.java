package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LottoGameController {

    private final List<Lotto> lottos = new ArrayList<>();
    User user;
    View view = new View();
    LottoGame lottoGame;
    Scanner sc = new Scanner(System.in);

    public void start(){

        setUser();
        setLotto();
        setLottoGame();

        checkWinner();

        view.printWinStat(lottoGame,user);

    }

    private void checkWinner() {

        for(Lotto lotto: lottos){

            int winNumber=0;
            int winBonus=0;
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> winningNumbers = lottoGame.getWinningNumbers();
            int bonus = lottoGame.getBonusNumber();

            winNumber = getWinNumber(winNumber, winBonus, numbers, winningNumbers, bonus);

            setRank(winNumber, bonus);

        }
    }

    private void setRank(int winNumber, int bonus) {

        if(winNumber == 6){

            lottoGame.addRank(WinningConditionPrize.FIRST);
            user.addWinningAmount(WinningConditionPrize.FIRST.getPrize());

            return;
        }

        if(winNumber == 5&& bonus == 1){

            lottoGame.addRank(WinningConditionPrize.SECOND);
            user.addWinningAmount(WinningConditionPrize.SECOND.getPrize());


            return;
        }

        if(winNumber == 5){

            lottoGame.addRank(WinningConditionPrize.THIRD);
            user.addWinningAmount(WinningConditionPrize.THIRD.getPrize());


            return;
        }

        if(winNumber == 4){

            lottoGame.addRank(WinningConditionPrize.FOURTH);
            user.addWinningAmount(WinningConditionPrize.FOURTH.getPrize());

            return;
        }

        if(winNumber == 3){

            lottoGame.addRank(WinningConditionPrize.FIFTH);
            user.addWinningAmount(WinningConditionPrize.FIFTH.getPrize());

        }
    }

    private int getWinNumber(int winNumber, int winBonus, List<Integer> numbers, List<Integer> winningNumbers,
                             int bonus) {
        for (int number: winningNumbers){

            if(numbers.contains(number)){

                winNumber++;
            }
            if (numbers.contains(bonus)){

                winBonus++;
            }
        }
        return winNumber;
    }

    private void setLottoGame() {

        List<Integer> winningNumbers = setWinningNumbers();
        int bonusNumber = setBonusNumber();

        lottoGame = new LottoGame(winningNumbers, bonusNumber);

    }

    private int setBonusNumber() {
        view.printAskBonusNumber();

        return sc.nextInt();
    }

    private List<Integer> setWinningNumbers() {

        view.printAskWinningNumber();

        String inputString = sc.next();
        String[] numbersString = inputString.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String numberString: numbersString){
            winningNumbers.add(Integer.valueOf(numberString));
        }
        return winningNumbers;
    }

    private void setLotto() {

        int lottoAmount = user.getAmountLotto();
        view.printPurchasedLottoAmount(lottoAmount);

        for (int i = 0; i<lottoAmount;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));

            view.printPurchasedLottoNumbers(lottos.get(i));

        }
    }


    private void setUser() {

        view.printAskMoneyInput();
        int inputMoney=0;
        try {
            StringTokenizer tk = new StringTokenizer(sc.next());
            inputMoney = Integer.parseInt(tk.nextToken());
        }catch (NumberFormatException e){
            System.out.println("[ERROR]");
            setUser();
        }

        user = new User(inputMoney);
    }

}
