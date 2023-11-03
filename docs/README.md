# 우테코 프리코스 3주차 미션 - 로또 게임

## 🔍 기능 구현

## 🔍 Winner_Rank Enum
* 당첨 등수에 관한 정보가 담긴 enum

## 🔍 Lotto 클래스
### 🚀 Lotto(List<Integer> numbers)
* 기본으로 제공된 메소드
* validate 함수로 갯수 확인 후 numbers 리스트를 set한다.
### 🚀 validate(List<Integer> numbers)
* 기본으로 제공된 메소드
* list 길이가 6개가 아니면 IllegalArgumentException를 리턴한다.
### 🚀 lotto_random()
* input_price()에서 입력받은 금액 바탕으로 구한 구입 갯수만큼 랜덤 숫자 6개를 이중 배열에 담는다.
### 🚀 lotto_winner()
출력 번호 / 당첨 번호 / 보너스 번호 바탕으로 당첨 통계를 정리하는 함수

## 🔍 Input 클래스

### 🚀 input_price()
* 구입금액 입력을 받는 함수
### 🚀 input_winning()
* 당첨번호 입력을 받는 함수
### 🚀 input_bonus()
* 보너스번호 입력을 받는 함수

## 🔍 Output클래스
### 🚀 output_price()
* 구매갯수를 출력하는 함수
### 🚀 output_lotto()
* lotto_random()을 바탕으로 구매한 로또 장수만큼의 번호를 출력하는 함수
### 🚀 output_winning()
* 당첨 통계를 출력하는 클래스

### 🛵 main 어플리케이션

1. input_price()를 통하여 구입 금액 입력받고, output_price()로 구매갯수 출력
2. lotto_random()을 통하여 랜덤 로또 생성, output_lotto()로 구매한 로또 번호 출력
3. winning_num(), bonus_num()로 당첨번호와 보너스 번호 입력
4. lotto_winner() 당첨 통계 계산
5. output_winning() 당첨 통계 출력 






