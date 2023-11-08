package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class Application {

    private static int purchasePieces;
    private static List<Integer> winNum;
    private static String bonusNum;
    private static final List<Set> lottoNum = new ArrayList<>();
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
        List<String> wordNum = Arrays.asList(numbers.split(","));
        List<Integer> convertedNum = new ArrayList<>();
        try {
            for (String beforeNum : wordNum) {
                convertedNum.add(Integer.parseInt(beforeNum));
            }
        } catch (NumberFormatException e) {
            outputView.errorMessage("[ERROR] 숫자만 입력 가능합니다.");
            return convertNum(inputView.winNum());
        }
        return convertedNum;
    }

    public static void winLottoNum(List<Integer> numbers) {
        try {
            new Lotto(numbers);
            winNum = numbers;
        } catch (IllegalArgumentException e) {
            outputView.errorMessage(e.getMessage());
            winNum = convertNum(inputView.winNum());
            winLottoNum(winNum);
        }
    }

    public static void bonusNum(List<Integer> numbers, String bonusNumber) {
        try {
            new Bonus(numbers, bonusNumber);
            bonusNum = bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.errorMessage(e.getMessage());
            bonusNum(winNum, inputView.bonusNum());
        }
    }

    public static void intersectionNum() {
        List<Boolean> bonusNumContainCheck = intersection.checkBonusNumber(bonusNum, lottoNum);
        List<Integer> intersectionCount = intersection.countMatchingNumbers(winNum, lottoNum);
        LottoResult.initialize();
        for (int i = 0; i < intersectionCount.size(); i++) {
            result = LottoResult.statistics(intersectionCount.get(i), bonusNumContainCheck.get(i));
        }
    }

    public static void main(String[] args) {
        purchaseCount(inputView.purchaseAmount());
        outputView.purchasePieces(purchasePieces);
        randomRepeat();
        winLottoNum(convertNum(inputView.winNum()));
        bonusNum(winNum, inputView.bonusNum());
        intersectionNum();
        outputView.statistics(result);
        outputView.profit(LottoResult.calculateProfit(purchasePieces));
    }
}