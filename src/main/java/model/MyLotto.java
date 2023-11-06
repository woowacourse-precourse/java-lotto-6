package model;

public class MyLotto {

    int lottoPaper;

    public void buyLotto(int lottoCost){
        lottoPaper = lottoCost/1000;
    }

    public int getLottoPaper(){
        return lottoPaper;
    }

}
