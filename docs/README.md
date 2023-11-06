# 목표 

## 로또 6개의 숫자

  중복되지 않는 랜덤 값 생성 및 예외처리

## 랜덤 숫자 1 ~ 45

[ERROR] 로또 번호는 1부터 45 사이의 숫자 여야 합니다.

## 배열 

 6개의 중복 되지 않는 랜덤 숫자를 배열에 넣어 정렬해야함.
  
  [N][0~6]

## 확인 1등~5등

   보너스 볼 한자리 아래 6자리 중에 없는 1개 
   중복 되지 않는 당첨 번호 6자리 쉼표 기준

## 정산

   당첨 값과 당첨 배열을 비교 해서 얼마나 맞는 지 확인.

   당첨 기준은 6개 6개 비교 후 각각 3 4 5 6 순으로 등수가 정해짐 
   
   추가로 5개 맞춘 상태에서 보너스 볼을 맞추면 2등이 됨.

## 금액 1장 1000원.

  금액을 입력 받고 금액/1000 한 값이 시행 횟수. (1000원으로 나누어 지지 않으면 예외처리함.)

## 총 수익률 

  투자 금액 대비 수익률을 나타냄 소수점 2자릿수로 반올림함.

# 코드

## Application

  메인이 되는 어플리케이션 클래스.

#### main(String[] args)

  예외처리를 확인하면서 프로그램을 실행하는 당담.

#### int getMoney()

  구입금액을 입력 받음.

#### List<Integer> winningNumber()

  당첨 번호를 입력 받음.

#### List<Integer> stringToInteger(List<String> string)

  List String 값을 List Integer 값으로 바꿔줌.

#### int bonusNumber()

  보너스 번호를 받음.

#### isInteger(String strValue)

  Integer가 맞는지 확인해서 예외처리함.

## Lotto

  로또 값을 받아 예외처리를 하여 저장하는 클래스.

#### List<Integer> numbers

  로또 값의 배열.

#### Lotto(List<Integer> numbers)

  로또 값의 예외처리를 확인함.

#### validate(List<Integer> numbers)
  
  숫자가 6개인지 확인함.

#### List<Integer> lottoNumber()
 
  당첨 번호를 return 해줌.

#### bonusNumber(int number)

  보너스 숫자의 예외처리를 확인함.

#### validateBonusNumber(int number)

  보너스 숫자가 기존 로또 번호와 중복 되는지 확인.

#### validateWinningNumber(List<Integer> numbers)

  로또 번호가 1~45인지 확인. List

#### validateWinningNumber(int numbers)

  로또 번호가 1~45인지 확인. Int

#### validateDuplicateNumber(List<Integer> numbers)

  로또 번호가 중복된 숫자가 존재 하는지 확인.

## LottoPick

  금액만큼 로또 번호를 만들어내는 클래스
 
#### List<Integer>[] numbers

  랜덤으로 뽑힌 로또 번호를 저장하는 배열 리스트

#### int attempt

  금액에 따라 정해진 시도횟수를 저장함.


#### LottoPick(int attempt)

  금액을 받아 로또 값을 시도횟루에다가 저장함.

#### List<Integer>[] lottoPickNumber()

  로또 번호 배열을 return함.

#### makeLottoPick()

  랜덤 로또 번호를 받아 저장함.

#### outputLottoPick()

  로또 번호를 출력함.

#### String sortResult(List<Integer> arr)

  로또 번호를 오름차순으로 바꿔줌. (기능테스트에서 정렬을 사용시 오류로 인한 메서드.)

#### validate(int money)

  금액이 1000단위 인지 입증해줌.

#### List<Integer> randomCreate()

  랜덤 숫자를 생성함 1~45

## LottoCheck


#### List<Integer>[] lottoPickNumbers

  랜덤 로또 번호가 저장됌.

#### List<Integer> lottoNumber

  뽑힌 로또 번호가 저장됌.

#### Integer lottoBonus

  보너스 로또 번호가 저장됌.

#### Integer[] lottoResult

  맞힌 횟수가 저장됌.

#### Integer[] lottoPrice

  맞횐 횟수에 따른 금액이 저장됌.

#### LottoCheck(List<Integer>[] lottoPickNumbers, List<Integer> lottoNumber)

  로또 값을 받아옴.

#### void lottoCompare()

  로또 값을 비교한 결과 값에 따라 맞힌 횟수를 올려줌.

#### lottoOutput()

  로또 결과 값을 출력함.

#### int lottoCount(List<Integer> lottoPickNumbers, List<Integer> lottoNumber)

  로또 결과 값을 확인 해서 return 함.

#### boolean lottoCheck(List<Integer> lottoPickNumbers, Integer lottoNumber)

 리스트에 값이 존재 하는지 확인함.

#### String place5th(int number)

 5등 결과 출력 값.

#### String place4th(int number)

 4등 결과 출력 값.

#### String place3th(int number)

 3등 결과 출력 값.

#### String place2th(int number)

 2등 결과 출력 값.

#### String place1th(int number)

 1등 결과 출력 값.

#### String profit(double profit)

 수익률 출력 값.

#### double profit()

 수익률을 확인 해서 return 함.





