
## 게임 진행 흐름

이야기 : 손님이 로또를 구매하고 이후 당첨번호를 입력해서 자기가 얼마나 벌었는지 확인함

1. `누군가(Appplication)`가 `진행자`에게 `로또 게임`을 시작해달라고 요청한다. (판매자가 생성된다)
2. `진행자`는 `손님`에게 구매 금액을 입력해달라고한다. (손님이 생성된다.)
3. `손님`은 `판매자`에게 로또를 구매한다. 
4. `진행자`는 `손님`에게 `구입한 로또`들을 받아 `출력기` 에게 보내 출력해달라고 한다.
5. `진행자`는 `당첨 로또`를 생성한다.
    1. `당첨 번호`를 입력
    2. `보너스 번호`를 입력
6. `진행자`는 `WinningResults`에게 `WinngLotto`를 보내 `WinningResults`를 만들어 달라고 한다.
7. `진행자`는 받은 `WinningResults`를  `출력기`에게 보내 출력 해달라고 한다.


# Domain

## Seller(class)
1. Seller 생성 기능(LottoGenerator) -> return `Seller`
2. 로또 판매 기능(money) -> return List<`Lotto`>

## LottoGenerator(Interface)
실제 구현체 : AutoLottoGenerator
1. LottoGenerator 생성 기능(NumberGenerator) -> return LottoGenerator
2. 로또 생성 기능() -> return Lotto

## NumbersGenerator(Interface)
실제 구현체 : RandomNumbersGenerator
1. NumbersGenerator 생성기능() -> return NumbersGenerator
2. Numbers 생성 기능() -> return List<`Integer`>

## WinningStatsCalculator
1. WinningStatsCalculator 생성 기능(WinningLotto) -> return WinningStatsCalculator
2. 당첨 통계 구해주는 기능


## Customer(Class)
1. Customer 생성기능(money) -> return Customer
2. 로또 구매기능(Seller) -> void
3. 당첨 통계 확인하는 기능(WinningLotto)
4. 수익률 계산 기능

## WinningResults(class)
private EnumMap<WinningResult,Integer>
1. WinningResults 생성기능() -> return WinngingResults
    1. 밖에서 초기화 or 안에서 초기화(뭘가지고 있을지 명확하긴함) 명확하다고생각해서 후자
2. 당첨 결과 계산 요청 (List<`Lotto`> , WinningLotto)

## WinningRank(enum)
1. WinningRank 생성 기능(int matchCount, int money, boolean bonusNumber)
2. WinningRank 찾아주기(int matchCount, boolean bonusNumber) -> return WinningRank
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


사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.