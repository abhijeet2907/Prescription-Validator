package org.prescriptionValidator;

public class Prescription {

    private EyeData leftEye;

    public EyeData getRightEye() {
        return rightEye;
    }

    public void setRightEye(EyeData rightEye) {
        this.rightEye = rightEye;
    }

    private EyeData rightEye;


    public Prescription() {
    }

    public Prescription(EyeData leftEye, EyeData rightEye) {
        this.leftEye = leftEye;
        this.rightEye = rightEye;
    }


    public EyeData getLeftEye() {
        return leftEye;
    }

    public void setLeftEye(EyeData leftEye) {
        this.leftEye = leftEye;
    }
}
