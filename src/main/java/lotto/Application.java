package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class Application {

    private static int purchasePieces;
    private static List<Integer> winNum;
    private static final List<Set> lottoNum = new ArrayList<>();
    private static int bonusNum;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomLotto random = new RandomLotto();
    private static final Intersection intersection = new Intersection();
    private static HashMap result = new HashMap<>();


    public static void purchaseCount(String purchasingAmount) {
        try {
            purchasePieces = new Purchase(purchasingAmount).pieces();
        } catch (IllegalArgumentException e) {
            outputView.errorMessage(e.getMessage());
            purchaseCount(inputView.purchaseAmount());
        }
    }

    public static void randomRepeat() {
        for (int i = 0; i < purchasePieces; i++) {
            List<Integer> numbers = random.listSort(random.generateNum());
            HashSet<Integer> numberAll = new HashSet<>(numbers);
            lottoNum.add(numberAll);
            outputView.purchaseNum(numbers);
        }
    }

    public static List<Integer> convertNum(String numbers) {
        String[] wordNum = numbers.split(",");
        List<Integer> convertedNum = new ArrayList<>();
        for (String beforeNum : wordNum) {
            convertedNum.add(Integer.parseInt(beforeNum));
        }
        return convertedNum;
    }


    public static void winLottoNum(List<Integer> numbers) {
        try {
            winNum = numbers;
            Lotto lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            outputView.errorMessage(e.getMessage());
            winNum = convertNum(inputView.winNum());
            winLottoNum(winNum);
        }
    }

    public static void bonusNum(List<Integer> numbers, int bonusNumber) {
        try {
            bonusNum = bonusNumber;
            Bonus bonus = new Bonus(numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.errorMessage(e.getMessage());
            bonusNum = Integer.parseInt(inputView.bonusNum());
            bonusNum(winNum, bonusNum);
        }
    }

    public static void initialize() {
        for (int i = 0; i < 6; i++) {
            result.put(i,0);
        }
    }

    public static void intersectionNum() {
        List<Integer> intersectionCheck  = intersection.bonusNum(bonusNum, lottoNum);
        List<Integer> intersectionCount = intersection.winNum(winNum, lottoNum);
        initialize();
        LottoResult lottoResult = new LottoResult(result);
        for (int i = 0; i<intersectionCount.size(); i++) {
           result = LottoResult.statistics(intersectionCount.get(i), intersectionCheck.get(i));
        }
    }

    public static void main(String[] args) {
        purchaseCount(inputView.purchaseAmount());
        outputView.purchasePieces(purchasePieces);
        randomRepeat();
        winLottoNum(convertNum(inputView.winNum()));
        bonusNum(winNum, Integer.parseInt(inputView.bonusNum()));
        intersectionNum();
        System.out.println(result);
    }
}