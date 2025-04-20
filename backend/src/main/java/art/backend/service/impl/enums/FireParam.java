package art.backend.service.impl.enums;

public enum FireParam {
    FIREPARAM(30d),
    NEEDTOCHECK(20d);

    private FireParam(Double param) {
        this.param = param;
    }

    private Double param;

    public Double getParam() {
        return param;
    }
}
