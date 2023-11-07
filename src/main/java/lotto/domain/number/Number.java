package lotto.domain.number;

public abstract class Number implements Comparable<Number>{

    protected int value;

    public int getValue(){
        return this.value;
    }

    @Override
    public int compareTo(Number other){
        return Integer.compare(this.value, other.value);
    }

}
