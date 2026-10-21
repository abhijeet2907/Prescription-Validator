package org.prescriptionValidator;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledValidator {

    @Autowired
    private PrescriptionValidator validator;

    @Scheduled(fixedRate = 30000)
    public void autoValidateSamplePrescription() {
        System.out.println("[" + LocalDateTime.now() + "] Running automated validation check...");

        Prescription sample = new Prescription();
        sample.setLeftEye(new EyeData(-1.5, -0.75, 90));
        sample.setRightEye(new EyeData(-2.0, -1.25, 85));

        ValidationResult result = validator.validate(sample);

        if (result.isValid()) {
            System.out.println("[" + LocalDateTime.now() + "] Sample prescription is VALID");
        } else {
            System.out.println("[" + LocalDateTime.now() + "] Sample prescription has errors:");
            result.getErrors().forEach(error -> System.out.println("  - " + error));
        }
    }
}
