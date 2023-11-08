package lotto;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final double ONE_LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = askPurchaseNumber();
        NumberGenerator[] purchaseNumbers = new NumberGenerator[purchaseAmount];
        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        generateLottos(purchaseAmount, purchaseNumbers); // 구매한 개수만큼 로또 번호를 생성
        // 사용자에게 당첨 번호와 보너스 번호를 입력받음
        Lotto winningNumbers = askWiningNumber();
        int bonusNumber = askBonusNumber();
        // 입력받은 당첨번호를 바탕으로 사용자가 구매한 로또 번호들의 당첨 결과를 계산
        Lotto[] userLotto = getLottos(purchaseAmount, purchaseNumbers);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers, userLotto, bonusNumber);
        lottoResultChecker.checkLottoResult();
        // 당첨 결과를 출력
        printResult(lottoResultChecker);
    }

    // 입력 값이 1,000 단위로 나누어 떨어지는지 체크하는 메서드
    public static double isDivisibleByOneThousand(double number) {
        if (number < ONE_LOTTO_PRICE)
            throw new IllegalArgumentException();// 예외처리: 1,000원보다 작은 경우
        if (number % ONE_LOTTO_PRICE != 0)
            throw new IllegalArgumentException(); // 예외처리: 1,000으로 나누어떨어지지 않는 경우
        return number / ONE_LOTTO_PRICE;
    }

    private static int askPurchaseNumber() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                double purchaseAmount = Double.parseDouble(camp.nextstep.edu.missionutils.Console.readLine());
                return (int) isDivisibleByOneThousand(purchaseAmount); // 구매 금액이 1,000으로 나누어지는지 확인 후 정수로 바꾸어 리턴
            } catch (NullPointerException e) {
                System.out.println("[ERROR] 구매금액을 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구매금액은 숫자형식이어야 합니다.\n");
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 구매금액은 1,000원 단위로 입력하셔야 합니다.\n");
            }
        }
    }

    private static Lotto askWiningNumber() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                return new Lotto(parseNumberList(camp.nextstep.edu.missionutils.Console.readLine()));
            } catch (NullPointerException e) {
                System.out.println("[ERROR] 당첨번호를 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨번호들은 숫자형식이어야 합니다.\n");
            }
        }
    }

    private static int askBonusNumber() {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                return Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
            } catch (NullPointerException e) {
                System.out.println("[ERROR] 보너스 번호를 입력하셔야 합니다.\n");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자형식이어야 합니다.\n");
            }
        }
    }

    // 입력값을 숫자리스트로 만드는 메서드
    private static List<Integer> parseNumberList(String input) {
        List<Integer> numberList = new ArrayList<>();

        String[] numberStrings = input.split(",");
        for (String numStr : numberStrings) {
            try {
                int number = Integer.parseInt(numStr);
                numberList.add(number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자 형식이 아닙니다: " + numStr+"\n");
            }
        }
        return numberList;
    }

    // NumGenerator 배열에서 Lotto들을 빼서 Lotto 배열을 만드는 메서드
    private static Lotto[] getLottos(int purchaseAmount, NumberGenerator[] purchaseNumbers) {
        Lotto[] userLotto = new Lotto[purchaseAmount];
        // NumGenerator 배열에서 Lotto들을 빼서 Lotto 배열을 만들기
        for (int i = 0; i < purchaseAmount; i++) {
            userLotto[i] = purchaseNumbers[i].getLotto();
        }
        return userLotto;
    }

    // 구입 금액에 해당하는 만큼 로또를 발행하는 메서드
    private static void generateLottos(int purchaseAmount, NumberGenerator[] purchaseNumbers) {
        for (int i = 0; i < purchaseAmount; i++) {
            purchaseNumbers[i] = new NumberGenerator();
            purchaseNumbers[i].generateLottoNumbers();
            System.out.println(purchaseNumbers[i].getLottoNumbers());
        }
    }

    private static void printResult(LottoResultChecker lottoResultChecker) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResultChecker.ranks[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResultChecker.ranks[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResultChecker.ranks[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResultChecker.ranks[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResultChecker.ranks[1]);
        System.out.println("총 수익률은 " + lottoResultChecker.returnRatio + "%입니다.");

    }
}
