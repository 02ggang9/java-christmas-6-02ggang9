package christmas.service;

import christmas.repository.ChristmasDateOfVisitRepository;

public class ChristmasService {

    private final ChristmasDateOfVisitRepository repository = new ChristmasDateOfVisitRepository();

    public void saveDateOfVisit(int dateOfVisit) {
        repository.saveDateOfVisit(dateOfVisit);
    }

    public Integer calculateTotalAmount() {


    }
}
