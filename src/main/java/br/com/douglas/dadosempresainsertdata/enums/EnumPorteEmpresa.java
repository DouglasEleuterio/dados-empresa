package br.com.douglas.dadosempresainsertdata.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumPorteEmpresa {

    NAO_INFORMADO("00"),
    MICRO_EMPRESA("01"),
    EMPRESA_DE_PEQUENO_PORTE("03"),
    DEMAIS("05");

    String codigo;
}
