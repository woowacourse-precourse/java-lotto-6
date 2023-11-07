package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int WIN_LOTTO_SIZE = 6;

    private static int inputPurchaseAmount() {
        String userPurchaseAmount = Console.readLine();
        isOnlyNumber(userPurchaseAmount);
        int purchaseAmount = Integer.parseInt(userPurchaseAmount);

        while (purchaseAmount % 1000 != 0) {
            purchaseAmount = isValidPurchaseAmount(purchaseAmount);
        }
        return purchaseAmount;
    }

    private static int isValidPurchaseAmount(int purchaseAmount) {
        try {
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            int refixPurchaseAmount = Integer.parseInt(Console.readLine());
            return refixPurchaseAmount;
        }
        return purchaseAmount;
    }

    private static void isOnlyNumber(String userPurchaseAmount) {
        try {
            Integer.parseInt(userPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static void printPurchaseNumber(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    private static Lotto inputLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        Lotto myLotto = new Lotto(lottoNumbers);
        return myLotto;
    }

    private static List<Lotto> generateLottos(int purchaseNumber) {
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            myLottos.add(inputLottoNumbers());
        }
        return myLottos;
    }

    private static void printMyLottos(List<Lotto> myLottos, int purchaseNumber) {
        for (int i = 0; i < purchaseNumber; i++) {
            myLottos.get(i).printLottoNumbers();
        }
        System.out.println();
    }

    private static Lotto inputWinLottoNumbers() {
        String userInputWinLotto = Console.readLine();
        List<String> winLottoLetter = Arrays.asList(userInputWinLotto.split(","));

        List<Integer> winLotto = new ArrayList<>();
        for (int i = 0; i < WIN_LOTTO_SIZE; i++) {
            winLotto.add(Integer.parseInt(winLottoLetter.get(i)));
        }

        Lotto winLottoNumber = new Lotto(winLotto);
        return winLottoNumber;
    }

    private static int inputBonusLottoNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = inputPurchaseAmount();

        System.out.println();
        int purchaseNumber = purchaseAmount / 1000;
        printPurchaseNumber(purchaseNumber);
        List<Lotto> myLottos = generateLottos(purchaseNumber);
        printMyLottos(myLottos, purchaseNumber);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winLotto = inputWinLottoNumbers();
        winLotto.printLottoNumbers();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int winBonusNumber = inputBonusLottoNumber();
    }
}
