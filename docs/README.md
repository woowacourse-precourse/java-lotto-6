
## 게임 진행 흐름

이야기 : 손님이 로또를 구매하고 이후 당첨번호를 입력해서 자기가 얼마나 벌었는지 확인함

1. `누군가(Appplication)`가 `진행자`에게 `로또 게임`을 시작해달라고 요청한다.
1. `진행자`는 `로또 생성기`에게 구매 금액을 보내 `로또들을 생성`해달라고 한다.
    2. 구매 금액 입력
    3. 로또 생성
3. `진행자`는 `구입한 로또`들을 `출력기` 에게 보내 출력해달라고 한다.
4. `진행자`는 `당첨 로또`를 생성한다.
    1. `당첨 번호`를 입력
    2. `보너스 번호`를 입력
5. `진행자`는 `WinningResults`에게 `WinngLotto`를 보내 `WinningResults`를 만들어 달라고 한다.
6. `진행자`는 받은 `WinningResults`를  `출력기`에게 보내 출력 해달라고 한다.


# Domain

## LottoGenerator(Interface)

실제 구현체 : AutoLottoGenerator

1. LottoGenerator 생성 기능(NumberGenerator) -> return LottoGenerator
2. 로또 생성 기능(money) -> return List<`Lotto`>
    1. money는 1000원 단위어야한다. (0원 안됨)

## NumbersGenerator(Interface)

실제 구현체 : RandomNumbersGenerator

1. NumbersGenerator 생성기능() -> return NumbersGenerator
2. Numbers 생성 기능() -> return List<`Integer`>

## WinningResults(class)

private EnumMap<WinningResult,Integer>

1. WinningResults 생성기능() -> return WinngingResults
    1. 밖에서 초기화 or 안에서 초기화(뭘가지고 있을지 명확하긴함) 명확하다고생각해서 후자
2. 당첨 결과 계산 요청 (List<`Lotto`> , WinningLotto)

## WinningResult(enum)

1. WinningResult 생성 기능(int matchCount, int money, boolean bonusNumber)
2. WinningResult 찾아주기(int matchCount, boolean bonusNumber)
    1. 5개라면 bonusNumber도 확인
    2. 아니라면 matchCount만 확인

## Lotto(class)
1. 로또 생성 기능(List<숫자>)
    1. 숫자들은 1~45의 숫자여야한다.
    2. 숫자들은 중복되면 안된다.
2. 숫자가 몇개 같은지 확인 하는 기능

## WinningLotto(class)

1. WinningLotto 생성 기능(Lotto, BonusNumber)
    1. 숫자는 Lotto에 있는 숫자에 포함되어 있으면 안된다.
2. 몇등에 당첨됬는지 여부 알려주기

## BonusNumber
1. BonusNumber 생성 기능(Integer) -> return BonusNumber


# View

## 입력
1. 구매 금액 입력 기능
3. 당첨 번호 입력   -> return List<`Integer`>
    1. 1,2,3,4,5,6 형식이 아니면 예외 발생
    2. String to List<`Integer`> 기능
4. 당첨 보너스 번호 입력
    1. 숫자가 아니라면 예외

## 출력
1. 당첨 통계 출력 기능



## 비즈니스 규칙

## 예외


1. 로또 1장의 가격은 1000원 단위이다. (0원이나 1000원단위가 아닌것은 예외)
2. 1,2,3,4,5,6 형식이 아니라면 예외



사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.