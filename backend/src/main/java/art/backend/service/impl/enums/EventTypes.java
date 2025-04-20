package art.backend.service.impl.enums;

public enum EventTypes {
    Fire("Fire"),
    Chemical("Chemical");

    private String name;
    private EventTypes(String name) {
        this.name = name;
    }
}
