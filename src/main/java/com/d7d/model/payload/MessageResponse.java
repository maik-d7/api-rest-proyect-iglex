package com.d7d.model.payload;


import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Builder
public class MessageResponse <T> {
    private String message;
    private T datos;
    private String nombreTabla;

//    public MessageResponse(String message, T datos){
//        this.message = message;
//        this.datos = datos;
//        this.nombreTabla = datos.getClass().getSimpleName();
//    }
//
//    public MessageResponse(String message){
//        this.message = message;
//        this.datos = null;
//        this.nombreTabla = null;
//    }

}
