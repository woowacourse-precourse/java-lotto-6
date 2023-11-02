package lotto.model;

public class PurchasePrice {

    private static int PIECE_OF_LOTTO;
    private static final int LOTTO_PRICE_EACH = 1000;
    private void countPieceOfLotto(String purchasePrice){
        int PIECE_OF_LOTTO = Integer.parseInt(purchasePrice) / LOTTO_PRICE_EACH;
        purchasePriceUnder1000(purchasePrice);
        this.PIECE_OF_LOTTO = PIECE_OF_LOTTO;
    }

    public int getCountPieceOfLotto(){
        return PIECE_OF_LOTTO;
    }

    private void purchasePriceUnder1000(String purchasePrice){
        try{
            if(Integer.parseInt(purchasePrice) < LOTTO_PRICE_EACH){
                throw new IllegalArgumentException("[ERROR] 로또는 한장은 1000원입니다.");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            countPieceOfLotto(purchasePrice);
        }
    }
}
