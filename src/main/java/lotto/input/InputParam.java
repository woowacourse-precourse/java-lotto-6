package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {
    public int inputMoney(){
        return Integer.parseInt(inputLoop());
    }
    public String inputLoop(){
        String money;
        while (true){
            money=readLine();
            try {
               errorCheckInputMoney(money);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입금액을 잘못 입력했습니다.");
                continue;
            }
            break;
        }
        return money;
    }
    public void errorCheckInputMoney(String money) {
        for (int i = 0; i < money.length(); i++) {
            int num=money.charAt(i)-'0';
            if(num<0||num>9) {
                throw new IllegalArgumentException();
            }
        }
        if(Integer.parseInt(money)%1000!=0) throw new IllegalArgumentException();
    }

    public int[] inputLottoNumbers(){
        String[] split = readLine().split(",");
        int[] inputNumbers=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            inputNumbers[i] = Integer.parseInt(split[i]);
        }
        return inputNumbers;
    }

    public int inputBonusNumber(){
        int n = Integer.parseInt(readLine());
        return n;
    }
}
