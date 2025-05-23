package art.backend.service.impl.enums;

public enum Chemicalparam {
    CHEMICALPARAM(30d),
    NEEDTOCHECK(20d);

    private Chemicalparam(Double param) {
        this.param = param;
    }

    private Double param;

    public Double getParam() {
        return param;
    }
}
