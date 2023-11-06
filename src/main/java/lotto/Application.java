package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static int purchasePieces;
    private static List<Integer> winNum;
    private static final List<Set> lottoNum = new ArrayList<>();
    private static int bonusNum;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final RandomLotto random = new RandomLotto();
    private static final Intersection intersection = new Intersection();

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

    public static void main(String[] args) {
        purchaseCount(inputView.purchaseAmount());
        outputView.purchasePieces(purchasePieces);
        randomRepeat();
        winLottoNum(convertNum(inputView.winNum()));
        bonusNum(winNum, Integer.parseInt(inputView.bonusNum()));
        System.out.println(intersection.winNum(winNum, lottoNum));
    }
}