package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


public class Application {
    static int purchaseLottoCost;
    static List<Integer> lottoAnswer = new ArrayList<>();
    static int bonusNumber;

    static double totalRevenue;

    static int validateInputIsNum(String inputStr) {
        int retNum = 0;
        try {
            retNum = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
        return retNum;
    }

    static void validateInputCostByMod(int inputCost) {
        if (inputCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 로또를 살 수 있습니다.");
        }
    }

    static void validateInputCostByLimit(int inputCost) {
        if (inputCost < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또를 사기 위한 최소 금액은 1,000원 입니다.");
        }
    }

    static int calculateLottoCount(String inputCostStr) {

        int inputCost = 0;

        inputCost = validateInputIsNum(inputCostStr);

        validateInputCostByMod(inputCost);

        validateInputCostByLimit(inputCost);

        purchaseLottoCost = inputCost;

        return inputCost / 1000;
    }


    static List<Integer> getLottoNumber() {
        List<Integer> LottoNumber = pickUniqueNumbersInRange(1, 45, 6);

        if (LottoNumber instanceof ArrayList) {
            Collections.sort(LottoNumber);
        }

        return LottoNumber;
    }


    static List<Lotto> generateLottos(int purchaseLottoCount) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int generatedLottoCount = 0; generatedLottoCount < purchaseLottoCount; generatedLottoCount++) {
            Lotto generatedLotto = new Lotto(getLottoNumber());
            generatedLottos.add(generatedLotto);
        }

        return generatedLottos;
    }

    static void showPurchasedLottos(List<Lotto> purchasedLottos) {
        StringBuilder sb = new StringBuilder();

        int purchasedLottoTotal = purchasedLottos.size();
        sb.append(Integer.toString(purchasedLottoTotal));
        sb.append("개를 구매했습니다.\n");

        for (int purchasedLottoCount = 0; purchasedLottoCount < purchasedLottoTotal; purchasedLottoCount++) {
            sb.append(purchasedLottos.get(purchasedLottoCount));
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void isInAnswer(int inputAnswer) {
        if (lottoAnswer.contains(inputAnswer)) {
            throw new IllegalArgumentException("[ERROR] 입력 번호에는 중복이 있을 수 없습니다.");
        }
    }

    static void validateLottoAnswerSize() {
        if (lottoAnswer.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력에는 숫자 6개가 필요합니다.");
        }
    }

    static void setLottoAnswer(String inputAnswerStr) {
        StringTokenizer st = new StringTokenizer(inputAnswerStr, ",");

        while (st.hasMoreTokens()) {
            int inputAnswer = validateInputIsNum(st.nextToken()); // 입력값이 숫자인 값인지 검사

            validateInputNumberByLimit(inputAnswer);    // 1~45 사이의 값인지 검사

            isInAnswer(inputAnswer);    // answer list에 값이 있는 지 검사

            lottoAnswer.add(inputAnswer);   // 없다면 검사
        }

        validateLottoAnswerSize(); // Answer의 크기가 6이 아니라면 정확한 입력을 하지 않은 것!
    }

    static void validateInputNumberByLimit(int notValidatedNumber) {
        if (notValidatedNumber < 1 || notValidatedNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 번호 입력값은 1과 45 사이의 값만 가능합니다.");
        }
    }

    static void validateBonusNumberIsInAnswer(int notValidatedBonusNumber) {
        if (lottoAnswer.contains(notValidatedBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    static void setBonusNumber(String inputBonusStr) {
        bonusNumber = validateInputIsNum(inputBonusStr);

        validateInputNumberByLimit(bonusNumber);

        validateBonusNumberIsInAnswer(bonusNumber);
    }

    static int calculateBonusNumber(List<Integer> MyLotto) {

        if (MyLotto.contains(bonusNumber)) {
            return LottoWin.MATCHED_5_WITH_BONUS.getMatchValue();
        }

        return LottoWin.MATCHED_5.getMatchValue();
    }

    static int matchBonusCount(int matchCount, List<Integer> MyLotto) {

        if (matchCount == 5) {
            matchCount = calculateBonusNumber(MyLotto);
        }

        return matchCount;
    }

    static int matchMyLotto(Lotto purchasedLotto) {
        int matchCount = 0;

        List<Integer> MyLotto = purchasedLotto.getLotto();

        for (int LottoIndex = 0; LottoIndex < MyLotto.size(); LottoIndex++) {
            if (lottoAnswer.contains(MyLotto.get(LottoIndex))) {
                matchCount++;
            }
        }

        matchCount = matchBonusCount(matchCount, MyLotto);

        return matchCount;
    }

    static void calculateMyMatch(int matchedCount) {
        for (LottoWin win : LottoWin.values()) {
            if (win.getMatchValue() == matchedCount) {
                win.increaseCount();
            }
        }
    }

    static void validateMyRevenue(List<Lotto> purchasedLottos) {
        for (int purchasedLottoCount = 0; purchasedLottoCount < purchasedLottos.size(); purchasedLottoCount++) {
            Lotto purchasedLotto = purchasedLottos.get(purchasedLottoCount);
            int matchedCount = matchMyLotto(purchasedLotto);
            calculateMyMatch(matchedCount);
        }

    }


    static void showLottoWins() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---\n");
        sb.append("3개 일치 (5,000원) - " + Integer.toString(LottoWin.MATCHED_3.getCount()) + "개\n");
        sb.append("4개 일치 (50,000원) - " + Integer.toString(LottoWin.MATCHED_4.getCount()) + "개\n");
        sb.append("5개 일치 (1,500,000원) - " + Integer.toString(LottoWin.MATCHED_5.getCount()) + "개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Integer.toString(LottoWin.MATCHED_5_WITH_BONUS.getCount()) + "개\n");
        sb.append("6개 일치 (2,000,000,000원) - " + Integer.toString(LottoWin.MATCHED_6.getCount()) + "개\n");
        System.out.print(sb.toString());
    }

    static void calculateRevenue(int winMatchValue, int winCounts) {
        for (LottoRevenue lr : LottoRevenue.values()) {
            if (lr.getMatchValue() == winMatchValue) {
                lr.increaseRevenue(winCounts);
                totalRevenue += lr.getMatchRevenue();
            }
        }
    }

    static void showRevenue() {
        for (LottoWin lw : LottoWin.values()) {
            int winMatchValue = lw.getMatchValue();
            int winCounts = lw.getCount();
            calculateRevenue(winMatchValue, winCounts);
        }

        double result = (totalRevenue / (double) purchaseLottoCost) * 100;

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", result));

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Scanner sc = new Scanner(System.in);


            System.out.println("구입금액을 입력해 주세요.");
            int purchaseLottoCount = calculateLottoCount((sc.nextLine()));


            List<Lotto> purchasedLottos = generateLottos(purchaseLottoCount);

            showPurchasedLottos(purchasedLottos);

            System.out.println("\n당첨 번호를 입력해 주세요.");
            setLottoAnswer(sc.nextLine());

            System.out.println("\n보너스 번호를 입력해 주세요.");
            setBonusNumber(sc.nextLine());

            validateMyRevenue(purchasedLottos);

            showLottoWins();

            showRevenue();

            sc.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }


    }
}
