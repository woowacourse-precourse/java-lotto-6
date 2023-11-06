package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static void main(String[] args) {
        PurchasePrice purchasePrice = InputView.inputPurchasePrice();
        int purchaseCount = purchasePrice.getPurchaseCount();
        printPurchaseCount(purchaseCount);

        List<PurchaseNumber> purchaseNumbers = getPurchaseNumbers(purchaseCount);
        printPurchaseNumber(purchaseNumbers);

        WinningNumber winningNumber = inputWinningNumber();
        printWinningNumber(winningNumber);

        int earnMoney = 0;
        int RANK_1_cnt = 0;
        int RANK_2_cnt = 0;
        int RANK_3_cnt = 0;
        int RANK_4_cnt = 0;
        int RANK_5_cnt = 0;
        int RANK_none_cnt = 0;
        for (PurchaseNumber purchaseNumber : purchaseNumbers) {
            Rank rank = calculate(purchaseNumber, winningNumber);
            if (rank == Rank.RANK_1) {
                RANK_1_cnt++;
                earnMoney += Rank.RANK_1.getPrice();
            }
            if (rank == Rank.RANK_2) {
                RANK_2_cnt++;
                earnMoney += Rank.RANK_2.getPrice();
            }
            if (rank == Rank.RANK_3) {
                RANK_3_cnt++;
                earnMoney += Rank.RANK_3.getPrice();
            }
            if (rank == Rank.RANK_4) {
                RANK_4_cnt++;
                earnMoney += Rank.RANK_4.getPrice();
            }
            if (rank == Rank.RANK_5) {
                RANK_5_cnt++;
                earnMoney += Rank.RANK_5.getPrice();
            }
            if (rank == Rank.RANK_NONE) {
                RANK_none_cnt++;
            }
        }

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치" + "(" + Rank.RANK_5.getPrice() + "원)" + " - " + RANK_5_cnt + "개");
        System.out.println("4개 일치" + "(" + Rank.RANK_4.getPrice() + "원)" + " - " + RANK_4_cnt + "개");
        System.out.println("5개 일치" + "(" + Rank.RANK_3.getPrice() + "원)" + " - " + RANK_3_cnt + "개");
        System.out.println("5개 일치, 보너스 볼 일치" + "(" + Rank.RANK_2.getPrice() + "원)" + " - " + RANK_2_cnt + "개");
        System.out.println("6개 일치" + "(" + Rank.RANK_1.getPrice() + "원)" + " - " + RANK_1_cnt + "개");

        System.out.println("소비한 돈 : " + purchasePrice.getPrice() + " 소득 : " + earnMoney);
    }

    public static Rank calculate(PurchaseNumber purchaseNumber, WinningNumber winningNumber) {
        List<Integer> purchaseNumbers = purchaseNumber.getNumbersValue();
        List<Integer> winningNumbers = winningNumber.getNumbersValue();
        int bonusNumber = winningNumber.getBonusNumberValue();

        int sameCount = 0;
        for (Integer number : purchaseNumbers) {
            if (winningNumbers.contains(number)) {
                sameCount++;
            }
        }

        boolean isBonus = purchaseNumbers.contains(bonusNumber);
        if (sameCount == 6) {
            return Rank.RANK_1;
        }
        if (sameCount == 5 && isBonus) {
            return Rank.RANK_2;
        }
        if (sameCount == 5) {
            return Rank.RANK_3;
        }
        if (sameCount == 4) {
            return Rank.RANK_4;
        }
        if (sameCount == 3) {
            return Rank.RANK_5;
        }
        return Rank.RANK_NONE;
    }

    private static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    private static void printWinningNumber(WinningNumber winningNumber) {
        for (LottoNumber lottoNumber : winningNumber.getNumbers()) {
            System.out.print(lottoNumber.getNumber() + ",");
        }
    }

    private static List<PurchaseNumber> getPurchaseNumbers(int purchaseCount) {
        List<PurchaseNumber> purchaseNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            PurchaseNumber purchaseNumber = getRandomPurchaseNumber();
            purchaseNumbers.add(purchaseNumber);
        }
        return purchaseNumbers;
    }

    private static PurchaseNumber getRandomPurchaseNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int randomNumber : randomNumbers) {
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            lottoNumbers.add(lottoNumber);
        }
        return new PurchaseNumber(lottoNumbers);
    }

    private static WinningNumber inputWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String userInputSeperated : userInput.split(",")) {
            LottoNumber lottoNumber = toLottoNumber(userInputSeperated);
            lottoNumbers.add(lottoNumber);
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        String userInputBonusNumber = Console.readLine();
        LottoNumber bonusLottoNumber = toLottoNumber(userInputBonusNumber);
        return new WinningNumber(lottoNumbers, bonusLottoNumber);
    }

    private static LottoNumber toLottoNumber(String userInputNumber) {
        try {
            int number = Integer.parseInt(userInputNumber);
            return new LottoNumber(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static void printPurchaseNumber(List<PurchaseNumber> purchaseNumbers) {
        for (PurchaseNumber purchaseNumber : purchaseNumbers) {
            List<LottoNumber> lottoNumbers = purchaseNumber.getNumbers();
            List<Integer> numbers = new ArrayList<>();
            for (LottoNumber lottoNumber : lottoNumbers) {
                numbers.add(lottoNumber.getNumber());
            }
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }
}