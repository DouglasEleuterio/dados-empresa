package br.com.douglas.dadosempresainsertdata.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EnumPorteEmpresa {

    NAO_INFORMADO("00"),
    MICRO_EMPRESA("01"),
    EMPRESA_DE_PEQUENO_PORTE("03"),
    DEMAIS("05"),
    NAO_CADASTRADO("99");

    private String codigo;
    public static EnumPorteEmpresa fromCodigo(String codigo){
        for (EnumPorteEmpresa value : EnumPorteEmpresa.values()) {
            if(value.codigo.equals(codigo))
                return value;
        }
        return NAO_CADASTRADO;
    }
}
