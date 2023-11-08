package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.PrizeLotto;
import lotto.domain.Rank;
import lotto.util.GameUtil;
import lotto.view.View;
import lotto.util.Validator;
import lotto.domain.Lotto;

import java.util.*;

public class Game {
    private static final int LOTTO_PRICE = 1000;

    private View view;
    private Validator validator;

    private int money;
    private List<Lotto> purchasedLotto;
    private PrizeLotto prizeLotto;


    public Game() {
        view = new View();
        validator = new Validator();
    }

    public void play() {
        getMoney();

        purchaseLotto(money / LOTTO_PRICE);

        getPrizeLotto();

        showResult();
    }

    //----------구입 금액 입력----------
    private void getMoney() {
        money = Integer.parseInt(inputMoney());
    }

    private String inputMoney() {
        view.request_InputMoney();
        return check_ValidationInputMoney(Console.readLine());
    }

    private String check_ValidationInputMoney(String input) {
        try {
            validator.check_InputMoney(input);
            return input;
        } catch (IllegalArgumentException e) {
            view.print_Exception(e.getMessage());
            return inputMoney();
        }
    }

    //----------로또 생성----------
    private void purchaseLotto(int purchaseNumber) {
        view.print_PurchasedLottoNumbers(purchaseNumber);

        List<Lotto> newLotto = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            newLotto.add(GameUtil.createLotto());
        }
        purchasedLotto = newLotto;

        view.print_purchasedLotto(purchasedLotto);
    }

    //----------당첨 번호 & 보너스 번호 입력----------
    private void getPrizeLotto() {
        List<Integer> inputWinLotto = getIntegerWinLotto(inputWinLotto());

        Lotto winLotto = new Lotto(inputWinLotto);

        int bonusNum = getBonusNum();

        prizeLotto = new PrizeLotto(winLotto, bonusNum);
    }

    private List<Integer> getIntegerWinLotto(String input) {
        List<String> winLotto = GameUtil.converseStringToStringList(input);

        return GameUtil.converseStringListToIntegerList(winLotto);
    }

    private String inputWinLotto() {
        view.request_InputWinLottoNumbers();

        return check_ValidationInputWinLotto(Console.readLine());
    }

    private String check_ValidationInputWinLotto(String input) {
        try {
            validator.check_InputWinLotto(input);
            return input;
        } catch (IllegalArgumentException e) {
            view.print_Exception(e.getMessage());
            return inputWinLotto();
        }
    }

    private int getBonusNum() {
        return Integer.parseInt(inputBonusNum());
    }

    private String inputBonusNum() {
        view.request_InputBonusNumbers();

        return check_ValidationInputBonusNum(Console.readLine());
    }

    private String check_ValidationInputBonusNum(String input) {
        try {
            validator.check_BonusNum(input);
            return input;
        } catch (IllegalArgumentException e) {
            view.print_Exception(e.getMessage());
            return inputBonusNum();
        }
    }

    //----------결과 출력----------
    private void showResult() {
        List<Rank> rankList = createRankList();
        HashMap<Rank, Integer> rankIntegerHashMap = getRankIntegerHashMap(rankList);
        view.printHittingResult(rankIntegerHashMap);

        int totalHitMOney = caculateTotalHitMoney(rankIntegerHashMap);
        view.printProfitResult(totalHitMOney, money);
    }

    private List<Rank> createRankList() {
        List<Rank> rankList = new ArrayList<>();
        purchasedLotto.forEach(lotto -> rankList.add(prizeLotto.match(lotto)));
        return rankList;
    }

    private HashMap<Rank, Integer> getRankIntegerHashMap(List<Rank> rankList) {
        HashMap<Rank, Integer> rankIntegerHashMap = new LinkedHashMap<>();
        calculateLottoHit(rankList, rankIntegerHashMap);
        return rankIntegerHashMap;
    }

    private void calculateLottoHit(List<Rank> rankList, HashMap<Rank, Integer> rankIntegerHashMap) {
        Arrays.stream(Rank.values()).forEach(rank -> rankIntegerHashMap.put(rank, 0));
        rankList.forEach(rank -> rankIntegerHashMap.put(rank, rankIntegerHashMap.get(rank) + 1));
    }

    private int caculateTotalHitMoney(HashMap<Rank, Integer> rankIntegerHashMap) {
        return rankIntegerHashMap.entrySet().stream()
                .mapToInt(e -> e.getKey().getWinningMoney() * e.getValue()).sum();
    }
}
