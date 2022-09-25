package com.bubble_dog.exception;

public enum RespuestaEstado {
    PROCESO_EXITOSO("Proceso Exitoso!", 200),
    CLIENTE_CREADO_CON_EXITO("Creación Exitosa!", 200),
    CLIENTE_ACTUALIZADO_CON_EXITO("Actualización Exitosa!", 200),
    DELETED("Eliminacion Exitosa!", 200),
    NO_EXISTE_EL_ID("No, existe el registro", 404),
    CLIENTE_YA_EXISTE("Hubo error en su petición.", 400),
    ERROR_DE_PETICION("Todos los campos son obligatorios", 400);

    private String message;
    private int i;
    // Constructor
    private RespuestaEstado(String message, int i) {
        this.message = message;
        this.i = i;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

