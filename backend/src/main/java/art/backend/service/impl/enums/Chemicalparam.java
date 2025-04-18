package art.backend.service.impl.enums;

public enum Chemicalparam {
    CHEMICALPARAM(45d);

    private Chemicalparam(Double param) {
        this.param = param;
    }

    private Double param;

    public Double getParam() {
        return param;
    }
}
