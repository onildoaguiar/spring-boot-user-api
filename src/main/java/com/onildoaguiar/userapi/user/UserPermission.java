package com.onildoaguiar.userapi.user;

import java.util.stream.Stream;

public enum UserPermission {

    ADMIN("0"),
    USER("1");

    private String code;

    public String getCode() {
        return code;
    }

    UserPermission(String code) {
        this.code = code;
    }

    public static UserPermission getFromCode(String code) {
        return Stream.of(UserPermission.values())
                .filter(t -> t.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
