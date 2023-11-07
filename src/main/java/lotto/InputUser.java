package lotto;

public class InputUser {
    private String lottoMoney;
    public Integer inputLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        lottoMoney = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(lottoMoney);
    }
}
