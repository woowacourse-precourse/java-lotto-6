/**
 * @Package_name : view
 * @Class_name : InputView
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package view;

import java.util.ArrayList;
import utility.Utility;

public class InputView {
    /**
     * Description : 로또 구입 금액 입력
     *
     * @Method : inputLottoBuy()
     * @return : Integer
     */
    public Integer inputLottoBuy() {
        Integer money = Integer.parseInt(Utility.campReadline());
        return money;
    }

    /**
     * Description : 당첨 번호 입력
     *
     * @Method : inputLottoNum()
     * @return : ArrayList<Integer>
     */
    public ArrayList<Integer> inputLottoNum() {
        String inputLottoNum = Utility.campReadline();
        String[] LottoNums = inputLottoNum.split(",");
        ArrayList<Integer> LottoNumbers = new ArrayList<>();
        for (String lottoNum : LottoNums) {
            LottoNumbers.add(Integer.valueOf(lottoNum));
        }
        return LottoNumbers;
    }

    /**
     * Description : 보너스 번호 입력
     *
     * @Method : inputBonusNum()
     * @return : Integer
     */
    public Integer inputBonusNum() {
        Integer BonusNum = Integer.parseInt(Utility.campReadline());
        return BonusNum;
    }

}
