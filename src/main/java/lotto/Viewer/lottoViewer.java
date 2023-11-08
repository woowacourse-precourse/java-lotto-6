package lotto.Viewer;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;


public class lottoViewer {
    // 입력받기
    public String purchaseLotto(){
        System.out.println("구입금액을 입력해주세요. : ");
        return Console.readLine();
    }

    public List<Integer> inputWinninNumber() {
        System.out.println("당첨 번호를 입력해주세요. : ");
        List<Integer> winningNumbers= new ArrayList<>();

        String inputNumber = Console.readLine();
        String lottoList[] = inputNumber.split(",");
        for(String lottoNumber: lottoList){
            winningNumbers.add(Integer.parseInt(lottoNumber));
        }
        return winningNumbers;
    }

    public Integer inputBounusNumber(){
        String bonusNumber = Console.readLinie();
        System.out.println("\n보너스번호를 입력해 주세요. : ");
        return Integer.parseInt(bonusNumber);
    }

    //출력하기
    // 로또번호 출력하기
    public void viewLottoNumber(){

    }

    // 당첨 통계 결과출력하기
    public void viewResult(){

    }

    // 총 수익률 구하기
    public void viewRateofReturn(){

    }
}
