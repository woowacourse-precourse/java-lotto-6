package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.EnumRanking;
import lotto.model.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class ControlMain {

    private List<List<Integer>> mainLotto = new ArrayList<>();

    public ControlMain() {
        Player player = new Player();
        priceLotto(player);
        buyLotto(player.getCount());

        Lotto lotto = new Lotto(setChoiceLottoNum());

        bonusNumAdd(lotto.getNumbers(), player);

        equalsNumber(mainLotto, lotto.getNumbers(), player);
        EnumRanking.Ranking.printSentence(player);
    }

    // 입력
    public void priceLotto(Player player) {
        System.out.println("구입금액을 입력해 주세요.");
        priceLottoTry(player);
    }

    public void bonusNumAdd(List<Integer> numbers, Player player) {
        System.out.println("보너스 번호를 입력해주세요.");
        bonusNumTry(numbers, player);
    }

    public List<Integer> setChoiceLottoNum() {
        System.out.println("당첨 번호를 입력해주세요.");
        return choiceLottoNumTry();
    }

    public List<Integer> randomLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 10, 6);
    }


    public void buyLotto(int count) {
        System.out.println();
        for (int i = 0; i < count; i++) {
            this.mainLotto.add(randomLottoNum());
        }
        OutputView.printBuyLotto(mainLotto, count);
    }


    public List<Integer> lottoNumbers(String[] choiceLottoNum) {
        ErrorCheck.stringArrChangeString(choiceLottoNum);
        ErrorCheck.stringChangeChar(choiceLottoNum);
        return setChoiceLottoNumbers(choiceLottoNum);
    }

    public List<Integer> setChoiceLottoNumbers(String[] choiceLottoNum) {
        List<Integer> choiceLottoNumbers = new ArrayList<>();
        for (int i = 0; i < choiceLottoNum.length; i++) {
            choiceLottoNumbers.add(Integer.parseInt(choiceLottoNum[i]));
        }
        return choiceLottoNumbers;
    }

    public void equalsNumber(List<List<Integer>> mainLotto, List<Integer> lottoNumber, Player player) {
        for (int i = 0; i < mainLotto.size(); i++) {
            int cnt = getLottoNumTotal(mainLotto.get(i), lottoNumber);
            player.updateMatchCountAndTotal(EnumRanking.Ranking.matchPoint(cnt, mainLotto.get(i), player));


        }
    }


    public int getLottoNumTotal(List<Integer> randomLotto, List<Integer> lottoNumber) {
        int cnt = 0;
        for (int i = 0; i < lottoNumber.size(); i++) {
            if (randomLotto.contains(lottoNumber.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public void playerUpdateBonusNumber(String choice, Player player) {
        int choiceInt = Integer.parseInt(choice);
        player.updateBonusNumber(choiceInt);
    }

    public void bonusNumAllError(String choice, List<Integer> numbers) {
        ErrorCheck.isSpaceValue(choice);
        ErrorCheck.isDigitErrorCheck(choice);
        ErrorCheck.isvalidateMaxAndMinNum(choice);
        ErrorCheck.isDuplicationErrorcheck(choice, numbers);
    }

    public void priceLottoAllError(String price) {
        ErrorCheck.isSpaceValue(price);
        ErrorCheck.isDigitErrorCheck(price);
        ErrorCheck.priceErrorCheck(price);
    }

    public List<Integer> choiceLottoNumTry() {
        boolean isTrue = false;
        List<Integer> numbers = new ArrayList<>();
        do {
            try {
                String[] choiceLottoNum = InputView.choiceMainLottoNum().split(",");
                numbers = lottoNumbers(choiceLottoNum);
                new Lotto(numbers);
                isTrue = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isTrue);
        OutputView.printNumbers(numbers);
        return numbers;
    }

    public void priceLottoTry(Player player) {
        do {
            try {
                String price = InputView.buyLotto();
                priceLottoAllError(price);
                int priceInt = Integer.parseInt(price);
                player.updatePrice(priceInt);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (player.getPrice() == 0);
    }

    public void bonusNumTry(List<Integer> numbers, Player player) {
        boolean isTrue = false;
        String choice ="";
        do {
            try {
                choice = InputView.choiceBonusLottoNum();
                bonusNumAllError(choice, numbers);
                playerUpdateBonusNumber(choice, player);
                isTrue = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isTrue);
        OutputView.printBonusNumber(choice);
    }
}
