package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.EnumRanking;
import lotto.model.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ControllMain {
    List<List<Integer>> mainLotto = new ArrayList<>();

    public ControlMain() {
        Player player = new Player();
        priceLotto(player);
        buyLotto(player.getCount());
        Lotto lotto = setChoiceLottoNum();
        bonusNumAdd(lotto.getNumbers(), player);
        equalsNumber(mainLotto, lotto.getNumbers(), player);
        EnumRanking.Ranking.printSentence(player);
    }

    // 입력
    public void priceLotto(Player player) {
        System.out.print("구입금액을 입력해 주세요.");
        priceLottoTry(player);
    }

    public void bonusNumAdd(List<Integer> numbers, Player player) {
        System.out.println("보너스 번호를 입력해주세요.");
        bonusNumTry(numbers, player);
    }

    public Lotto setChoiceLottoNum() {
        System.out.println("당첨 번호를 입력해주세요.");
        return choiceLottoNumTry();
    }

    public List<Integer> randomLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    /// util 사는거
    public void buyLotto(int count) {
        System.out.println();
        for (int i = 0; i < count; i++) {
            this.mainLotto.add(randomLottoNum());
        }
        System.out.println(count + "개를 구매했습니다.");
        OutputView.printBuyLotto(mainLotto);
    }


    public List<Integer> lottoList(String[] choiceLottoNum) {
        ErrorCheck.stringArrChangeString(choiceLottoNum);
        ErrorCheck.stringChangeChar(choiceLottoNum);
        return setChoicelottoList(choiceLottoNum);
    }

    public List<Integer> setChoicelottoList(String[] choiceLottoNum) {
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < choiceLottoNum.length; i++) {
            tmp.add(Integer.parseInt(choiceLottoNum[i]));
        }
        return tmp;
    }

    public void equalsNumber(List<List<Integer>> mainLotto, List<Integer> lottoNumber, Player player) {
        for (int i = 0; i < mainLotto.size(); i++) {
            int cnt = getLottoNumTotal(mainLotto.get(i), lottoNumber);
            EnumRanking.Ranking.rankingTotal(cnt, mainLotto.get(i), player);

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

    public void bonusNumAllErorr(String choice, List<Integer> numbers) {
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

    public Lotto choiceLottoNumTry() {
        Lotto lotto = null;
        do {
            try {
                String[] choiceLottoNum = InputView.choiceMainLottoNum().split(",");
                lotto = new Lotto(lottoList(choiceLottoNum));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (Objects.isNull(lotto));
        return lotto;
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
        do {
            try {
                String choice = InputView.choiceBonusLottoNum();
                bonusNumAllErorr(choice, numbers);
                playerUpdateBonusNumber(choice, player);
                isTrue = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isTrue);
    }

}
