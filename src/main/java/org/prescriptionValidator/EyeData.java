package org.prescriptionValidator;

public class EyeData {
    private Double sph;
    private Double cyl;
    private Integer axis;

    public EyeData() {}

    public EyeData(Double sph, Double cyl, Integer axis) {
        this.sph = sph;
        this.cyl = cyl;
        this.axis = axis;
    }



    public Double getSph() {
        return sph;
    }

    public void setSph(Double sph) {
        this.sph = sph;
    }

    public Double getCyl() {
        return cyl;
    }

    public void setCyl(Double cyl) {
        this.cyl = cyl;
    }

    public Integer getAxis() {
        return axis;
    }

    public void setAxis(Integer axis) {
        this.axis = axis;
    }
}

