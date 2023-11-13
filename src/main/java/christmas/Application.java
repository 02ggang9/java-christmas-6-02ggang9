package christmas;

import christmas.controller.ChristmasController;
import christmas.global.AppConfig;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        ChristmasController christmasController = new ChristmasController();
//        christmasController.run();

        AppConfig.christmasController().run();

    }
}
