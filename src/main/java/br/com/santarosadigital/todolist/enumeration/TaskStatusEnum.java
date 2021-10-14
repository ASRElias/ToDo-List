package br.com.santarosadigital.todolist.enumeration;

public enum TaskStatusEnum {

    PENDING("PENDING"), COMPLETED("COMPLETED");

    private String value;

    TaskStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TaskStatusEnum getEnum(String value) {

        for(TaskStatusEnum t : values()) {
            if(value.equals(t.getValue())) {
                return t;
            }
        }

        throw new RuntimeException("Type not found.");
    }

}
