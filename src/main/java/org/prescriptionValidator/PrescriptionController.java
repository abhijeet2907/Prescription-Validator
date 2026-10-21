package org.prescriptionValidator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionValidator validator;

    @PostMapping("/validate")
    public ValidationResult validatePrescription(@RequestBody Prescription prescription) {
        return validator.validate(prescription);
    }
}
