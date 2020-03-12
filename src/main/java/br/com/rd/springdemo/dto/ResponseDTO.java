package br.com.rd.springdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private boolean sucesso;
    private String mensagem;
    private List<? extends DTO> valores;
    private Exception exception;

    public static ResponseDTO sucesso(String mensagem, List<? extends DTO> valores) {
        return new ResponseDTO(true, mensagem, valores, null);
    }

    public static ResponseDTO sucesso(List<? extends DTO> valores) {
        return new ResponseDTO(true, null, valores, null);
    }

    public static ResponseDTO erro(String mensagem, Exception exception) {
        return new ResponseDTO(false, mensagem, null, exception);
    }

    public static ResponseDTO erro(String mensagem) {
        return new ResponseDTO(false, mensagem, null, null);
    }
}
