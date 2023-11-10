package christmas.global;

public enum OutputMessage {

    EVENT_PREVIEW("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
