package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // String howMuch = readLine();
        int payment = 0;
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {

                payment = Integer.parseInt(readLine());
                if (payment % 1000 != 0 || payment <= 0) throw new IllegalArgumentException();
                break;
//            } catch (NumberFormatException e) {
//                System.out.println("[ERROR] 유효하지 않은 숫자 문자열입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000으로 나누어떨어져야하고 양수여야 합니다.");
            }
        }


        payment /= 1000;
        Lotto[] lotto = new Lotto[payment];

        for (int i = 0; i < payment; i++) {
            lotto[i] = new Lotto(creatRandomnumber());
        }
        System.out.println(payment + "개를 구매했습니다.");
        for (int i = 0; i < payment; i++) {
            lotto[i].numberPrint();
        }
        System.out.println();
        List<Integer> emptynum = null;

        System.out.println("당첨 번호를 입력해 주세요.");
        while (emptynum == null) {
            String winningNumber = readLine();
            emptynum = tokenSeparation((winningNumber));
        }
        System.out.println();

        Lotto winNumber = new Lotto(emptynum);
        int bonusNum = 0;
        System.out.println("보너스 번호를 입력해 주세요.");
        while(bonusNum == 0) {
            try {

                bonusNum = changeToInteger(readLine());
                if (winNumber.returnNumbers().contains(bonusNum)) throw new IllegalArgumentException();
                //break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨번호 중복");
                bonusNum = 0;
            }
        }
//            System.out.println("보너스 번호를 입력해 주세요.");
//           bonusNum = changeToInteger(readLine());




        int[] matching = new int[8];

        for (int i = 0; i < payment; i++) {
            int willReturnIndex = howManySame(lotto[i].returnNumbers(), winNumber.returnNumbers());
            if (willReturnIndex == 5 && lotto[i].returnNumbers().contains(bonusNum))
                willReturnIndex++;
            matching[willReturnIndex]++;
        }

        finishPrint(matching, payment);

    }

    static public List<Integer> creatRandomnumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumber(numbers);

        return numbers;
    }

    static public List<Integer> sortNumber(List<Integer> num){
        int empty;
        for(int i = 0;i<6;i++) {
            for (int j = i + 1; j < 6; j++) {
                if (num.get(i) > num.get(j)) {
                    int temp = num.get(i); // 첫 번째 원소를 임시 변수에 저장
                    num.set(i, num.get(j)); // 두 번째 원소를 첫 번째 원소로 복사
                    num.set(j, temp); // 임시 변수의 값을 두 번째 원소로 복사

                }
            }
        }
        return num;
    }

    static public List<Integer> tokenSeparation(String string) {
        int count = 0, emptynum=0;
        List<Integer> winnum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(string, ",");
        while (st.hasMoreTokens()) {
            emptynum = changeToInteger(st.nextToken());
            if(emptynum == 0) return null;
            winnum.add(emptynum);
            count++;
        }
        try {
            if (count > 6) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨번호는 6개여야 합니다.");
            return null;
        }
        return winnum;
    }

    static public int changeToInteger(String string) {
        int integer = 0;
        try {
            integer = Integer.parseInt(string);
            if(integer<1 || integer>45) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return 0;
        }
        return integer;
    }

    public static int howManySame(List<Integer> myNum, List<Integer> winNumber) {
        int returnCount = 0;
        for (Integer element : myNum) {
            if (winNumber.contains(element)) {
                returnCount++;
            }
        }
        if (returnCount == 6) return returnCount + 1;
        return returnCount;
    }

    public static void finishPrint(int[] match, int pay) {
        int sum = 0;
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + match[3] + "개");
        sum += (5000 * match[3]);
        System.out.println("4개 일치 (50,000원) - " + match[4] + "개");
        sum += (50000 * match[4]);
        System.out.println("5개 일치 (1,500,000원) - " + match[5] + "개");
        sum += (150000 * match[5]);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match[6] + "개");
        sum += (30000000 * match[6]);
        System.out.println("6개 일치 (2,000,000,000원) - " + match[7] + "개");
        sum += (2000000000 * match[7]);
        sum /= 1000;
        System.out.printf("총 수익률은 %.1f%%입니다.", (float) sum / pay * 100);
    }
}
