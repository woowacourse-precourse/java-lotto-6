package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {
        // String howMuch = readLine();
        int payment = 0; //지불금액 저장할 변수
        payment = paymentInput(payment); //변수에 저장

        payment /= 1000; //갯수로 나타내기위해 1000을 나눔
        Lotto[] lotto = new Lotto[payment]; //갯수만큼의 로또객체 생성

        for (int i = 0; i < payment; i++) {
            lotto[i] = new Lotto(creatRandomnumber()); //각 개체에 난수를 넣어줌
        }

        System.out.println(payment + "개를 구매했습니다.");

        for (int i = 0; i < payment; i++) {
            lotto[i].numberPrint();
        }

        List<Integer> emptynum = null;
        System.out.println("당첨 번호를 입력해 주세요.");
        while (emptynum == null) {
            String winningNumber = readLine();
            emptynum = tokenSeparation((winningNumber));//당첨번호 저장
        }
        Lotto winNumber = new Lotto(emptynum); //당첨로또 객체생성

        int bonusNum = 0;
        bonusNum = bonusnumInput(bonusNum, winNumber); //보너스넘버가 당첨번호에 중복으로 있는지 확인후 없으면 생성

        int[] matching = new int[8];//매칭은 당첨번호중에 몇개가 일치하는지를 각 인덱스에 저장.
        for (int i = 0; i < payment; i++) {
            int willReturnIndex = howManySame(lotto[i].returnNumbers(), winNumber.returnNumbers());
            if (willReturnIndex == 5 && lotto[i].returnNumbers().contains(bonusNum)) //5개가 같다면 보너스넘버까지 확인
                willReturnIndex++;
            matching[willReturnIndex]++;//해당 인덱스의 숫자가 나올때마다 +1해줌
        }

        finishPrint(matching, payment); //최종출력

    }

    static public int paymentInput(int payment){
        System.out.println("구입금액을 입력해 주세요.");
        while (payment == 0)
            payment = paymentException(payment);
        return payment;
    }

    static public int paymentException(int payment){
        try {
            payment = Integer.parseInt(readLine());
            if (payment % 1000 != 0 || payment <= 0) throw new IllegalArgumentException();
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000으로 나누어떨어져야하고 양수여야 합니다.");
            return 0;
        }
    }

    static public List<Integer> creatRandomnumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumber(numbers);

        return numbers;
    }
    static public List<Integer> sortNumber(List<Integer> num){
        for(int i = 0;i<6;i++)
            for (int j = i + 1; j < 6; j++)
                swapNum(num,i,j);
        return num;
    }
    static public void swapNum(List<Integer> num, int index1, int index2){
        if (num.get(index1) > num.get(index2)) {
            int temp = num.get(index1); // 첫 번째 원소를 임시 변수에 저장
            num.set(index1, num.get(index2)); // 두 번째 원소를 첫 번째 원소로 복사
            num.set(index2, temp); // 임시 변수의 값을 두 번째 원소로 복사
        }
    }

    static public List<Integer> tokenSeparation(String s) { //입력받은 문자열을 토큰 기준으로 분리
        int count = 0, emptynum=0;
        List<Integer> winnum = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreTokens()) {
            emptynum = changeToInteger(st.nextToken());
            if(emptynum == 0) return null;
            winnum.add(emptynum);
            count++;
        }
        if(countNumException(count) == false)
            return null;
        return winnum;
    }

    static public boolean countNumException(int count){ //카운트갯수가 6개가 아니라면 예외처리
        try {
            if (count != 6) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨번호는 6개여야 합니다.");
            return false;
        }
        return true;
    }

    static public int changeToInteger(String s) { //입력받은 문자를 숫자로 바꿔줌
        int integer = 0;
        try {
            integer = Integer.parseInt(s);
            if(integer<1 || integer>45) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return 0;
        }
        return integer;
    }

    public static int howManySame(List<Integer> myNum, List<Integer> winNumber) { //당첨번호중에 몇개가 같은지 출력. 단, 6개 모두 같다면 5개+보너스1과 분류하기위해 7을 리턴
        int returnCount = 0;
        for (Integer element : myNum) {
            if (winNumber.contains(element)) {
                returnCount++;
            }
        }
        if (returnCount == 6) return returnCount + 1;
        return returnCount;
    }

    static public int bonusnumInput(int bonusNum, Lotto winNumber){ //보너스번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        while(bonusNum == 0) {
            bonusNum = bonusnumException(bonusNum, winNumber);
        }
        return bonusNum;
    }
    static public int bonusnumException(int bonusNum, Lotto winNumber){
        try {
            bonusNum = changeToInteger(readLine());
            if (winNumber.returnNumbers().contains(bonusNum)) throw new IllegalArgumentException();
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨번호 중복");
           return 0;
        }
    }

    public static void finishPrint(int[] match, int payment) {
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
        System.out.printf("총 수익률은 %.1f%%입니다.", (float) sum / payment * 100);
    }
}
