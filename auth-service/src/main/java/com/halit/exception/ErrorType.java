package com.halit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {


    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    INVALID_TOKEN(2002, "Geçersiz Token", BAD_REQUEST),
    LOGIN_ERROR_WRONG(1000, "Kullanıcı adı yada şifre hatalı", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001, "Şifre gereksinimleri karşılamıyor, geçerli bir şifre giriniz", INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_ERROR(1002, "Geçerli bir kullanıcı adı giriniz. ", INTERNAL_SERVER_ERROR),
    USERNAME_DUPLICATE(1003, "Bu Kullanıcı adı zaten kullanılıyor.", INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(1004, "Kullanıcı bulunamadı", INTERNAL_SERVER_ERROR),
    AUTH_NOT_CREATED(1005, "Araç KAYDEDİLEMEDİ", INTERNAL_SERVER_ERROR),
    VEHICLE_NOT_FOUND(1005, "Araç BULUNAMADI", INTERNAL_SERVER_ERROR),
    INVALID_ACTIVATE_CODE(1006, "Activate Code Bulunamdı", INTERNAL_SERVER_ERROR),
    ROLE_NOT_FOUND(1007, "Kullanıcı rolü bulunamadı", INTERNAL_SERVER_ERROR),
    USER_NOT_DELETED(1004, "Kullanıcı silinemedi", INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}