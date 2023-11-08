# **🪐3주차 미션🪐 - 로또 🎱 **

###### 정은채

📍Class UML



**<u>🎀 컨트롤러 프로세스 🎀</u>**

'구입 금액 입력 요청' 출력하고, 입력 받은 후에 LottoTicketSeller에게 전달하여 로또 구매하고 구매완료문구 출력.
산 로또 수만큼 반복을 돌며 LottoNumberPicker를 이용해 로또번호 셋을 얻어  lotto를 생성해 넣고, LottoNumberSetHolder에 저장, 출력.
'당첨번호와 보너스숫자 입력요청' 출력, 입력 받아서 LottoNumberComparater에 비교를 위해 넣어두기.
LottoNumberSetHolder에 담긴 lotto들에서 로또번호 셋을 가져와 LottoNumberComparater에 넣어서 상금여부판단을 받아 LottoWinResultsHolder에 저장.
LottoWinResultsHolder에서 전체 결과 셋 가져와서 결과 출력하고,
이를 LottoResultJudger에도 전달해 수익률을 게산한 후 출력.

------

### <u>🗂 utility package</u>

##### 🟢 Utility class

`camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 이용하는 클래스 (static)

###### campReadline() 함수 : camp.nextstep.edu.missionutils.Console의 readLine() 을 활용하여 사용자가 입력하는 값 받음

###### campPickUniqueNumbersInRange() 함수 : camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용하여 Random 값 추출

------

### <u>🗂model package</u>

##### 🟢 LottoTicketSeller class

로또를 사는 것을 도와주는 클래스

###### 🔘 paidMoney 변수

###### 🔘 lottoPrice 변수

###### 🔺LottoTicketSeller 생성자

###### receiveLottotickets() 함수 :  주어진 금액으로 살 수 있는 로또 장수 반환



##### 🟢LottoNumberPicker class

로또 숫자를 고르고 정렬하여 주는 클래스

###### lottoNumberPick() 함수 : 1-45 사이의 6개 숫자리스트 반환

###### lottoNumberSort() 함수 : 숫자리스트 정렬 (버블 정렬)

###### swap() 함수 :  버블 정렬용 swap 연산



##### 🟢Lotto class

로또 숫자 검증 및 저장하는 클래스

###### 🔘 numbers 변수

###### 🔺Lotto 생성자

###### validate() 함수 : 6개 숫자가 맞는지 확인

###### validateNumberRange() 함수 : 1-45 범위 숫자가 맞는지 확인

###### getLottoNumbers() 함수 : 로또숫자들 반환



##### 🟢LottoNumberSetHolder class

로또(로또숫자셋)을 모아두는 클래스

###### 🔘 LottoNumberSet 변수

###### 🔺LottoNumberSetHolder 생성자

###### lottoNumberSetAdd() 함수 :  LottoNumberSet에 새로운 로또들 추가

###### getLottoNumberSet() 함수 :  LottoNumberSet 반환



##### 🟢LottoNumberComparater class

결과 로또숫자와 입력받은 로또숫자를 비교하여 결과를 반환하는 클래스

###### 🔘 resultLottoNum 변수

###### 🔘resultBonusNum 변수

###### 🔺LottoNumberComparater 생성자

###### comparaterLottoResult() 함수 : 비교할 로또 번호를 결과번호와 비교하여 결과 반환

###### checkResultLottoNum() 함수 : 결과로또번호와 비교

###### checkResultBonusNum() 함수 :  보너스 번호와 비교



##### 🟢LottoWinResultsHolder class

로또 상 결과들을 받아 저장하는 클래스

###### 🔘 winResults 변수

###### 🔺LottoWinResultsHolder 생성자

###### lottoWinResultsAdd() 함수 : winResults 의 값 갱신

###### getWinResults() 함수 : winResults 반환



##### 🟢LottoResultJudger class

수익률을 계산하여 반환하는 클래스

###### 🔘 profit 변수

###### 🔘paidMoney 변수

###### 🔺LottoResultJudger 생성자

###### getProfit() 함수 : 수익률 계산



#### <u>🗂model.enums package</u>

##### 🟣LottoSystem enum

로또 시스템 관련 Enum

###### 🔘LOTTO_SET_LENGTH

###### 🔘LOTTO_MAX_RANGE

###### 🔘LOTTO_MIN_RANGE

###### ⚫️ value 변수

######  getValue함수 :  요청 수 반환



##### 🟣LottoWinPrize enum

로또 상 크기용 Enum

###### 🔘LOTTO_3SAME_PRIZE

###### 🔘LOTTO_4SAME_PRIZE

###### 🔘LOTTO_5SAME_PRIZE

###### 🔘LOTTO_5SAME_BONUS_PRIZE

###### 🔘LOTTO_6SAME_PRIZE

###### ⚫️ winPrize 변수

###### getValue 함수 :  해당 상금 반환



##### 🟣LottoWinResults enum

로또 상 결과 메세지용 Enum

###### 🔘LOTTO_3SAME

###### 🔘LOTTO_4SAME

###### 🔘LOTTO_5SAME

###### 🔘LOTTO_5SAME_BONUS

###### 🔘LOTTO_6SAME

###### 🔘LOTTO_NOTHING

###### ⚫️ lottoResult 변수

###### getMessage 함수 :  로또 상 결과 메세지 반환

------

### <u>🗂 view package</u>

##### 🟢 InputView class

입력용 클래스

###### inputLottoBuy() 함수  : 로또 구입 금액 입력

###### inputLottoNum() 함수 : 당첨 번호 입력

###### inputBonusNum() 함수 : 보너스 번호 입력



##### 🟣OutputMessage enum

출력용 클래스를 위한 enum

###### 🔘LOTTO_BUY_MONEY

###### 🔘LOTTO_BUY_COMPLETE

###### 🔘LOTTO_NUM_REQUEST

###### 🔘BONUS_NUM_REQUEST

###### 🔘WIN_STATISTIC

###### 🔘WIN_STATISTIC_3

###### 🔘WIN_STATISTIC_4

###### 🔘WIN_STATISTIC_5

###### 🔘WIN_STATISTIC_5_BONUS

###### 🔘WIN_STATISTIC_6

###### 🔘WIN_STATISTIC_COUNT

###### 🔘TOTAL_PROFIT_1

###### 🔘TOTAL_PROFIT_2

###### 🔘NEXT_LINE

###### ⚫️ message 변수

###### getMessage 함수 :  출력용 메세지 반환



##### 🟢 OutputView class (player 구현)

출력용 클래스

###### printLottoBuy() 함수 : 구입 금액 입력 메세지 출력

###### printLottoBuyComplete() 함수 :  로또 구입 개수 메세지 출력

###### printLottoNums() 함수 :  로또 번호 묶음 메세지 오름차순 출력

###### printLottoNumRequest() 함수 :  당청 번호 요청 메세지 출력

###### printBonusNumRequest() 함수 : 보너스 번호 요청 메세지 출력

###### printWinStatistic() 함수  : 당첨 통계 메세지 출력

###### printWinStatisticTitle() 함수  : 당첨 통계 타이틀 메세지 출력

###### printWinStatistic3() 함수  : 당첨 통계 3개 일치 메세지 출력

######  printWinStatistic4() 함수  : 당첨 통계 4개 일치 메세지 출력

###### printWinStatistic5() 함수  : 당첨 통계 5개 일치 메세지 출력

###### printWinStatistic4() 함수  : 당첨 통계 5개,보너스 일치 메세지 출력

######  printWinStatistic6() 함수  :  당첨 통계 6개 일치 메세지 출력 p

###### rintWinStatistic6() 함수  : 수익률 메세지 출력

###### printWinStatistic6() 함수  : 줄바꿈 출력

------

### <u>🗂  controller package</u>

##### 🟢 LottoController class

전체 프로세스 담당 클래스 (로직 맨 위에)

###### controlLotto() 함수 : 로또 로직 컨트롤러

------

### <u>🗂  lotto package</u>

##### 🟢 Application class

###### main() 함수 : LottoController 클래스의 controlLotto 함수를 호출

