package org.prescriptionValidator;

import org.springframework.stereotype.Component;

@Component
public class PrescriptionValidator {

    private static final double MIN_SPH = -20.0;
    private static final double MAX_SPH = 20.0;
    private static final double MIN_CYL = -6.0;
    private static final double MAX_CYL = 6.0;
    private static final int MIN_AXIS = 0;
    private static final int MAX_AXIS = 180;

    public ValidationResult validate(Prescription prescription) {
        ValidationResult result = new ValidationResult();
        result.setValid(true);

        if (prescription.getLeftEye() != null) {
            validateEye(prescription.getLeftEye(), "Left eye", result);
        } else {
            result.addError("Left eye data is missing");
        }

        if (prescription.getRightEye() != null) {
            validateEye(prescription.getRightEye(), "Right eye", result);
        } else {
            result.addError("Right eye data is missing");
        }

        return result;
    }

    private void validateEye(EyeData eye, String eyeName, ValidationResult result) {
        if (eye.getSph() == null) {
            result.addError(eyeName + " SPH is missing");
        } else {
            if (eye.getSph() < MIN_SPH || eye.getSph() > MAX_SPH) {
                result.addError(String.format("%s SPH (%.2f) is outside valid range [%.2f to %.2f]",
                        eyeName, eye.getSph(), MIN_SPH, MAX_SPH));
            }
        }

        if (eye.getCyl() == null) {
            result.addError(eyeName + " CYL is missing");
        } else {
            if (eye.getCyl() < MIN_CYL || eye.getCyl() > MAX_CYL) {
                result.addError(String.format("%s CYL (%.2f) is outside valid range [%.2f to %.2f]",
                        eyeName, eye.getCyl(), MIN_CYL, MAX_CYL));
            }
        }

        if (eye.getAxis() == null) {
            result.addError(eyeName + " Axis is missing");
        } else {
            if (eye.getAxis() < MIN_AXIS || eye.getAxis() > MAX_AXIS) {
                result.addError(String.format("%s Axis (%d) is outside valid range [%d to %d]",
                        eyeName, eye.getAxis(), MIN_AXIS, MAX_AXIS));
            }
        }
    }
}
