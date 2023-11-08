package lotto.entity;

public class LottoScore {

    private int correct3 =0;
    private int correct4=0;
    private int correct5=0;
    private int correct5Bonus=0;
    private int correct6=0;

    public Integer getCorrect3(){
        return correct3;
    }
    public Integer getCorrect4(){
        return correct4;
    }
    public Integer getCorrect5(){
        return correct5;
    }
    public Integer getCorrect5Bonus(){
        return correct5Bonus;
    }
    public Integer getCorrect6(){
        return correct6;
    }

    public void setCorrect3(int correct3){
        this.correct3 = correct3;
    }
    public void setCorrect4(int correct4){
        this.correct4 = correct4;
    }
    public void setCorrect5(int correct5){
        this.correct5 = correct5;
    }
    public void setCorrect5Bouns(int correct5Bonus){
        this.correct5Bonus = correct5Bonus;
    }
    public void setCorrect6(int correct6){
        this.correct6 = correct3;
    }

}
