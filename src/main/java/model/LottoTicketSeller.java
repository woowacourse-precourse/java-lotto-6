/**
 * @Package_name : model
 * @Class_name : LottoTicketSeller
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

public class LottoTicketSeller {
    private int paidMoney;
    private final int lottoPrice = 1000;


    public LottoTicketSeller(int paidMoney) {
        this.paidMoney = paidMoney;
    }

    /**
     * Description : 주어진 금액으로 살 수 있는 로또 장수 반환
     *
     * @Method : receiveLottotickets()
     * @return : int
     */
    public int receiveLottotickets() {
        int lottoTicketNum = paidMoney / lottoPrice;
        return lottoTicketNum;
    }

}
