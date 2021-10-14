package br.com.santarosadigital.todolist.enumeration;

public enum ProfileEnum {

    ADMINISTRATOR("ADMINISTRATOR"),
    MANAGER("MANAGER"),
    OPERATOR("OPERATOR");

    private String value;

    ProfileEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ProfileEnum getEnum(String value) {

        for(ProfileEnum t : values()) {
            if(value.equals(t.getValue())) {
                return t;
            }
        }

        throw new RuntimeException("Profile not found.");
    }
}
