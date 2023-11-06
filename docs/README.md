# 예상 객체 정리

## 1. Lotto

- 현재 이미 구현되어 있는 부분은
```java
private final List<Integer> numbers;
```
1. validate 를 이 컬렉션에서 하고있다는 부분 (size == 6 ?)

### 이 클래스에 대한 Todo

1. 1~45 입력값에 대한 validate
2. getter 매서드 혹은 로또값을 보여줄 다른 매서드(행위)
3. contains 매서드 (다른 로또와 비교 매서드)

## 2. Prize

- 1,2,3,4,5 등이 있다
- Enum 클래스로 구현한다. 대략적인 모습은
```java
FIRST(2,000,000,000);
```

위와 같다.

## 3. UserAccount (이름 변경 필요...)

### 예상 상태

```java
private final Integer money;
```

- 사용자가 입력한 금액(ex : 14000)

### 예상 동작

1. validate
- 1000으로 나누어 떨어지는지 검증함

2. 몇 회 할 수 있는지?(trial)
- 사용자가 입력한 금액으로 몇개의 로또를 발행할지 리턴해줌

3. 사용자의 수익률은 얼마인지?
- 최종 결과를 입력 받아서, money 라는 필드와 비교하여 수익률을 계산함
- 해당 수익률을 리턴함

## 4. Calculator (수익금 계산기)
### 예상 상태
- Map<Enum, Integer> counts
> Prize Enum 이 몇번 카운트되는지 저장할 맵

### 동작
1. 사용자의 로또와 자동생성 로또를 비교해서 맞은 개수에 따른 Enum을 맵에 저장
2. Map 을 조사해서 총 수익금 계산 후 리턴

## 5. Lottos(Lotto List)
### 예상 상태

- List<Lotto,> Lottos

### 예상 동작

- 로또 컬렉션에 대해서 일괄적 판별 로직 가져주기

### 예상 이미지
![이미지](https://velog.velcdn.com/images/calaf/post/4d8ea921-7aa7-4b11-830a-a78ff40ecc2c/image.png)

---

## 에러 처리

- IllegalArgumentException 으로 고정한다.
- 이번엔 에러메시지를 콘솔에 출력하고 __게임을 그대로 이어한다__ (다시 입력받는다)

> AOP 를 사용 가능할까? 순수자바로 해야할까?