## Domain

- Badge
    - 이벤트 뱃지의 정보를 포함한다.
    - 기준에 맞는 뱃지의 정보를 반환한다.

- BenefitDetail
    - 이벤트 상세 정보들을 저장한다 [saveEventDetails()]
    - 단일 이벤트 상세 정보를 저장한다 [saveEvent()]
    - 총 혜택 금액을 반환한다 [getTotalBenefitPrice()]
    - 총 할인 금액을 반환한다 [getTotalDiscountPrice()]
    - 이벤트 상품을 저장한다 [setEventGoods()]

- Discount
    - 할인 금액을 계산하고 세부 할인 내역을 저장한다 [calculateDiscountAndSaveDetail()]
    - ChristmasDiscount
        - 크리스마스 세부 할인 금액을 계산한다 [calculateAndSave()]
    - SpecialDiscount
        - 특별 할인 금액을 계산한다 [calculateAndSave()]
    - WeekdayDiscount
        - 평일 세부 할인 금액을 계산한다 [calculateAndSave()]
    - WeekendDiscount
        - 주말 세부 할인 금액을 계산한다 [calculateAndSave()]

- DiscountPolicy
    - 할인 정책에 해당하는지 확인한다 [isSatisfiedBy()]

- Event
    - 이벤트 메뉴의 정보를 저장한다
    - 해당하는 이벤트 메뉴를 반환한다 [getGiveMenu()]

- MenuType
    - 이벤트 메뉴 정보를 저장한다

- OrderMenu
    - 주문 메뉴 정보를 저장한다
    - 주문 가격을 계산한다 [calculatePrice()]
    - 동일한 이름의 주문 메뉴를 반환한다 [fromMenuName()]

- OrderSheet
    - 주문서 총합을 계산한다 [calculateTotalPrice()]

## View

- 방문 날짜를 입력 받는다 [getUserDateOfVisit()]
- 주문 메뉴를 입력 받는다 [getUserOrderMenu()]
- 이벤트 안내 문구를 출력한다 [printEventInformation()]
- 할인 전 총 금액을 출력한다 [printTotalAmountBeforeDiscount()]
- 이벤트 상품을 출력한다 [printGiveMenu()]
- 세부 할인 내역을 출력한다 [printBenefitDetails()]
- 총 할인 금액을 출력한다 [totalDiscountAmount()]
- 할인 후 총 금액을 출력한다 [printAfterDiscountAmount()]
- 해당하는 이벤트 뱃지를 출력한다 [printEventBadge()]
- 주문 메뉴를 출력하고 개수를 출력한다 [printOrderMenusAndCounts()]

## Controller

- 산타 할인 게임의 전체적인 프로세스를 처리한다 [run()]

## Service

- 주문 합계 금액을 계산한다 [calculateTotalAmount()]
- 데이터베이스에 저장된 주문 메뉴를 탐색한다 [findOrderSheet()]
- 기준에 맞는 뱃지를 탐색한다 [findBadge()]

## Repository

- 이용자의 주문 메뉴를 데이터베이스에 저장한다.
