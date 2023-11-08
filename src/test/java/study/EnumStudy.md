# Enum
JDK 1.5 버전 이후로 사용할 수 있는 Enum(Enumeration Type) 이다. 상수를 정수 취급하지 않고 객체 지향적으로 상수를 객체화해서 관리하기 위해 생겨났다.
- Java의 enum은 C++와 달리 독립된 특수 클래스로 구분한다.
    - 객체이기 때문에 enum 상수들은 힙 메모리에 저장되는데 이 특성 때문에 싱글톤 클래스를 생성하는데에 활용될 수 있다.
```java
@Test  
void Enum_singleton() {  
    Fruit.APPLE.addCount();  
    Fruit fruit = Fruit.valueOf("APPLE");  
    assertThat(fruit.getCount()).isEqualTo(1); // True  
}
```
# 장점
## IDE의 지원
Enum 을 사용함으로써 기존 Static 문자열을 사용하는 것보다 IDE의 자동완성 / 오타 검증 / 텍스트 리펙토링 등 지원을 더 받을 수 있다.
## 범위를 지정할 수 있다.
Enum 클래스를 정의하고 그 안에 상수들을 정의했을 때 그 상수들 안에서만 사용할 수 있다. (Type Safety)
```java
enum Fruit {BANANA, APPLE, ORANGE} 
```
(이 세가지 상수를 제외한 상수는 사용할 수 없다. )
=> 특정 범위의 값만 사용 가능하므로 컴파일 오류나 런타임 예외를 줄일 수 있다.

## enum의 상숫값이 추가되거나 변경되도 한 곳에서만 변경이 이루어진다.
즉 유지 보수가 용이하다.

```java
class Constants{
	public final static int BANANA = 1;
	public final static int APPLE = 2;
}
class Application{
	void printFruitByNumber(int fruitNumber) {
		switch(fruitNumber) {
			case Constants.BANANA: 
				System.out.println("banana");
				break;
			case Contants.APPLE:
				System.out.println("apple");
				break;
			}
		}
	}
}
```
enum 을 사용하지 않았을 때이다. `BANANA`와 숫자 1 은 같은 것으로 해석되는 값이다. 그리고 과일들의 상수를 모은 `Constants`에 위치 시켰다. 그리고 `Application` 클래스에서 switch 문으로 숫자와 과일 이름 출력을 대치 시켰다.
하지만 만약`ORANGE`라는 상수가 추가된다면 어떻게 될까.
```java
class Constants{
	public final static int BANANA = 1;
	public final static int APPLE = 2;
	public final static int LEMON = 3;
}
class Application{
	void printFruitByNumber(int fruitNumber) {
		switch(fruitNumber) {
			case Constants.BANANA: 
				System.out.println("banana");
				break;
			case Contants.APPLE:
				System.out.println("apple");
				break;
			case Contants.LEMON:
				System.out.println("lomon");
				break;
			}
		}
	}
}
```
이렇게 두 클래스에서 변화가 이루어져야한다.
Enum 클래스를 사용한다면 이 문제를 해결할 수 있다.
```java
enum Fruit {
	BANANA(1, "banana"),
	APPLE(2, "apple"),
	NONE(0, "nothing");

	int fruitNumber;
	String fruitName;

	private Fruit(int fruitNumber, String fruitName) {
		this.fruitNumber = fruitNumber;
		this.fruitName = fruitName;
	}

	public static Fruit getFruitByNumber(int number) {
		for (Fruit fruit : Fruit.values()){
			if(fruit.fruitNumber == number) return fruit;
		}
		return NONE;
	}

	public String getName() {
		return this.fruitName;
	}
}

class Application{
	void printFruitByNumber() {
		Fruit fruit = Fruit.getFruitByNumber(fruitNumber);
		System.out.println(fruit.getName());
	}
}
```
과일 넘버 3을 가진 `LEMON`이 추가된다하더라도 `Fruit` 을 사용하는 다른 클래스에 영향을 끼치지 않는다.
## 상태와 행위를 한곳에서 관리한다.
위의 코드에 이어서 만약 과일마다 각각 다르게 가격을 계산해야하는 경우는 어떻게 해야할까.
```java
class Constants{
	public final static int BANANA = 1;
	public final static int APPLE = 2;
	public final static int LEMON = 3;
}
class Application{
	void calculate(int fruitNumber, int gram) {
		switch(fruitNumber) {
			case Constants.BANANA: 
				calculatePriceByFruit(Constants.BANANA, gram);
				break;
			case Constants.APPLE:
				calculatePriceByFruit(Constants.APPLE, gram);
				break;
			case Constants.LEMON:
				calculatePriceByFruit(Constants.LEMON, gram);
				break;
		}
	}
}
```
과일의 넘버와 무게를 받고 과일마다 다른 계산방법으로 계산하는 `calculatePriceByFruit` 가 필요해 보인다.
그러나 내가 아니라 다른 사람이 `calculatePriceByFruit` 를 사용할 것이라는 보장이 없다. 즉 상태에 대해 맞는 행위를 할 보장이 없다. 이는 코드의 중복으로 이루어질 가능성이 있다.

```java
enum Fruit {
	BANANA(1, "banana", gram -> gram * 30),
	APPLE(2, "apple", gram -> gram * 50),
...
	private FruitCalculation<Integer, Integer> expression;

	private Fruit(... , FruitCalculation<Integer, Integer> expression) {
		...
		this.expression = expression;
	}
	...

	public calculatePrice(int gram) {
		return expression.apply(gram);
	}
}
```
과일 각각에 대한 그램 수당 계산 방법을 한 곳에 위치했다. 다른 사람이 이 클래스를 사용할 때 "과일의 값을 계산할 때는 `calculatePrice`를 사용하는 구나" 라고 직관적으로 알 수 있다.

# Enum 정의와 사용
- 정의
  Enum은 따로 java 파일 생성하는 방법으로 자주 사용된다.
```java
public enum [Enum의 이름] {
	[상수 이름 1], [상수 이름 2] ... 
}
```

- 사용
```java 
[Enum의 이름].[상수 이름]
```
사용하는 방법은 Constants 클래스에서 상수를 가져다 쓰는 것처럼 사용한다.

# java.lang.Enum 클래스
모든 enum의 공통 조상 클래스. enum에 대한 다양한 메서드가 존재한다.
- 사용한 Enum 클래스
```java
enum Fruit {  
    BANANA(1, "banana"),  
    APPLE(2, "apple"),  
    NONE(0, "nothing");  
  
    int fruitNumber;  
    String fruitName;  
    int fruitCount;  
  
    private Fruit(int fruitNumber, String fruitName) {  
        this.fruitCount = 0;  
        this.fruitNumber = fruitNumber;  
        this.fruitName = fruitName;  
    }  
  
    public static Fruit getFruitByNumber(int number) {  
        for (Fruit fruit : Fruit.values()){  
            if(fruit.fruitNumber == number) return fruit;  
        }  
        return NONE;  
    }  
  
    public void addCount() {  
        this.fruitCount++;  
    }  
  
    public String getName() {  
        return this.fruitName;  
    }  
  
    public int getCount() {  
        return this.fruitCount;  
    }  
}
```

## values()
Enum 클래스에서 정의된 모든 상수를 불러온다.
```java
@Test  
void Enum_values() {  
	Fruit[] fruits = Fruit.values(); // [BANANA, APPLE, LEMON]
    assertThat(fruits.length).isEqualTo(3);  
}
```

## valueOf(String str)
문자열과 매치되는 상수 이름을 찾아 상수를 리턴한다.
```java
@Test  
void Enum_valueOf() {
	assertThat(Fruit.valueOf("BANANA")).isEqualTo(Fruit.BANANA);  
}
```

## ordinal()
해당 상수가 Enum 클래스에서 정의된 순서에서 몇번째 상수인지 리턴한다.
```java
@Test  
void Enum_ordinal() {  
    assertThat(Fruit.APPLE.ordinal()).isEqualTo(1);  
}
```
# Reference
- https://www.tcpschool.com/java/java_api_enum
- https://techblog.woowahan.com/2527/
- https://velog.io/@mooh2jj/Java-Enum%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0
- https://heepie.me/32